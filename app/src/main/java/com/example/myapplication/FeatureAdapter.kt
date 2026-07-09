package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemFeatureBinding

class FeatureAdapter : ListAdapter<Feature, FeatureAdapter.FeatureViewHolder>(FeatureDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val binding = ItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        val feature = getItem(position)
        holder.bind(feature)
    }

    class FeatureViewHolder(private val binding: ItemFeatureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(feature: Feature) {
            binding.featureTitle.text = feature.title
            binding.featureDescription.text = feature.description
            binding.featureIcon.setImageResource(feature.iconResId)
        }
    }

    class FeatureDiffCallback : DiffUtil.ItemCallback<Feature>() {
        override fun areItemsTheSame(oldItem: Feature, newItem: Feature): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Feature, newItem: Feature): Boolean {
            return oldItem == newItem
        }
    }
}
