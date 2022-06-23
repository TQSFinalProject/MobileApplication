package com.example.chateauduvin.data

class Rider (
    val id : Number,
    val firstName : String,
    val lastName : String,
    val phone : String,
    val user : User,
    val riderPhoto: String,
    val latitude: Number,
    val longitude : Number,
    val ratings : Array<Number>,
    val ratingMean : Number

)
