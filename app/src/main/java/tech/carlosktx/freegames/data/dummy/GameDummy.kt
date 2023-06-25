package tech.carlosktx.freegames.data.dummy

import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.Genre


val gameDummy1 = Game(
    id = 1,
    title = "Overwatch 2",
    description = "A hero-focused first-person team shooter from Blizzard Entertainment.",
    thumbnail = "https://www.freetogame.com/g/540/thumbnail.jpg",
    genre = Genre.SHOOTER
)

val gameDummy2 = Game(
    id = 2,
    title = "Diablo Immortal",
    description = "Built for mobile and also released on PC, Diablo Immortal fills in the gaps between Diablo II and III in an MMOARPG environment.",
    thumbnail = "https://www.freetogame.com/g/521/thumbnail.jpg",
    genre = Genre.SHOOTER
)

val gameDummy3 = Game(
    id = 3,
    title = "Lost Ark",
    description = "milegate’s free-to-play multiplayer ARPG is a massive adventure filled with lands waiting to be explored, people waiting to be met, and an ancient evil waiting to be destroyed.",
    thumbnail = "https://www.freetogame.com/g/517/thumbnail.jpg",
    genre = Genre.SHOOTER
)

val gamesDummy = listOf(
    gameDummy1,
    gameDummy2,
    gameDummy3
)