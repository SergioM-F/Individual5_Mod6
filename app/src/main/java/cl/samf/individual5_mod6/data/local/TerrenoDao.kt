package cl.samf.individual5_mod6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.samf.individual5_mod6.data.remote.Terreno

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTerrenos (terrenosEntity: List<TerrenoEntity>)

    @Query("select * from tabla_terreno order by id ASC")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}