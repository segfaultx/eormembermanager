package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterDetailResponse(
    @JsonProperty("Character")
    val characterInfo: CharacterInfo
)