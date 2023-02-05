package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterLodestoneInfoResponse(
    @JsonProperty("Avatar")
    val avatar: String,
    @JsonProperty("ID")
    val id: Int
)