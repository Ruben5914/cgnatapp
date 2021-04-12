package com.uc3m.apppoker.models

import com.uc3m.apppoker.viewModels.EncryptModel

 class Mano(


    var cartaAlta: String = "",
    var pareja:String = "",
    var doblePareja: String = "",
    var trio: String = "",
    var escalera: String = "",
    var color: String = "",
    var full: String = "",
    var poker: String = "",
    var escaleraColor: String = "",
    var escaleraReal: String = "",
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
    var IVescaleraReal: String= ""



){
    init{
        IVcartaAlta = EncryptModel.encryptData(cartaAlta.toString()).first.toString()
        cartaAlta =  EncryptModel.encryptData(cartaAlta.toString()).second.toString()

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
}

