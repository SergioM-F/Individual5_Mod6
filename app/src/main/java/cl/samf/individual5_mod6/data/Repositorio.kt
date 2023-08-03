package cl.samf.individual5_mod6.data

import cl.samf.individual5_mod6.data.remote.Terreno
import cl.samf.individual5_mod6.data.remote.TerrenoApi

class Repositorio (private val terrenoApi: TerrenoApi) {

    suspend fun cargarTerreno() :List<Terreno>{

        val respuesta = terrenoApi.getData()

        if(respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}