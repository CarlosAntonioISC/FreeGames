package com.carlos.isc.freegames.domain.io.response

import com.google.gson.annotations.SerializedName

data class MinimumSystemRequirements (
	@SerializedName("os") val os : String?,
	@SerializedName("processor") val processor : String?,
	@SerializedName("memory") val memory : String?,
	@SerializedName("graphics") val graphics : String?,
	@SerializedName("storage") val storage : String?
)