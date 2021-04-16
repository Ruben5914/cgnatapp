package com.uc3m.apppoker.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.google.errorprone.annotations.Var
import com.uc3m.apppoker.R

import com.uc3m.apppoker.databinding.FragmentGanadorBinding
import com.uc3m.apppoker.util.VariablesGlobales
import kotlin.math.log


class Ganador : Fragment() {
    private lateinit var binding: FragmentGanadorBinding

    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

         requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentGanadorBinding.inflate(inflater, container, false)
        val view = binding.root

        colocarCarta(view)
        colocarResultado(view)

        binding.NuevaConsulta.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasMesa = arrayOfNulls(5)
            VariablesGlobales.seleccionTotalCartasJugadores = arrayOfNulls(12)
            findNavController()
                    .navigate(R.id.action_Ganador_to_visualizarCartasSeleccionadasFragment)



        }



    return view
    }




private fun colocarCarta(view: View){

    var n = 1
    val seleccionTotalCartasMesaAux = arrayOfNulls<String>(5)
    VariablesGlobales.seleccionTotalCartasMesa.copyInto(seleccionTotalCartasMesaAux)
      VariablesGlobales.traducirCartasInverso(seleccionTotalCartasMesaAux)
              .copyInto(seleccionTotalCartasMesaAux)
        for (i in seleccionTotalCartasMesaAux) {

            if (i != null) {

                view.findViewById<ImageView>(getResources()
                        .getIdentifier("mesa" + n.toString(), "id", context
                        ?.getPackageName()))?.setImageResource(getResources()
                        .getIdentifier(i, "drawable", context?.getPackageName()))
            }
            n++
        }


    n = 1
    for (i in VariablesGlobales.traducirCartasInverso(VariablesGlobales.handGanadora)) {

        if (i != null) {

            view.findViewById<ImageView>(getResources()
                    .getIdentifier("mesag" + n.toString(), "id", context
                            ?.getPackageName()))?.setImageResource(getResources()
                    .getIdentifier(i, "drawable", context?.getPackageName()))
        }
        n++
    }
    n = 1
    for (i in VariablesGlobales.traducirCartasInverso(VariablesGlobales.jugadorGanador)) {

        if (i != null) {

            view.findViewById<ImageView>(getResources()
                    .getIdentifier("mano" + n.toString(), "id", context
                            ?.getPackageName()))?.setImageResource(getResources()
                    .getIdentifier(i, "drawable", context?.getPackageName()))
        }
        n++
    }





        VariablesGlobales.posicionCarta = 0



}

    private fun colocarResultado(view: View){
        val texto : TextView = view.findViewById(R.id.resultado)
        texto.text = "El resultado es "+ VariablesGlobales
                .traducirResultadoBonito(VariablesGlobales.resultado)
    }
}