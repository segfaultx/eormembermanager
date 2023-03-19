package com.example.membermanagerbackend.rest

import jakarta.validation.ValidationException
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

class RestExceptionHandler {
    companion object {
        fun handleError(exception: Throwable): Mono<ServerResponse> {
            if (exception is ValidationException) return handleError(exception)

            return ServerResponse.status(HttpStatusCode.valueOf(500)).body(fromValue("Internal Server Error"))
        }

        private fun handleError(exception: ValidationException): Mono<ServerResponse> {
            return ServerResponse.badRequest().body(fromValue(exception.message!!))
        }
    }
}