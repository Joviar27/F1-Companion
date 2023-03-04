package com.example.f1companion

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.f1companion.databinding.ViewholderBinding

class TeamAdapter(
    private val TeamList : ArrayList<Team>,
    private val onItemClicked : (Int) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(var binding: ViewholderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ViewholderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val (name, thumbnailPic, shortOverview) = TeamList[position]
        holder.binding.tvTitle.text = name
        holder.binding.tvOverview.text = shortOverview

        Glide.with(holder.itemView.context)
            .load(thumbnailPic)
            .placeholder(R.color.dusty_beige)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.binding.ivThumbnail)

        holder.itemView.setOnClickListener {
            onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return TeamList.size
    }
}