package com.example.f1companion

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.f1companion.databinding.*


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: DetailBinding

    companion object{
        const val EXTRA_TEAM = "default"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val team = if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra(EXTRA_TEAM, Team::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_TEAM)
        }

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (team != null) {
            Glide.with(this@DetailActivity)
                .load(team.headerPic)
                .transform(CenterCrop(), RoundedCorners(60))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeOverview.ivHeader)

            Glide.with(this@DetailActivity)
                .load(team.bannerPic)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeOverview.ivBanner)
            

            binding.includeOverview.tvNameTeam.text = team.fullName
            binding.includeOverview.tvDescTeam.text = team.longOverview

            binding.includeOverview.actionShare.setOnClickListener{
                val sendIntent = Intent(Intent.ACTION_SEND)
                sendIntent.putExtra(Intent.EXTRA_TEXT, team.pageLink)
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }

            binding.includeBio.tvValBase.text = team.bioBase
            binding.includeBio.tvValTeamChief.text = team.bioTeamChief
            binding.includeBio.tvValTechnical.text = team.bioTechnical
            binding.includeBio.tvValChassis.text = team.bioChassis
            binding.includeBio.tvValPU.text = team.bioPU
            binding.includeBio.tvValEntry.text = team.bioEntry
            binding.includeBio.tvValWC.text = team.bioWC
            binding.includeBio.tvValHighest.text = team.bioHighest
            binding.includeBio.tvValPole.text = team.bioPoles
            binding.includeBio.tvValFL.text = team.bioFL

            binding.includeDriver.tvNameDriver1.text = team.driver1Name
            binding.includeDriver.tvDescDriver1.text = team.driver1Desc
            Glide.with(this@DetailActivity)
                .load(team.driver1Pic)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeDriver.ivDriver1)

            binding.includeDriver.tvNameDriver2.text = team.driver2Name
            binding.includeDriver.tvDescDriver2.text = team.driver2Desc
            Glide.with(this@DetailActivity)
                .load(team.driver2Pic)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeDriver.ivDriver2)

            Glide.with(this@DetailActivity)
                .load(team.galleryPic1)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeGallery.ivPic1)

            Glide.with(this@DetailActivity)
                .load(team.galleryPic2)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeGallery.ivPic2)

            Glide.with(this@DetailActivity)
                .load(team.galleryPic3)
                .transform(CenterCrop(), RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.includeGallery.ivPic3)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}