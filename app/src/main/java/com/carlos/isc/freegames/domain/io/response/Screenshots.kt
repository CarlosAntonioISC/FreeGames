package com.carlos.isc.freegames.domain.io.response

import com.google.gson.annotations.SerializedName

data class Screenshots (
	@SerializedName("id") val id : Int?,
	@SerializedName("image") val image : String?
)