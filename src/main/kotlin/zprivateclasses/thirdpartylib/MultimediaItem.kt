package zprivateclasses.thirdpartylib

typealias Megabytes = Float
typealias Minutes = Float

class Creator(val name: String)

enum class MultimediaItemType(val type: String) {
    VIDEO("video"), PHOTO("photo")
}

abstract class MultimediaItem(
    val type: MultimediaItemType,
    open val size: Megabytes,
    open val creator: Creator
) : Prototype {

    abstract override fun clone(): MultimediaItem
}

private class Photo(
    private val caption: String,
    override val size: Megabytes,
    private val pixels: Int,
    override val creator: Creator,
    private val persons: List<String>
) : MultimediaItem(MultimediaItemType.PHOTO, size, creator) {

    override fun clone(): Photo = Photo(caption, size, pixels, creator, persons)
}

private class Video(
    private val title: String,
    override val size: Megabytes,
    private val length: Minutes,
    override val creator: Creator,
    private val actors: List<String>
) : MultimediaItem(MultimediaItemType.VIDEO, size, creator) {

    override fun clone(): Video = Video(title, size, length, creator, actors)
}

class MultimediaCollectionRepository {
    private lateinit var collections: List<MultimediaCollection>

    init {
        val jane = Creator("Jane")
        val janesFriends = listOf("Laptop", "Meg", "Bob")
        val janesVideoTutorial = Video("Getting started with Python", 143.0f, 100.0f, jane, janesFriends)

        val peter = Creator("Peter")
        val petersFamily = listOf("Peter", "Wife", "Kid")
        val petersHolidayPicture = Photo("Family at East Harbour Restaurant", 12.2f, 53000, peter, petersFamily)

        val bjorn = Creator("Bjorn")
        val bjornsMultimediaCollection = MultimediaCollection(
            creator = bjorn,
            items = listOf(janesVideoTutorial, petersHolidayPicture)
        )

        collections = listOf(bjornsMultimediaCollection)
    }

    fun findAll(): List<MultimediaCollection> = collections
}