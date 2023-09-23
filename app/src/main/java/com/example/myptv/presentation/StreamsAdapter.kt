package com.example.myptv.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myptv.data.model.Stream
import com.example.myptv.databinding.ActivityStreamsBinding
import com.example.myptv.databinding.FragmentFirstBinding
import kotlin.properties.Delegates

class StreamsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mStreamList: List<Stream> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = FragmentFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StreamViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = if (mStreamList.isNullOrEmpty()) 0 else mStreamList.size

    private fun getItem(position: Int): Stream = mStreamList[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StreamViewHolder).onBind(getItem(position))
    }

    private inner class StreamViewHolder(private val itemBinding : FragmentFirstBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(stream: Stream) {
            itemBinding.stream = stream
        }
    }
}