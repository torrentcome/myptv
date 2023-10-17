package com.example.myptv.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myptv.domain.model.Stream
import com.example.myptv.databinding.RowStreamBinding

class StreamsAdapter : ListAdapter<Stream, StreamsAdapter.StreamViewHolder>(StreamDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreamViewHolder {
        return StreamViewHolder(
            RowStreamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StreamViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class StreamViewHolder(private val itemBinding : RowStreamBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(position: Int) {
            val item = getItem(position)
            itemBinding.textView.text = item.toString()
        }
    }

    private object StreamDiff: DiffUtil.ItemCallback<Stream>() {
        override fun areItemsTheSame(oldItem: Stream, newItem: Stream): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stream, newItem: Stream): Boolean {
            return oldItem.channel == newItem.channel && oldItem.url == newItem.url
                    && oldItem.httpReferrer == newItem.httpReferrer && oldItem.userAgent == newItem.userAgent
        }
    }
}