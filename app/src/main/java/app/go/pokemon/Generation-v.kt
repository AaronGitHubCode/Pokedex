package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class GenerationV (

  @SerializedName("black-white" ) var blackwhite : BlackWhite? = BlackWhite()

)