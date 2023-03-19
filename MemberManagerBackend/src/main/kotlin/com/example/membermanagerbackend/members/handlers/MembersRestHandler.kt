package com.example.membermanagerbackend.members.handlers

import com.example.membermanagerbackend.members.model.Member
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

    fun createMember(request: MemberCreationRequest): Mono<ServerResponse> {
        val entity =
            memberService.save(Member(name = request.name, server = request.server, joinedDate = request.joinedDate))

        return ServerResponse.ok().body(fromProducer(entity, Member::class.java))
    }
}