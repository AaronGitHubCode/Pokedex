package app.go.pokemon

import com.google.gson.annotations.SerializedName


data class Forms (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)