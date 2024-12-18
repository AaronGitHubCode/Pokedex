package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class GenerationVI (

  @SerializedName("omegaruby-alphasapphire" ) var omegarubyalphasapphire : OmegarubyAlphasapphire? = OmegarubyAlphasapphire(),
  @SerializedName("x-y"                     ) var xy                    : XY?                     = XY()

)