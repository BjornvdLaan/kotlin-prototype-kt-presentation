package privatefields

typealias Minutes = Float

class Video(
    private val title: String,
    override val size: Megabytes,
    private val length: Minutes,
    override val creator: Creator,
    private val actors: List<String>
) : MultimediaItem(MultimediaItemType.VIDEO, size, creator) {

    override fun clone(): Video = Video(title, size, length, creator, actors)
}
