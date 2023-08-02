package cl.samf.individual5_mod6.data.remote


import retrofit2.Response
import retrofit2.http.GET

interface TerrenoApi {

    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>


}