package com.example.f1companion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.f1companion.databinding.ViewholderBinding

class TeamAdapter(
    private val TeamList : ArrayList<Team>,
    private val onItemClicked : (Int) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(var binding: ViewholderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ViewholderBinding.inflate(LayoutInflater.from(parent.context))
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val (name, thumbnailPic, shortOverview) = TeamList[position]
        holder.binding.tvTitle.text = name
        holder.binding.tvOverview.text = shortOverview

        Glide.with(holder.itemView.context)
            .load(thumbnailPic)
            .placeholder(R.color.dusty_beige)
            .into(holder.binding.ivThumbnail)

        holder.itemView.setOnClickListener {
            onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return TeamList.size
    }
}