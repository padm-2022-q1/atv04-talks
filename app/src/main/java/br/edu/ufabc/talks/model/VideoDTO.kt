package br.edu.ufabc.talks.model

import java.util.*

/**
 * A data transfer object for a video.
 * @property id the id
 * @property title the title
 * @property event the event name
 * @property duration the duration
 * @property recorded the date recorded
 * @property speaker the speaker name
 * @property source the origin URL of the video
 * @property poster the URL of the poster image
 * @property media the URL of the video element
 */
data class VideoDTO(
    val id: Long? = null,
    val title: String? = null,
    val event: String? = null,
    val duration: Long? = null,
    val recorded: Date? = null,
    val speaker: String? = null,
    val source: String? = null,
    val poster: String? = null,
    val media: String? = null,
) {
    private fun error(property: String): Nothing = throw Exception("Property $property should not be null")

    /**
     * Converts the data transfer object to the model object.
     * @return the model object
     */
    fun toVideo() = Video(
        id = id ?: error("id"),
        title = title ?: error("title"),
        event = event ?: error("event"),
        duration = duration ?: error("duration"),
        recorded = recorded ?: error("recorded"),
        speaker = speaker ?: error("speaker"),
        source = source ?: error("source"),
        poster = poster ?: error("poster"),
        media = media ?: error("media"),

    )
}
