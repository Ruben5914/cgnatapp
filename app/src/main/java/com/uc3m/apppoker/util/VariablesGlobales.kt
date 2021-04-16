package com.uc3m.apppoker.util

class VariablesGlobales {
    companion object {

        var posicionCarta = 0


        var seleccionTotalCartasMesa = arrayOfNulls<String>(5)

        var jugadorGanador = arrayOfNulls<String>(2)
        var handGanadora = arrayOfNulls<String>(5)
        var seleccionTotalCartasJugadores = arrayOfNulls<String>(12)
        var resultado = ""



         fun traducirResultado(mano: String): String{
            if(mano == "high_card"){
                return "cartaAlta"
            }
            if(mano == "pair"){
                return "pareja"
            }
            if(mano == "two_pair"){
                return "doblePareja"
            }
            if(mano == "three_of_kind"){
                return "trio"
            }
            if(mano == "straight"){
                return "escalera"
            }
            if(mano == "flush"){
                return "color"
            }
            if(mano == "full_house"){
                return "full"
            }
            if(mano == "four_of_kind"){
                return "poker"
            }

            if(mano == "straight_flush"){
                return "escaleraColor"
            }
            if(mano == "royal_flush"){
                return "escaleraReal"
            }
            return ""


        }

        fun traducirResultadoBonito(mano: String): String{
            if(mano == "high_card"){
                return "Carta Alta"
            }
            if(mano == "pair"){
                return "Pareja"
            }
            if(mano == "two_pair"){
                return "Doble Pareja"
            }
            if(mano == "three_of_kind"){
                return "Trío"
            }
            if(mano == "straight"){
                return "Escalera"
            }
            if(mano == "flush"){
                return "Color"
            }
            if(mano == "full_house"){
                return "Full"
            }
            if(mano == "four_of_kind"){
                return "Poker"
            }

            if(mano == "straight_flush"){
                return "Escalera de Color"
            }
            if(mano == "royal_flush"){
                return "Escalera Real"
            }
            return ""


        }

        fun traducirCartas(cartas: Array<String?>): Array<String?> {
            var n = 0
            for (i in cartas) {

                if (i == "_0c") {
                    cartas[n] = "10C"
                }
                if (i == "_0d") {
                    cartas[n] = "10D"
                }
                if (i == "_0h") {
                    cartas[n] = "10H"
                }
                if (i == "_0s") {
                    cartas[n] = "10S"
                }
                if (i == "_2c") {
                    cartas[n] = "2C"
                }
                if (i == "_2d") {
                    cartas[n] = "2D"
                }
                if (i == "_2h") {
                    cartas[n] = "2H"
                }
                if (i == "_2s") {
                    cartas[n] = "2S"
                }
                if (i == "_3c") {
                    cartas[n] = "3C"
                }
                if (i == "_3d") {
                    cartas[n] = "3D"
                }
                if (i == "_3h") {
                    cartas[n] = "3H"
                }
                if (i == "_3s") {
                    cartas[n] = "3S"
                }
                if (i == "_4c") {
                    cartas[n] = "4C"
                }
                if (i == "_4d") {
                    cartas[n] = "4D"
                }
                if (i == "_4h") {
                    cartas[n] = "4H"
                }
                if (i == "_4s") {
                    cartas[n] = "4S"
                }
                if (i == "_5c") {
                    cartas[n] = "5C"
                }
                if (i == "_5d") {
                    cartas[n] = "5D"
                }
                if (i == "_5h") {
                    cartas[n] = "5H"
                }
                if (i == "_5s") {
                    cartas[n] = "5S"
                }
                if (i == "_6c") {
                    cartas[n] = "6C"
                }
                if (i == "_6d") {
                    cartas[n] = "6D"
                }
                if (i == "_6h") {
                    cartas[n] = "6H"
                }
                if (i == "_6s") {
                    cartas[n] = "6S"
                }
                if (i == "_7c") {
                    cartas[n] = "7C"
                }
                if (i == "_7d") {
                    cartas[n] = "7D"
                }
                if (i == "_7h") {
                    cartas[n] = "7H"
                }
                if (i == "_7s") {
                    cartas[n] = "7S"
                }
                if (i == "_8c") {
                    cartas[n] = "8C"
                }
                if (i == "_8d") {
                    cartas[n] = "8D"
                }
                if (i == "_8h") {
                    cartas[n] = "8H"
                }
                if (i == "_8s") {
                    cartas[n] = "8S"
                }
                if (i == "_9c") {
                    cartas[n] = "9C"
                }
                if (i == "_9d") {
                    cartas[n] = "9D"
                }
                if (i == "_9h") {
                    cartas[n] = "9H"
                }
                if (i == "_9s") {
                    cartas[n] = "9S"
                }
                if (i == "ac") {
                    cartas[n] = "AC"
                }
                if (i == "ad") {
                    cartas[n] = "AD"
                }
                if (i == "ah") {
                    cartas[n] = "AH"
                }
                if (i == "as") {
                    cartas[n] = "AS"
                }
                if (i == "jc") {
                    cartas[n] = "JC"
                }
                if (i == "jd") {
                    cartas[n] = "JD"
                }
                if (i == "jh") {
                    cartas[n] = "JH"
                }
                if (i == "js") {
                    cartas[n] = "JS"
                }
                if (i == "qc") {
                    cartas[n] = "QC"
                }
                if (i == "qd") {
                    cartas[n] = "QD"
                }
                if (i == "qh") {
                    cartas[n] = "QH"
                }
                if (i == "qs") {
                    cartas[n] = "QS"
                }
                if (i == "kc") {
                    cartas[n] = "KC"
                }
                if (i == "kd") {
                    cartas[n] = "KD"
                }
                if (i == "kh") {
                    cartas[n] = "KH"
                }
                if (i == "ks") {
                    cartas[n] = "KS"
                }
                n++
            }
            return cartas
        }

        fun traducirCartasInverso(cartas: Array<String?>): Array<String?> {
            var n = 0
            for (i in cartas) {

                if (i == "10C") {
                    cartas[n] = "_0c"
                }
                if (i == "10D") {
                    cartas[n] = "_0d"
                }
                if (i == "10H") {
                    cartas[n] = "_0h"
                }
                if (i == "10S") {
                    cartas[n] = "_0s"
                }
                if (i == "2C") {
                    cartas[n] = "_2c"
                }
                if (i == "2D") {
                    cartas[n] = "_2d"
                }
                if (i == "2H") {
                    cartas[n] = "_2h"
                }
                if (i == "2S") {
                    cartas[n] = "_2s"
                }
                if (i == "3C") {
                    cartas[n] = "_3c"
                }
                if (i == "3D") {
                    cartas[n] = "_3d"
                }
                if (i == "3H") {
                    cartas[n] = "_3h"
                }
                if (i == "3S") {
                    cartas[n] = "_3s"
                }
                if (i == "4C") {
                    cartas[n] = "_4c"
                }
                if (i == "4D") {
                    cartas[n] = "_4d"
                }
                if (i == "4H") {
                    cartas[n] = "_4h"
                }
                if (i == "4S") {
                    cartas[n] = "_4s"
                }
                if (i == "5C") {
                    cartas[n] = "_5c"
                }
                if (i == "5D") {
                    cartas[n] = "_5d"
                }
                if (i == "5H") {
                    cartas[n] = "_5h"
                }
                if (i == "5S") {
                    cartas[n] = "_5s"
                }
                if (i == "6C") {
                    cartas[n] = "_6c"
                }
                if (i == "6D") {
                    cartas[n] = "_6d"
                }
                if (i == "6H") {
                    cartas[n] = "_6h"
                }
                if (i == "6S") {
                    cartas[n] = "_6s"
                }
                if (i == "7C") {
                    cartas[n] = "_7c"
                }
                if (i == "7D") {
                    cartas[n] = "_7d"
                }
                if (i == "7H") {
                    cartas[n] = "_7h"
                }
                if (i == "7S") {
                    cartas[n] = "_7s"
                }
                if (i == "8C") {
                    cartas[n] = "_8c"
                }
                if (i == "8D") {
                    cartas[n] = "_8d"
                }
                if (i == "8H") {
                    cartas[n] = "_8h"
                }
                if (i == "8S") {
                    cartas[n] = "_8s"
                }
                if (i == "9C") {
                    cartas[n] = "_9c"
                }
                if (i == "9D") {
                    cartas[n] = "_9d"
                }
                if (i == "9H") {
                    cartas[n] = "_9h"
                }
                if (i == "9S") {
                    cartas[n] = "_9s"
                }
                if (i == "AC") {
                    cartas[n] = "ac"
                }
                if (i == "AD") {
                    cartas[n] = "ad"
                }
                if (i == "AH") {
                    cartas[n] = "ah"
                }
                if (i == "AS") {
                    cartas[n] = "as"
                }
                if (i == "JC") {
                    cartas[n] = "jc"
                }
                if (i == "JD") {
                    cartas[n] = "jd"
                }
                if (i == "JH") {
                    cartas[n] = "jh"
                }
                if (i == "JS") {
                    cartas[n] = "js"
                }
                if (i == "QC") {
                    cartas[n] = "qc"
                }
                if (i == "QD") {
                    cartas[n] = "qd"
                }
                if (i == "QH") {
                    cartas[n] = "qh"
                }
                if (i == "QS") {
                    cartas[n] = "qs"
                }
                if (i == "KC") {
                    cartas[n] = "kc"
                }
                if (i == "KD") {
                    cartas[n] = "kd"
                }
                if (i == "KH") {
                    cartas[n] = "kh"
                }
                if (i == "KS") {
                    cartas[n] = "ks"
                }
                n++
            }
            return cartas
        }
    }

}