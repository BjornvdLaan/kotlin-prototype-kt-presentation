package privatefields

class Photo(
    private val caption: String,
    override val size: Megabytes,
    private val pixels: Int,
    override val creator: Creator,
    private val persons: List<String>
) : MultimediaItem(MultimediaItemType.PHOTO, size, creator) {

    override fun clone(): Photo = Photo(caption, size, pixels, creator, persons)
}
