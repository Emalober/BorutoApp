package com.emalober.borutoapp.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class BorutoApi(
    private val client: HttpClient
) {

    companion object {
        const val END_POINT_GET_ALL_HEROES = "/boruto/heroes"
        const val END_POINT_SEARCH_HEROES = "/boruto/heroes/search"
    }

    suspend fun getAllHeroes(
        page: Int = 1
    ): ApiResponse = client.get(END_POINT_GET_ALL_HEROES) {
        url {
            parameters.append("page", "$page")
        }
    }.body()

    suspend fun searchHeroes(
        name: String
    ): ApiResponse = client.get(END_POINT_SEARCH_HEROES) {
        url {
            parameters.append("name", "$name")
        }
    }.body()

//    suspend fun getAllHeroes(
//        userId: String
//    ): ApiResponse = client.get("$END_POINT_GET_USER_KTOR$userId")
//
//    suspend fun saveUser(user: UserEntity) {
//        client.post<UserEntity>("$END_POINT_POST_USER_KTOR") {
//            body = user
//        }
//    }
}