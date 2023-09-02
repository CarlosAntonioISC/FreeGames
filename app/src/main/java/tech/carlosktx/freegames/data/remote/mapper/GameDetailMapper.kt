package tech.carlosktx.freegames.data.remote.mapper

import tech.carlosktx.freegames.data.remote.retrofit.response.GameDetailResponse
import tech.carlosktx.freegames.data.remote.retrofit.response.MinimumRequirementsResponse
import tech.carlosktx.freegames.data.remote.retrofit.response.ScreenshotsResponse
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.model.MinimumRequirements
import tech.carlosktx.freegames.domain.model.Screenshot

fun GameDetailResponse.toGameModel(): GameDetail {
    return GameDetail(
        id = this.id ?: 0,
        title = this.title.orEmpty(),
        thumbnail = this.thumbnail.orEmpty(),
        status = this.status.orEmpty(),
        shortDescription = this.shortDescription.orEmpty(),
        description = this.description.orEmpty(),
        game_url = this.game_url.orEmpty(),
        category = this.genre.toGenreModel(),
        platform = this.platform.orEmpty(),
        publisher = this.publisher.orEmpty(),
        developer = this.developer.orEmpty(),
        release_date = this.release_date.orEmpty(),
        minimumRequirements = this.minimumRequirements?.toMinimumRequirementsModel(),
        screenshots = this.screenshots?.map { it.toScreenshotsModel() } ?: emptyList()
    )
}

fun MinimumRequirementsResponse?.toMinimumRequirementsModel(): MinimumRequirements {
    return MinimumRequirements(
        os = this?.os.orEmpty(),
        processor = this?.processor.orEmpty(),
        memory = this?.memory.orEmpty(),
        graphics = this?.graphics.orEmpty(),
        storage = this?.storage.orEmpty()
    )
}

fun ScreenshotsResponse.toScreenshotsModel():Screenshot {
    return Screenshot(
        id = this.id ?: 0,
        image = this.image.orEmpty()
    )
}