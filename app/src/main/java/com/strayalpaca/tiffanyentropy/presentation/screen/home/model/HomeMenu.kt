package com.strayalpaca.tiffanyentropy.presentation.screen.home.model

data class HomeMenu(
    val titleResourceId : Int,
    val descriptionTextResourceId : Int,
    val imageResourceId : Int,
    val onClick : () -> Unit = {}
)