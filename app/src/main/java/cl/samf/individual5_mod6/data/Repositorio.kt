package cl.samf.individual5_mod6.data

import androidx.lifecycle.LiveData
import cl.samf.individual5_mod6.data.local.TerrenoDao
import cl.samf.individual5_mod6.data.local.TerrenoEntity
import cl.samf.individual5_mod6.data.remote.Terreno
import cl.samf.individual5_mod6.data.remote.TerrenoApi

class Repositorio(private val terrenoApi: TerrenoApi, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()

    suspend fun cargarTerreno() {

        val respuesta = terrenoApi.getData()

        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.transformar() }
                terrenoDao.insertarTerrenos(terrenosEntity)
            }
        }

    }
    fun obtenerTerrenos(id:String): LiveData<TerrenoEntity> = terrenoDao.obtenerTerrenos(id)
}

fun Terreno.transformar(): TerrenoEntity =
    TerrenoEntity(this.id, this.precio, this.tipo, this.imagen)