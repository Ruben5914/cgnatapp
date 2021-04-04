package com.uc3m.apppoker.views

import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.addCallback

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding

import com.uc3m.apppoker.models.Hand

import com.uc3m.apppoker.repository.RepositoryApi
import com.uc3m.apppoker.util.VariablesGlobales
import com.uc3m.apppoker.viewModels.ApiViewModel
import com.uc3m.apppoker.viewModels.MainViewModelFactory
import com.uc3m.apppoker.viewModels.UsuarioViewModel


class VisualizarCartasSeleccionadasFragment : Fragment() {


    private lateinit var apiViewModel: ApiViewModel

    private lateinit var binding: FragmentVisualizarCartasSeleccionadasBinding
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    val args: VisualizarCartasSeleccionadasFragmentArgs by navArgs()

    private var cartaSeleccionada = "ninguna"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        val repositoryApi = RepositoryApi()
        val viewModelFactory = MainViewModelFactory(repositoryApi)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ApiViewModel::class.java)
        super.onCreate(savedInstanceState)
        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        auth = FirebaseAuth.getInstance()

        binding = FragmentVisualizarCartasSeleccionadasBinding.inflate(inflater, container, false)
        val view = binding.root



        var mano: String
       /* binding.botonEnviarInfoApi.setOnClickListener() {
            mano = pedirDatosApi(viewModel)
            Log.d("Response -------->Despues de la funcion llamada a API:  ", mano)
            val usuario= Usuario  (0,"UsuarioRegistroGeneral")
            usuarioViewModel.addUsuario(usuario)


        }*/
        binding.BotonLogOut.setOnClickListener(){

            auth.signOut()
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
            googleSignInClient.signOut()

            //println(auth.currentUser?.email)
            //auth.signOut()

            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_principal)
        }



       // view.findViewById<ImageButton>(R.id.anadirCarta7).setVisibility(View.GONE)



        binding.anadirCarta1.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 1


        }
        binding.anadirCarta2.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 2


        }
        binding.anadirCarta3.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 3


        }
        binding.anadirCarta4.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 4


        }
        binding.anadirCarta5.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 5


        }
        binding.anadirCarta6.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 6


        }
        binding.anadirCarta7.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 7


        }

        binding.anadirCarta8.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 8


        }
        binding.anadirCarta9.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 9


        }
        binding.anadirCarta10.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 10


        }
        binding.anadirCarta11.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 11


        }
        binding.anadirCarta12.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 12


        }
        binding.anadirCarta13.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 13


        }
        binding.anadirCarta14.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 14


        }
        binding.anadirCarta15.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 15


        }
        binding.anadirCarta16.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 16


        }
        binding.anadirCarta17.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 17


        }
        binding.eliminar1.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasJugadores[0] = null
            VariablesGlobales.seleccionTotalCartasJugadores[1] = null
            view.findViewById<ImageButton>(R.id.anadirCarta6).setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta7).setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar2.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasJugadores[2] = null
            VariablesGlobales.seleccionTotalCartasJugadores[3] = null
            view.findViewById<ImageButton>(R.id.anadirCarta8).setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta9).setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar3.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasJugadores[4] = null
            VariablesGlobales.seleccionTotalCartasJugadores[5] = null
            view.findViewById<ImageButton>(R.id.anadirCarta10).setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta11).setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar4.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasJugadores[6] = null
            VariablesGlobales.seleccionTotalCartasJugadores[7] = null
            view.findViewById<ImageButton>(R.id.anadirCarta12).setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta13).setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar5.setOnClickListener(){
            VariablesGlobales.seleccionTotalCartasJugadores[8] = null
            VariablesGlobales.seleccionTotalCartasJugadores[9] = null
            view.findViewById<ImageButton>(R.id.anadirCarta14).setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta15).setBackgroundResource(R.drawable.addcard)
        }

        binding.botonSubmit.setOnClickListener(){

            var datosCorrectos =  comprobarCartas(VariablesGlobales.seleccionTotalCartasMesa,VariablesGlobales.seleccionTotalCartasJugadores)


            if (datosCorrectos){
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasJugadores)
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasMesa)
              //  mano = pedirDatosApi(viewModel)
               // Log.d("Response -------->Despues de la funcion llamada a API:  ", mano)
            }




        }

            cartaSeleccionada = args.CartasPicas



        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        colocarCarta()
        Log.d("Response -------->##########1?", VariablesGlobales.seleccionTotalCartasMesa[0].toString())
        Log.d("Response -------->##########2?", VariablesGlobales.seleccionTotalCartasMesa[1].toString())
        Log.d("Response -------->##########3?", VariablesGlobales.seleccionTotalCartasMesa[2].toString())
        Log.d("Response -------->##########4?", VariablesGlobales.seleccionTotalCartasMesa[3].toString())
        Log.d("Response -------->##########5?", VariablesGlobales.seleccionTotalCartasMesa[4].toString())
        Log.d("Response -------++++++++++++++++++++++++++++++++?", VariablesGlobales.seleccionTotalCartasMesa[0].toString())
        Log.d("Response -------->#########1?", VariablesGlobales.seleccionTotalCartasJugadores[0].toString())
        Log.d("Response -------->#########2?", VariablesGlobales.seleccionTotalCartasJugadores[1].toString())
        Log.d("Response -------->#########3?", VariablesGlobales.seleccionTotalCartasJugadores[2].toString())
        Log.d("Response -------->#########4?", VariablesGlobales.seleccionTotalCartasJugadores[3].toString())
        Log.d("Response -------->#########5?", VariablesGlobales.seleccionTotalCartasJugadores[4].toString())
        Log.d("Response -------->#########6?", VariablesGlobales.seleccionTotalCartasJugadores[5].toString())
        Log.d("Response -------->#########7?", VariablesGlobales.seleccionTotalCartasJugadores[6].toString())
        Log.d("Response -------->#########8?", VariablesGlobales.seleccionTotalCartasJugadores[7].toString())
        Log.d("Response -------->#########9?", VariablesGlobales.seleccionTotalCartasJugadores[8].toString())
        Log.d("Response -------->#########10?", VariablesGlobales.seleccionTotalCartasJugadores[9].toString())
        Log.d("Response -------->#########11?", VariablesGlobales.seleccionTotalCartasJugadores[10].toString())
        Log.d("Response -------->#########12?", VariablesGlobales.seleccionTotalCartasJugadores[11].toString())

    }


    override fun onPause() {
        super.onPause()
        var cartaSeleccionada = "Pausado"
        Log.d("Response -------->Fragmento devuelve:  ", cartaSeleccionada)
    }

    private fun colocarCarta(){


        if (VariablesGlobales.posicionCarta != 0){
            if (VariablesGlobales.posicionCarta <6) {

                VariablesGlobales.seleccionTotalCartasMesa[VariablesGlobales.posicionCarta - 1] = cartaSeleccionada


            }else{

                VariablesGlobales.seleccionTotalCartasJugadores[VariablesGlobales.posicionCarta - 6] = cartaSeleccionada

            }
            var n = 1
            for (i in VariablesGlobales.seleccionTotalCartasMesa) {

                if (i != null) {

                    view?.findViewById<ImageButton>(getResources().getIdentifier("anadirCarta" + n.toString(), "id", context?.getPackageName()))?.setBackgroundResource(getResources().getIdentifier(i, "drawable", context?.getPackageName()))
                }
                n++
            }
            var o = 6

            for (i in VariablesGlobales.seleccionTotalCartasJugadores) {

                if (i != null) {


                    view?.findViewById<ImageButton>(getResources().getIdentifier("anadirCarta" + o.toString(), "id", context?.getPackageName()))?.setBackgroundResource(getResources().getIdentifier(i, "drawable", context?.getPackageName()))

                }
                o++
            }


            VariablesGlobales.posicionCarta = 0

        }

    }




    fun pedirDatosApi(viewModel: ApiViewModel) :String {
       // var datos = binding.introducirCartas.text.toString()

       lateinit var  mano: String
         //mano = "nulo"


/*
                var mesa: List<String> = datos.toString().split('/')
                viewModel.getWinner(mesa.get(0), mesa.get(1))


                viewModel.responseWinner.observe(viewLifecycleOwner, Observer { response ->

                    if (response.isSuccessful) {
                        val ganadores = response.body()?.winners?.get(0)?.result
                        // displayText = "The winner hand is: {ganadores.}"
                        Log.d("Response --------> 1", "")

                        mano = ganadores.toString()
                        guardarEnBaseDatos(mano)
                        mostrarManosBaseDatos()
                        Log.d("Response -------->La API devuelve?", ganadores.toString())
                    } else {

                        Log.d("Response -------->>>>", response.code().toString())
                        Log.d("Response -------->>>>", response.errorBody().toString())


                    }

                })


*/
        return mano


    }

     fun onclick(V: View){
         var adapter = "yes"
         Log.d("Response --------oooooooo>>>>", adapter)
    }

    private fun mostrarManosBaseDatos() {
        //Log.d("Response -------->>>>", usuarioViewModel.findUsuario(0))
/*
        val adapter = ListAdapter()
        val recyclerView = binding.mostrarResultadoApi
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        usuarioViewModel.readAllHands.observe(viewLifecycleOwner,{
                hands -> adapter.setData( hands)
        })




*/
    }
    private fun guardarEnBaseDatos (hand:String){
        Log.d("Response --------> 2", "")
        val hand = Hand(0, 1, hand)
        usuarioViewModel.addHandToUser(hand)
    }

    private fun comprobarCartas(mesa: Array<String?>, jugadores: Array<String?>): Boolean{

        var contieneNull1 = false
        var contieneNull2 = false
        var finalPareja = false
        for( i in mesa){
            if (i == null){
                Toast.makeText(context, "Faltan cartas en la mesa", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        var todosNull = true
        for( i in jugadores){
            if (i != null){

                todosNull = false
            }
        }
        if (todosNull){
            Toast.makeText(context, "Añadir al menos un jugador", Toast.LENGTH_SHORT).show()
            return false
        }
        for ((n,i) in jugadores.withIndex()){
            if (n % 2 != 0){
                finalPareja = true
            }
            if(!finalPareja){
                contieneNull1 = ( i == null)
            }else {
                contieneNull2 = (i == null)
            }
            finalPareja = false


            if (n % 2 != 0){
                if (contieneNull1 != contieneNull2){
                    Toast.makeText(context, "Jugador mal introducido", Toast.LENGTH_SHORT).show()
                    return false
                }
            }

        }


        val cartas = arrayOfNulls<String>(mesa.size + jugadores.size)
        for ((n,i) in mesa.withIndex()){
            cartas[n] = i
        }
        var k = mesa.size
        for ((n,i) in jugadores.withIndex()){
            k += n
            cartas[k] = i
            k -= n
        }

        for((n, i) in cartas.withIndex()){
            for ((k, j) in cartas.withIndex()){
                if (n != k ){
                    if (i == j && i != null ){
                        Toast.makeText(context, "No puede haber cartas repetidas", Toast.LENGTH_SHORT).show()
                        return false
                    }
                }

            }
        }


        return true
    }





}

