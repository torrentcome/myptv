package com.example.myptv.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myptv.R
import com.example.myptv.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TestApiFragment : Fragment() {
    private val streamsViewModel: StreamsViewModel by viewModel()
    private var adapter: StreamsAdapter? = null
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
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
//                        bundle.putString("link", adapter?.list?.get(0)?.url)
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_SecondFragment,
                            bundle
                        )
                    }
                }
            }
        }
        with(streamsViewModel) {
            _successLiveData.observe(requireActivity()) {
                adapter?.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        _binding = null
    }
}