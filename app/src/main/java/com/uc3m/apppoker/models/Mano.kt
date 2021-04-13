package com.uc3m.apppoker.models

import android.util.Log
import com.uc3m.apppoker.viewModels.EncryptModel
import okio.ByteString.Companion.toByteString
import okio.Utf8

data class Mano(var cartaAlta : Int = 0, var pareja : Int = 0, var doblePareja : Int = 0,
                var trio : Int = 0, var escalera : Int = 0, var color : Int = 0, var full : Int = 0,
                var poker : Int = 0, var escaleraColor : Int = 0, var escaleraReal : Int = 0)

/*
    var cartaAlta: String = "0",
    var pareja:String = "0",
    var doblePareja: String = "0",
    var trio: String = "0",
    var escalera: String = "0",
    var color: String = "0",
    var full: String = "0",
    var poker: String = "0",
    var escaleraColor: String = "0",
    var escaleraReal: String = "0",
    var prueba: String = "",
    var  IVcartaAlta: String= "",
    var IVpareja: String= "" ,
    var IVdoblePareja: String= "" ,
    var IVtrio: String = "",
    var IVescalera: String = "",
    var IVcolor: String= "" ,
    var IVfull: String = "",
    var IVpoker: String = "",
    var IVescaleraColor: String = "",
    var IVescaleraReal: String= "",





){
    init{


        IVcartaAlta = EncryptModel.encryptData(cartaAlta.toString()).first.decodeToString().toString()
        Log.e("eeeeeeeeee1", IVcartaAlta)
        cartaAlta =  EncryptModel.encryptData(cartaAlta.toString()).second.decodeToString().toString()

        IVpareja = EncryptModel.encryptData(pareja.toString()).first.toString()
        pareja =  EncryptModel.encryptData(pareja.toString()).second.toString()

        IVdoblePareja = EncryptModel.encryptData(doblePareja.toString()).first.toString()
        doblePareja =  EncryptModel.encryptData(doblePareja.toString()).second.toString()

        IVtrio = EncryptModel.encryptData(trio.toString()).first.toString()
        trio =  EncryptModel.encryptData(trio.toString()).second.toString()

        IVescalera = EncryptModel.encryptData(escalera.toString()).first.toString()
        escalera =  EncryptModel.encryptData(escalera.toString()).second.toString()

        IVcolor = EncryptModel.encryptData(color.toString()).first.toString()
        color =  EncryptModel.encryptData(color.toString()).second.toString()

        IVfull = EncryptModel.encryptData(full.toString()).first.toString()
        full =  EncryptModel.encryptData(full.toString()).second.toString()

        IVpoker = EncryptModel.encryptData(poker.toString()).first.toString()
        poker =  EncryptModel.encryptData(poker.toString()).second.toString()

        IVescaleraColor = EncryptModel.encryptData(escaleraColor.toString()).first.toString()
        escaleraColor  =  EncryptModel.encryptData(escaleraColor.toString()).second.toString()

        IVescaleraReal = EncryptModel.encryptData(escaleraReal.toString()).first.toString()
        escaleraReal =  EncryptModel.encryptData(escaleraReal.toString()).second.toString()




    }
}*/

