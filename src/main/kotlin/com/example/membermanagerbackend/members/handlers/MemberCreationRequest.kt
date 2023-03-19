package com.example.membermanagerbackend.members.handlers

import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class MemberCreationRequest(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,
    @field:NotBlank(message = "Server must not be empty")
    val server: String,
    val joinedDate: LocalDate
)