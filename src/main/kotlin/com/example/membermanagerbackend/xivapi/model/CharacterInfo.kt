package com.example.membermanagerbackend.xivapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterInfo (
    @JsonProperty("ClassJobs")
    val classJobs: List<JobInfo>
)