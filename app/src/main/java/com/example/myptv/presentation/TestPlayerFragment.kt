package com.example.myptv.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myptv.R
import com.example.myptv.databinding.FragmentSecondBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


class TestPlayerFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val url = arguments?.getString("url") ?: ""
        Log.i("myptv", "url =$url")
        player = SimpleExoPlayer.Builder(requireContext().applicationContext).build()
        player?.let {
            binding.playerview.player = it
            it.playWhenReady = true
            it.setMediaSource(buildMediaSource(url))
            it.prepare()
        }
    }

    private fun releasePlayer() {
        player?.release()
        player = null
    }

    private fun buildMediaSource(url: String): MediaSource {
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        return HlsMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(url))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
    }
}