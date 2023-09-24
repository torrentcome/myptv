package com.example.myptv.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myptv.R
import com.example.myptv.databinding.FragmentFirstBinding
import com.example.myptv.ext.isNetworkAvailable
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var adapter: StreamsAdapter? = StreamsAdapter()
    private val streamsViewModel: StreamsViewModel by viewModel()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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
        with(binding){
            buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
            recyclerView.adapter = adapter
        }
        with(streamsViewModel) {
            if (requireActivity().isNetworkAvailable()) {
                getStreams()
            } else {
                Toast.makeText(requireActivity(), "no network available", Toast.LENGTH_SHORT).show()
            }
            streamsData.observe(requireActivity()) {
                adapter?.list = it
            }
            messageData.observe(requireActivity()) {
                Toast.makeText(requireActivity(), "###: $it :###", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        _binding = null
    }
}