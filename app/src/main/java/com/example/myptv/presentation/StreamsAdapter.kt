package com.example.myptv.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myptv.data.remote.model.Stream
import com.example.myptv.databinding.RowStreamBinding
import kotlin.properties.Delegates

@SuppressLint("NotifyDataSetChanged")
class StreamsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<Stream> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = RowStreamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StreamViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = if (list.isEmpty()) 0 else list.size

    private fun getItem(position: Int): Stream = list[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StreamViewHolder).onBind(getItem(position))
    }

    private inner class StreamViewHolder(private val itemBinding : RowStreamBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(stream: Stream) {
            itemBinding.textView.text = stream.toString()
        }
    }
}