package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class JobState(
    @JsonProperty("Name")
    val name: String
)
