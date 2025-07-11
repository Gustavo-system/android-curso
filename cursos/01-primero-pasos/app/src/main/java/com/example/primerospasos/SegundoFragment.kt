package com.example.primerospasos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.primerospasos.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {

    private var nombre: String? = ""
    private var edad:Int? = 0

    private lateinit var binding: FragmentSegundoBinding

    // creamos la vista
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSegundoBinding.inflate(layoutInflater, container, false)
        val view = binding.root
         //inflater.inflate(R.layout.fragment_segundo, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.tituloSegundoFragment.text = "$nombre - $edad"
        binding.tituloSegundoFragment.text = nombre.plus(" - $edad")
        binding.btnBack.setOnClickListener {
            val resultado = "Volvi desde el segundo fragment"
            setFragmentResult("requestKey", bundleOf("bundleResultKey" to resultado))
            activity?.onBackPressed()
        }
    }

    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newIntance(nombre:String, edad:Int) = SegundoFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }


}