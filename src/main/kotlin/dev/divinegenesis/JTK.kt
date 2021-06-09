package dev.divinegenesis

import com.google.gson.Gson
import dev.divinegenesis.routes.AbilityScores
import dev.divinegenesis.routes.Monsters
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class JTK {
    init {
        Service().service
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}

data class Service(
    val service: LinkParse = ServiceGenerator.createService(LinkParse::class.java)
)

object ServiceGenerator {
    private const val BASE_URL = "https://www.dnd5eapi.co/api/"
    private val gson: Gson = Gson()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
    private var retrofit = builder.build()
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    private val httpClient = OkHttpClient.Builder()
    fun <S> createService(
        serviceClass: Class<S>
    ): S {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            builder.client(httpClient.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }
}

interface LinkParse {
    @GET("ability-scores/{abilityScore}")
    fun abilityScores(
        @Path("abilityScore") abilityScore: String
    ): Call<AbilityScores>

    @GET("monsters/{monster}")
    fun monsters(
        @Path("monster") monster: String
    ): Call<Monsters>

}
