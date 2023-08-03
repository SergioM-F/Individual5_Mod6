package cl.samf.individual5_mod6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.samf.individual5_mod6.data.Repositorio
import cl.samf.individual5_mod6.data.remote.Terreno
import cl.samf.individual5_mod6.data.remote.TerrenoApi
import cl.samf.individual5_mod6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val terrenoApi = TerrenoRetroFit.getRetrofitClient()
        repositorio = Repositorio(terrenoApi)
    }

    fun obtenerTerreno() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()
    }
}