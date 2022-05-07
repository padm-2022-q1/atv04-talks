package br.edu.ufabc.talks.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.talks.databinding.ListFragmentBinding
import br.edu.ufabc.talks.databinding.TalkItemBinding
import br.edu.ufabc.talks.model.Video
import com.google.android.material.snackbar.Snackbar

/**
 * A Fragment that renders a list of videos.
 */
class ListFragment : Fragment() {
    private lateinit var binding: ListFragmentBinding
    private val viewModel: ListViewModel by viewModels()
    private lateinit var progressBar: ProgressBar

    /**
     * Adapter for a list of videos.
     */
    inner class VideoAdapter(private val videos: List<Video>) :
        RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

        /**
         * A ViewHolder for a video entry.
         */
        inner class VideoViewHolder(itemBinding: TalkItemBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {
            /**
             * the poster view.
             */
            val poster = itemBinding.imageviewTalkPoster

            /**
             * the title view.
             */
            val title = itemBinding.textviewTitle

            /**
             * the duration view.
             */
            val duration = itemBinding.textviewDuration

            init {
                itemBinding.root.setOnClickListener {
                    ListFragmentDirections.videoDetails(getItemId(bindingAdapterPosition)).let {
                        findNavController().navigate(it)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
            return VideoViewHolder(
                TalkItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
            val video = videos[position]

            viewModel.getPoster(video.id).observe(viewLifecycleOwner) { status ->
                when (status) {
                    is ListViewModel.Status.Loading -> progressBar.start()
                    is ListViewModel.Status.Failure -> {
                        Log.e("VIEW", "Failed to fetch poster", status.e)
                        Snackbar.make(
                            binding.root, "Failed to render poster",
                            Snackbar.LENGTH_LONG
                        ).show()
                        progressBar.stop()
                    }
                    is ListViewModel.Status.Success -> {
                        holder.poster.setImageBitmap((status.result as ListViewModel.Result.PosterResult).value)
                        progressBar.stop()
                    }
                }
            }
            holder.title.text = video.title
            holder.duration.text = video.formattedDuration()
        }

        override fun getItemCount(): Int = videos.size

        override fun getItemId(position: Int): Long = videos[position].id
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = ProgressBar(binding.progressHorizontal)

        viewModel.getAllVideos().observe(viewLifecycleOwner) { status ->
            when (status) {
                is ListViewModel.Status.Loading -> progressBar.start()
                is ListViewModel.Status.Failure -> {
                    Log.e("VIEW", "Failed to fetch metadata list", status.e)
                    Snackbar.make(
                        binding.root, "Failed to list items",
                        Snackbar.LENGTH_LONG
                    ).show()
                    progressBar.stop()
                }
                is ListViewModel.Status.Success -> {
                    binding.talkList.adapter =
                        VideoAdapter((status.result as ListViewModel.Result.VideosResult).value)
                    progressBar.stop()
                }
            }
        }
    }
}
