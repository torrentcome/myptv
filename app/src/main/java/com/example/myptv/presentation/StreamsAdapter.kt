package com.example.myptv.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myptv.domain.model.Stream
import com.example.myptv.databinding.RowStreamBinding

@SuppressLint("NotifyDataSetChanged")
class StreamsAdapter : ListAdapter<Stream, StreamsAdapter.StreamViewHolder>(myDiffUtil) {
    override fun onBindViewHolder(holder: StreamViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class StreamViewHolder(private val itemBinding : RowStreamBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(stream: Stream) {
            itemBinding.textView.text = stream.toString()
        }
    }

    private object myDiffUtil: DiffUtil.ItemCallback<Stream>() {
        override fun areItemsTheSame(oldItem: Stream, newItem: Stream): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stream, newItem: Stream): Boolean {
            return oldItem.channel == newItem.channel && oldItem.url == newItem.url
                    && oldItem.httpReferrer == newItem.httpReferrer && oldItem.userAgent == newItem.userAgent
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreamViewHolder {
        return StreamViewHolder(
            RowStreamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}