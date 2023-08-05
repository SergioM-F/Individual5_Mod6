package cl.samf.individual5_mod6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.samf.individual5_mod6.R
import cl.samf.individual5_mod6.data.local.TerrenoEntity
import cl.samf.individual5_mod6.databinding.FragmentDetalleBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"


/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val terrenoViewModel: TerrenoViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        terrenoViewModel.terrenoIdLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.imageViewTerreno2.load(it.imagen)
            binding.textViewId.text = it.id
            binding.textViewTipo.text = it.tipo
            binding.textViewPrecio.text = it.precio.toString()
        }
        return binding.root
    }


}