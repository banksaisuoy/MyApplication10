package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.data.repository.MockDataRepository
import com.example.myapplication.databinding.FragmentDashboardBinding
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val repository = MockDataRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadDashboardStats()
    }

    private fun loadDashboardStats() {
        binding.progressBar.visibility = View.VISIBLE
        binding.llStats.visibility = View.GONE

        lifecycleScope.launch {
            val stats = repository.getDashboardStats()

            binding.tvUsersCount.text = stats["Users"] ?: "0"
            binding.tvRevenueAmount.text = stats["Revenue"] ?: "$0"
            binding.tvActivePercentage.text = stats["Active"] ?: "0%"

            binding.progressBar.visibility = View.GONE
            binding.llStats.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
