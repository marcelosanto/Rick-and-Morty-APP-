package xyz.spacermarcelo.rickandmorty.api.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: LocationData,
    val location: LocationData,
    val image: String,
    val episode: List<String>
)
