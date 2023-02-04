package com.example.membermanagerbackend.members.handlers

data class MemberCreationRequest(
    val name: String,
    val server: String
)