package com.uc3m.apppoker.util

class VariablesGlobales {
    companion object {

        var posicionCarta = 0
        var seleccionTotalCartasMesa = arrayOfNulls<String>(5)


        fun traducirCartas(cartas: Array<String>):Array<String> {
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

    }

}