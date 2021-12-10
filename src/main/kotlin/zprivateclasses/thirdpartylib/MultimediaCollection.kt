package zprivateclasses.thirdpartylib

class MultimediaCollection(
    val creator: Creator,
    val items: List<MultimediaItem>
) : Prototype {

    override fun clone(): MultimediaCollection {
        val clonedList = this.items.map { it.clone() }
        return MultimediaCollection(this.creator, clonedList)
    }
}