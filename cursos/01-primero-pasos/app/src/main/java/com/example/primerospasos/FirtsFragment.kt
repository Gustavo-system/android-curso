package com.example.primerospasos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class FirtsFragment : Fragment(R.layout.fragment_firts) {

    /*
    // agregando el R.layout.fragment_firts en el contrucctor nos ahorramos el onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firts, container, false)
    }*/

    // este onViewCreated es como el onCreate del activity donde podemos acceder a los campos del xml
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultFragmentTwo = view.findViewById<TextView>(R.id.resultFragmentTwo)
        val buttonGoSecondFragment = view.findViewById<Button>(R.id.btn_go_second_fragment)

        buttonGoSecondFragment.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                // se sobre ponen los fragmentos
                //add(R.id.fragment_container_view_tag, SegundoFragment())

                // retira el primer fragmento y deja el siguente
                //replace(R.id.fragment_container_view_tag, SegundoFragment())

                // enviamos la data al fragment
                replace(R.id.fragment_container_view_tag, SegundoFragment.newIntance("Pedro Panfilo Jimenez", 25))

                addToBackStack("PrimerFragment")
            }
        }

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("bundleResultKey")
            resultFragmentTwo.text = result
        }
    }

}