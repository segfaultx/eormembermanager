package com.example.membermanagerbackend.members.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Member(
    @Id
    var characterId: Int = 0,
    val name: String,
    val server: String,
    var avatarUri: String = "",
    var jobInfos: MutableSet<MemberJobInfo> = mutableSetOf()
)
