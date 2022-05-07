package br.edu.ufabc.talks.ui

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.edu.ufabc.talks.model.Repository
import br.edu.ufabc.talks.model.Video
import java.lang.Exception

/**
 * The list view model.
 */
class ListViewModel : ViewModel() {
    private val repository = Repository()

    /**
     * Async status.
     */
    sealed class Status {
        /**
         * Loading async status.
         */
        object Loading : Status()

        /**
         * Success async status.
         * @property result the result
         */
        data class Success(val result: Result): Status()

        /**
         * Failure async status.
         * @property e the throwable
         */
        data class Failure(val e : Exception): Status()
    }

    /**
     * A result wrapper.
     */
    sealed class Result {
        /**
         * A result that wraps a list of videos.
         * @property value the list of videos
         */
        data class VideosResult(val value: List<Video>): Result()

        /**
         * A result that wraps the poster bitmap.
         * @property value the bitmap
         */
        data class PosterResult(val value: Bitmap): Result()

    }

    /**
     * Async method to fetch a list of videos.
     * @return a live data of status
     */
    fun getAllVideos() = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.VideosResult(repository.getAll())))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to retrieve video list from repository", e)))
        }
    }

    /**
     * Async method to fetch a poster.
     * @return a live data of status
     */
    fun getPoster(videoId: Long) = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.PosterResult(repository.getPoster(videoId))))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to download poster for id $videoId", e)))
        }
    }
}
