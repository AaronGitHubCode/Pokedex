package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class GenerationI (

  @SerializedName("red-blue" ) var redblue : RedBlue? = RedBlue(),
  @SerializedName("yellow"   ) var yellow   : Yellow?   = Yellow()

)