package com.example.myptv.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.example.myptv.R
import com.example.myptv.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class TestApiFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val streamsViewModel: StreamsViewModel by viewModel()
    private var adapter = StreamsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.adapter = adapter
            adapter.setOnClickListener(object : StreamsAdapter.OnClickListener {
                override fun onClick(position: Int) {
                    val bundle = Bundle()
                    if(adapter.currentList.size > 0){
                        bundle.putString("url", adapter.currentList[0].url)
                    }
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )
                }
            })
            progress.visibility = View.VISIBLE
            buttonFirst.setOnClickListener {
                val bundle = Bundle()
                if(adapter.currentList.size > 0){
                    bundle.putString("url", adapter.currentList[0].url)
                }
                findNavController().navigate(
                    R.id.action_FirstFragment_to_SecondFragment,
                    bundle
                )
            }
            with(streamsViewModel) {
                lifecycleScope.launch { getData() }
                successLiveData.observe(requireActivity()) {
                    Log.i("myptv", "it = $it")
                    progress.visibility = View.GONE
                    adapter.submitList(it)
                }
                messageLiveData.observe(requireActivity()) {

                }
                errorLiveData.observe(requireActivity()) {

                }
            }
        }
    }
}