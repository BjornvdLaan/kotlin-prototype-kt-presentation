package zprivateclasses

import zprivateclasses.thirdpartylib.Creator
import zprivateclasses.thirdpartylib.MultimediaCollection
import zprivateclasses.thirdpartylib.MultimediaCollectionRepository
import zprivateclasses.thirdpartylib.Photo
import zprivateclasses.thirdpartylib.Video

/**
 * Our goal is to clone a multimedia collection.
 * Note: yes, we have an error. That's the point.
 */

fun cloneCollection(multimediaCollection: MultimediaCollection): MultimediaCollection {
    /**
     * Attempt without Prototype, but it doesn't work.
     * We cannot access the private classes.
     */

    val clonedList = multimediaCollection.items.map {

        //HELP, we cannot access the private classes. What should we do??
        if (it is Video) {
            Video("??", it.size, 0.0f, Creator("??"), listOf("??"))
        } else (it is Photo) {
            Photo("??", it.size, 0, Creator("??"), listOf("??"))
        } else {
        throw Exception("Unknown multimedia type")
    }
    }

    return MultimediaCollection(multimediaCollection.creator, clonedList)
}

fun main() {
    val bjornsMultimediaCollection = MultimediaCollectionRepository().findAll()[0]

    println("The prototype collection")
    printInfoAboutCollection(bjornsMultimediaCollection)

    println(
        """

        ---

    """.trimIndent()
    )

    val clonedItems = bjornsMultimediaCollection.clone()
    println("The cloned collection")
    printInfoAboutCollection(clonedItems)
}

fun printInfoAboutCollection(collection: MultimediaCollection) {
    println("Bjorn's collection: $collection")
    println("Bjorn's collectio is of class: ${collection::class.java.simpleName}")
    println("Bjorn himself: ${collection.creator}\n")

    println("Jane's video: ${collection.items[0]}")
    println("Jane's video is of class: ${collection.items[0]::class.java.simpleName}")
    println("Jane himself: ${collection.items[0].creator}\n")

    println("Peter's photo: ${collection.items[1]}")
    println("Peter's photo is of class: ${collection.items[1]::class.java.simpleName}")
    println("Peter himself: ${collection.items[1].creator}")
}