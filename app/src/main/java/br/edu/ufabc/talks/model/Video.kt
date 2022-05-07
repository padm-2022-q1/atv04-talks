package br.edu.ufabc.talks.model

import java.text.SimpleDateFormat
import java.util.*

/**
 * The video model object.
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
data class Video(
    val id: Long,
    val title: String,
    val event: String,
    val duration: Long,
    val recorded: Date,
    val speaker: String,
    val source: String,
    val poster: String,
    val media: String,
) {
    /**
     * Format the video duration.
     * @return the formatted duration
     */
    fun formattedDuration(): String = "%02d:%02d".format(duration / 60, duration % 60)

    /**
     * Format the recorded date.
     * @return the formatted date
     */
    fun formattedRecordedDate(): String = SimpleDateFormat("MMM yyyy", Locale.US).format(recorded)

    companion object {
        /**
         * Parse a date string to a date.
         * @param dateStr the date string
         * @return the date
         */
        fun parseDate(dateStr: String): Date? = SimpleDateFormat("MMM yyyy", Locale.US).parse(dateStr)
    }
}
