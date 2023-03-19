package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class JobInfo(
    @JsonProperty("Level")
    val level: Int,
    @JsonProperty("UnlockedState")
    val unlockedState: JobState
)
