package com.emalober.borutoapp.di

import android.util.Log
import com.emalober.borutoapp.data.remote.BorutoApi
import com.emalober.borutoapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.net.InetSocketAddress
import java.net.Proxy
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIME_OUT = 60_000

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
            //proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("localhost", 8080))
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }

            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            url(BASE_URL)
        }
    }

    @Provides
    @Singleton
    fun provideBorutoApi(client: HttpClient): BorutoApi = BorutoApi(client)

}