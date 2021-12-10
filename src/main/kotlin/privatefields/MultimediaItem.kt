package privatefields

typealias Megabytes = Float

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
