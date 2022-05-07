package br.edu.ufabc.talks.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.edu.ufabc.talks.databinding.FragmentVideoBinding
import br.edu.ufabc.talks.model.Video
import com.google.android.material.snackbar.Snackbar

/**
 * A fragment that renders video player, metadata and interactions.
 */
class VideoFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private val viewModel: VideoViewModel by viewModels()
    private val args: VideoFragmentArgs by navArgs()
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.styledPlayerView.player = viewModel.player
        progressBar = ProgressBar(binding.progressHorizontal)

        fetchVideo()
    }

    private fun fetchVideo() =
        viewModel.getById(args.videoId).observe(viewLifecycleOwner) { status ->
            when (status) {
                is VideoViewModel.Status.Loading -> progressBar.start()
                is VideoViewModel.Status.Failure -> {
                    Log.e("VIEW", "Failed to fetch video URL", status.e)
                    Snackbar.make(
                        binding.root, "Failed to stream video",
                        Snackbar.LENGTH_LONG
                    ).show()
                    progressBar.stop()
                }
                is VideoViewModel.Status.Success -> {
                    val result = (status.result as VideoViewModel.Result.VideoResult)

                    fillMetadata(result.value)
                    viewModel.setVideoUrl(result.value.media)
                    progressBar.stop()
                }
            }
        }

    private fun fillMetadata(video: Video) {
        binding.textviewTitle.text = video.title
        binding.textviewSpeaker.text = video.speaker
        binding.textviewEvent.text = video.event
        binding.textviewRecorded.text = video.formattedRecordedDate()
    }
}
