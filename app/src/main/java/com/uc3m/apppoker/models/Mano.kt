package com.uc3m.apppoker.models

data class Mano(

    var cartaAlta: Int = 0,
    var pareja: Int = 0,
    var doblePareja: Int = 0,
    var trio: Int = 0,
    var escalera: Int = 0,
    var color: Int = 0,
    var full: Int = 0,
    var poker: Int = 0,
    var escaleraColor: Int = 0,
    var escaleraReal: Int = 0
)
