package com.example.membermanagerbackend.members.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Member(
    @Id val id: MemberCompositeId
)
