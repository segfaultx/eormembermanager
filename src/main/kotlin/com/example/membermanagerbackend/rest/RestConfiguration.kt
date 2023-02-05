package com.example.membermanagerbackend.rest

import com.example.membermanagerbackend.members.handlers.MemberCreationRequest
import com.example.membermanagerbackend.members.handlers.MembersRestHandler
import com.example.membermanagerbackend.validation.MembersValidator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.router

@Configuration
class RestConfiguration(private val membersRestHandler: MembersRestHandler, private val validator: MembersValidator) {

    @Bean
    fun routes() = router {
        GET("/api/members").invoke(membersRestHandler::getMembers)
        POST("/api/members") {
            it.bodyToMono(MemberCreationRequest::class.java)
                .doOnSuccess{ mappedRequest -> validator.validate(mappedRequest) }
                .flatMap(membersRestHandler::createMember)
                .onErrorResume { error -> badRequest().body(fromValue(error)) }
        }
    }
}