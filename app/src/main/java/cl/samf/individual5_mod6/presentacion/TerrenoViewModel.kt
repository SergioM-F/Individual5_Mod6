package cl.samf.individual5_mod6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.samf.individual5_mod6.data.Repositorio
import cl.samf.individual5_mod6.data.local.TerrenoDatabase
import cl.samf.individual5_mod6.data.remote.Terreno
import cl.samf.individual5_mod6.data.remote.TerrenoApi
import cl.samf.individual5_mod6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio
    fun terrenosLiveData () = repositorio.obtenerTerrenos()

    init {
        val terrenoApi = TerrenoRetroFit.getRetrofitClient()
        val terrenoBaseDatos = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(terrenoApi,terrenoBaseDatos)
    }

    fun obtenerTerreno() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }
}