package br.edu.ufabc.talks.ui

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import br.edu.ufabc.talks.model.Repository
import br.edu.ufabc.talks.model.Video
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

/**
 * The video view model.
 */
class VideoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository()

    /**
     * the video player.
     */
    val player = ExoPlayer.Builder(application.applicationContext).build()

    private var currentVideoUrl: String? = null

    /**
     * Status types.
     */
    sealed class Status {
        /**
         * Loading status.
         */
        object Loading : Status()

        /**
         * Success status.
         * @property result the result
         */
        data class Success(val result: Result) : Status()

        /**
         * Failure status.
         * @property e the throwable
         */
        data class Failure(val e: Exception) : Status()
    }

    /**
     * Result class.
     */
    sealed class Result {
        /**
         * Result that wraps a video.
         * @property value the video
         */
        data class VideoResult(val value: Video) : Result()
    }

    /**
     * Get a video by id.
     * @param id the id
     */
    fun getById(id: Long) = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.VideoResult(repository.getById(id))))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to fetch URL for video $id", e)))
        }
    }

    /**
     * Set the video URL in the player.
     * @param url the video URL
     */
    fun setVideoUrl(url: String) {
        if (url != currentVideoUrl) {
            currentVideoUrl = url
            prepareVideo()
        }
    }

    private fun prepareVideo() {
        player.setMediaItem(MediaItem.fromUri(Uri.parse(currentVideoUrl)))
        player.playWhenReady = true
        player.prepare()
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}
