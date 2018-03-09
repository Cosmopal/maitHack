package com.example.satyamverma.scrapstore.data

import com.example.satyamverma.scrapstore.R
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: ArrayList<GarbageType> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, GarbageType> = HashMap()

    val imgs = ArrayList<Int>()

    val names = ArrayList<String>()

    val numITems = 3

    private val COUNT = 25

    init {
        // Add some sample items.
        imgs.add(R.drawable.ico_books)
        imgs.add(R.drawable.ico_cardboard)
        imgs.add(R.drawable.ico_plastic)

        names.add("Books")
        names.add("Cardboard")
        names.add("Plastic")

        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: GarbageType) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): GarbageType {
        var a = GarbageType(names.get(position% numITems), "Item $position", makeDetails(position))
        a.img_resource = imgs.get(position% numITems)
        return a
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
//            builder.append("\nMore details information here.")
            builder.append(i)
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    class GarbageType(val id: String, val content: String, val details: String) {

        var img_resource:Int? = null

        override fun toString(): String {
            return content
        }
        fun setResource(value:Int){
            img_resource  =value
        }
    }
}
