package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class GenerationIV (

  @SerializedName("diamond-pearl"        ) var diamondpearl        : DiamondPearl?        = DiamondPearl(),
  @SerializedName("heartgold-soulsilver" ) var heartgoldsoulsilver : HeartgoldSoulsilver? = HeartgoldSoulsilver(),
  @SerializedName("platinum"             ) var platinum             : Platinum?             = Platinum()

)