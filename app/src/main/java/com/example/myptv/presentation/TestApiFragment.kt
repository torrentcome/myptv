package com.example.myptv.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myptv.R
import com.example.myptv.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class TestApiFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val streamsViewModel: StreamsViewModel by viewModel()
    private var adapter = StreamsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.adapter = adapter
            buttonFirst.setOnClickListener {
                val bundle = Bundle()
                when {
                    else -> {
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_SecondFragment,
                            bundle
                        )
                    }
                }
            }
        }
        with(streamsViewModel) {
            lifecycleScope.launch { getData() }
            _successLiveData.observe(requireActivity()) {
                Log.i("myptv", "it = $it")
                adapter.submitList(it)
            }
        }
    }
}