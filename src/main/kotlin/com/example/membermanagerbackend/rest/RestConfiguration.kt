package com.example.membermanagerbackend.rest

import com.example.membermanagerbackend.members.handlers.MembersRestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RestConfiguration(private val membersRestHandler: MembersRestHandler) {

    @Bean
    fun routes() = router {
        GET("/api").invoke(membersRestHandler::getMembers)
        POST("/api").invoke(membersRestHandler::createMember)
    }
}