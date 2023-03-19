package com.example.membermanagerbackend.members.service

import com.example.membermanagerbackend.members.model.Member
import com.example.membermanagerbackend.members.model.MemberRepository
import com.example.membermanagerbackend.xivapi.service.XIVApiDataFetchService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val xivApiDataFetchService: XIVApiDataFetchService
) {

    fun save(member: Member): Mono<Member> {
        return xivApiDataFetchService.fetchCharacterLodestoneDataForMember(member)
            .flatMap { _ -> memberRepository.save(member) }
    }

    fun findAll() = memberRepository.findAll()
}