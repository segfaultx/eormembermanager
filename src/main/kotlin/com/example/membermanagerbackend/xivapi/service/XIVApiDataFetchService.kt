package com.example.membermanagerbackend.xivapi.service

import com.example.membermanagerbackend.members.model.Member
import com.example.membermanagerbackend.members.model.MemberJobInfo
import com.example.membermanagerbackend.members.model.XIVClass
import com.example.membermanagerbackend.xivapi.model.*
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class XIVApiDataFetchService {
    companion object {
        private const val XIV_API_BASE_URL = "https://xivapi.com"
        private const val XIV_CHARACTER_ENDPOINT = "/character/search?name=%s&server=%s"
        private const val XIV_CHARACTER_DETAILS_ENDPOINT = "/character/%d"
    }

    fun fetchCharacterLodestoneDataForMember(member: Member): Mono<Unit> {
        return getWebClient()
            .get()
            .uri(XIV_CHARACTER_ENDPOINT.format(member.name, member.server))
            .retrieve()
            .bodyToMono(CharacterLodestoneSearchResponse::class.java)
            .map { it.results[0] }
            .doOnSuccess { response -> mapLodestoneDetails(member, response) }
            .flatMap { fetchAndMapCharacterDetails(it.id, member) }
    }

    fun fetchAndMapCharacterDetails(characterId: Int, member: Member): Mono<Unit> {
        return getWebClient()
            .get()
            .uri(XIV_CHARACTER_DETAILS_ENDPOINT.format(characterId))
            .retrieve()
            .bodyToMono(CharacterDetailResponse::class.java)
            .map { detailResponse -> setClassDetails(member, detailResponse.characterInfo) }
    }

    private fun mapLodestoneDetails(member: Member, characterInfoResponse: CharacterLodestoneInfoResponse) {
        member.characterId = characterInfoResponse.id
        member.avatarUri = characterInfoResponse.avatar
    }

    private fun setClassDetails(member: Member, classDetails: CharacterInfo) {
        member.jobInfos.clear()
        classDetails.classJobs.forEach { jobInfo ->
            run {
                member.jobInfos.add(MemberJobInfo(XIVClass.fromString(jobInfo.unlockedState.name), jobInfo.level))
            }
        }
    }

    private fun getWebClient(): WebClient {
        return WebClient.builder().baseUrl(XIV_API_BASE_URL).build()
    }
}