package privatefields

/**
 * Our goal is to clone a multimedia collection.
 */
fun cloneCollection(multimediaCollection: MultimediaCollection): MultimediaCollection {
    /**
     * Attempt without Prototype, but it doesn't work.
     * Even if we can access the concrete classes, there are private fields.
     */

    val clonedList = multimediaCollection.items.map {

        //HELP, we cannot access the private values. What should we do??
        if (it is Video) {
            Video("??", it.size, 0.0f, Creator("??"), listOf("??"))
        } else {
            Photo("??", it.size, 0, Creator("??"), listOf("??"))
        }

    }

    return MultimediaCollection(multimediaCollection.creator, clonedList)
}

fun main() {
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
    println("Bjorn's collection is of class: ${collection::class.java.simpleName}")
    println("Bjorn himself: ${collection.creator}\n")

    println("Jane's video: ${collection.items[0]}")
    println("Jane's video is of class: ${collection.items[0]::class.java.simpleName}")
    println("Jane himself: ${collection.items[0].creator}\n")

    println("Peter's photo: ${collection.items[1]}")
    println("Peter's photo is of class: ${collection.items[1]::class.java.simpleName}")
    println("Peter himself: ${collection.items[1].creator}")
}