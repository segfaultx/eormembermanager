package com.example.membermanagerbackend.members.service

import com.example.membermanagerbackend.members.model.Member
import com.example.membermanagerbackend.members.model.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService (private val memberRepository: MemberRepository){

    fun save(member: Member) = memberRepository.save(member)

    fun findAll() = memberRepository.findAll()
}