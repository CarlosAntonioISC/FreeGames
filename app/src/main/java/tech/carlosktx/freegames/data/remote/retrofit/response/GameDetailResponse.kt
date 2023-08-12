package tech.carlosktx.freegames.data.remote.retrofit.response

import com.google.gson.annotations.SerializedName

data class GameDetailResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("game_url")
    val game_url: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("platform")
    val platform: String?,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("developer")
    val developer: String?,
    @SerializedName("release_date")
    val release_date: String?,
    @SerializedName("minimum_system_requirements")
    val minimumRequirements: MinimumRequirementsResponse?,
    @SerializedName("screenshots")
    val screenshots: List<ScreenshotsResponse>?
)

data class MinimumRequirementsResponse(
    @SerializedName("os")
    val os: String?,
    @SerializedName("processor")
    val processor: String?,
    @SerializedName("memory")
    val memory: String?,
    @SerializedName("graphics")
    val graphics: String?,
    @SerializedName("storage")
    val storage: String
)

data class ScreenshotsResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
)