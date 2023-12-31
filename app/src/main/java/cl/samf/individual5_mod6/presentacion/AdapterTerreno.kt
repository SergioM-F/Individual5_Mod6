package cl.samf.individual5_mod6.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.samf.individual5_mod6.R
import cl.samf.individual5_mod6.data.local.TerrenoEntity
import cl.samf.individual5_mod6.data.remote.Terreno
import cl.samf.individual5_mod6.databinding.FragmentListadoBinding
import cl.samf.individual5_mod6.databinding.ItemLayoutTerrenoBinding
import coil.load

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ViewHolder>() {

    lateinit var binding: ItemLayoutTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLayoutTerrenoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLayoutTerrenoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(terreno: TerrenoEntity){
            binding.imageViewTerreno.load(terreno.imagen)
            binding.imageViewTerreno.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id",terreno.id)
                Navigation.findNavController(binding.root).navigate(R.id.action_listadoFragment_to_detalleFragment, bundle)
            }
        }
    }

}