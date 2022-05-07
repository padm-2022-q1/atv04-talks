package br.edu.ufabc.talks.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.net.URL

/**
 * Repository for videos collections in Firestore.
 */
class Repository {
    private val db = Firebase.firestore

    companion object {
        private const val videoCollection = "videos"
    }

    private fun getCollection() = db.collection(videoCollection)

    /**
     * Get a list of videos.
     * @return the list of videos
     */
    suspend fun getAll(): List<Video> {
        if (isCollectionEmpty()) {
            populate()
        }

        return getCollection()
            .get()
            .await()
            .toObjects(VideoDTO::class.java)
            .map { it.toVideo() }
    }

    /**
     * Get the bitmap for a video poster.
     * @param videoId the video id
     * @return the bitmap
     */
    suspend fun getPoster(videoId: Long): Bitmap = getCollection()
        .document(videoId.toString())
        .get()
        .await()
        .toObject(VideoDTO::class.java)
        .let { video ->
            withContext(Dispatchers.IO) {
                runCatching {
                    BitmapFactory.decodeStream(URL(video?.poster).openStream())
                }.onFailure {
                    throw Exception("Failed to download poster for element with id $videoId")
                }.getOrThrow()
            }
        }

    /**
     * Get a video by id.
     * @param videoId the video id
     * @return the video
     */
    suspend fun getById(videoId: Long): Video = getCollection()
        .document(videoId.toString())
        .get()
        .await()
        .toObject(VideoDTO::class.java)?.toVideo()
        ?: throw Exception("Failed to find video with id $videoId")

    private suspend fun isCollectionEmpty() = getCollection()
        .get()
        .await()
        .size() == 0

    private suspend fun populate() = Dataset.videos.forEach { videoDto ->
        getCollection().document("${videoDto.id}").set(videoDto).await()
    }
}
