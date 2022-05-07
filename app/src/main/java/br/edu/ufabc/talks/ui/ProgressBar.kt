package br.edu.ufabc.talks.ui

import android.view.View
import com.google.android.material.progressindicator.LinearProgressIndicator

/**
 * A progress bar controller.
 */
class ProgressBar(private val view: LinearProgressIndicator) {
    private var attempts = 0

    /**
     * Start the progress bar.
     */
    fun start() {
        attempts++
        view.visibility = View.VISIBLE
    }

    /**
     * Stop the progress bar.
     */
    fun stop() {
        if (--attempts < 1) {
            view.visibility = View.INVISIBLE
        }
    }
}
