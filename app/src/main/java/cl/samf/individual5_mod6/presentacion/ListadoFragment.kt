package cl.samf.individual5_mod6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.samf.individual5_mod6.R
import cl.samf.individual5_mod6.databinding.FragmentListadoBinding


class ListadoFragment : Fragment() {

    lateinit var binding: FragmentListadoBinding
    private val terrenoViewModel: TerrenoViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoBinding.inflate(layoutInflater,container,false)
        initAdapter()
        binding.buttonCargar.setOnClickListener {
            terrenoViewModel.obtenerTerreno()
        }
        return binding.root
    }

    private fun initAdapter() {

        val adapter = AdapterTerreno()
        binding.recyclerViewTerrenos.adapter = adapter
        terrenoViewModel.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }


}


