package com.example.membermanagerbackend.members.handlers

import com.example.membermanagerbackend.members.model.Member
import com.example.membermanagerbackend.members.model.MemberCompositeId
import com.example.membermanagerbackend.members.service.MemberService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromProducer
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class MembersRestHandler(private val memberService: MemberService) {

    fun getMembers(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(fromProducer(memberService.findAll(), Member::class.java))
    }

    fun createMember(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(MemberCreationRequest::class.java)
            .map { Member(MemberCompositeId(it.name, it.server)) }
            .map { memberService.save(it) }
            .flatMap { ServerResponse.ok().body(it, Member::class.java) }
    }
}