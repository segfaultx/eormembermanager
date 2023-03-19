package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterLodestoneSearchResponse (
    @JsonProperty("Results")
    val results: List<CharacterLodestoneInfoResponse>)