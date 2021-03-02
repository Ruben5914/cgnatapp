package com.uc3m.apppoker.models

data class  contenido(
        var cards: String,
        var hand: String,
        var result: String
)

data class winners(

    //@SerializedName("nuevoNombre")
    val jugador : contenido
)

data class players(
    val mano: List<String>
)


/*
{
    winners: [
    {
        cards: "10S,8C",
        hand: "10S,JS,QH,KD,AC",
        result: "straight"
    }
    ],
    players: [
    {
        cards: "10S,8C",
        hand: "10S,JS,QH,KD,AC",
        result: "straight"
    },
    {
        cards: "3S,2C",
        hand: "7C,JS,QH,KD,AC",
        result: "high_card"
    },
    {
        cards: "QS,JH",
        hand: "JH,JS,QH,QS,AC",
        result: "two_pair"
    }
    ]
}*/