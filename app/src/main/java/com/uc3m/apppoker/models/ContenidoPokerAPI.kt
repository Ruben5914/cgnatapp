package com.uc3m.apppoker.models

data class  contenido(
        var cards: String,
        var hand: String,
        var result: String
)


data class poker(

        val winners : List<contenido>,
        val players: List<contenido>
)


