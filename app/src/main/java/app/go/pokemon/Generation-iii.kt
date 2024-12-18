package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class GenerationIII (

  @SerializedName("emerald"           ) var emerald           : Emerald?           = Emerald(),
  @SerializedName("firered-leafgreen" ) var fireredleafgreen : FireredLeafgreen? = FireredLeafgreen(),
  @SerializedName("ruby-sapphire"     ) var rubysapphire     : RubySapphire?     = RubySapphire()

)