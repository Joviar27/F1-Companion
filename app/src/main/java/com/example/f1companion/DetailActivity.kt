package com.example.f1companion

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.f1companion.databinding.DetailBinding
import com.example.f1companion.databinding.DetailBioBinding
import com.example.f1companion.databinding.DetailDriverBinding
import com.example.f1companion.databinding.DetailGalleryBinding
import com.example.f1companion.databinding.DetailOverviewBinding
import jp.wasabeef.transformers.glide.RoundedCornersTransformation

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: DetailBinding
    private lateinit var overviewBinding: DetailOverviewBinding
    private lateinit var bioBinding: DetailBioBinding
    private lateinit var driverBinding: DetailDriverBinding
    private lateinit var galleryBinding: DetailGalleryBinding

    companion object{
        const val EXTRA_TEAM = "default"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val team = if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra(EXTRA_TEAM, Team::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_TEAM)
        }

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        if (team != null) {
            Glide.with(this@DetailActivity)
                .load(team.headerPic)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(20,0)))
                .placeholder(R.color.light_taupe)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(overviewBinding.ivHeader)

            Glide.with(this@DetailActivity)
                .load(team.bannerPic)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(20,0)))
                .placeholder(R.color.taupe)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(overviewBinding.ivBanner)

            overviewBinding.tvNameTeam.text = team.fullName
            overviewBinding.tvDescTeam.text = team.longOverview

            bioBinding.tvValBase.text = team.bioBase
            bioBinding.tvValTeamChief.text = team.bioTeamChief
            bioBinding.tvValTechnical.text = team.bioTechnical
            bioBinding.tvValChassis.text = team.bioChassis
            bioBinding.tvValPU.text = team.bioPU
            bioBinding.tvValEntry.text = team.bioEntry
            bioBinding.tvValWC.text = team.bioWC
            bioBinding.tvValHighest.text = team.bioHighest
            bioBinding.tvValPole.text = team.bioPoles
            bioBinding.tvValFL.text = team.bioFL

            driverBinding.tvNameDriver1.text = team.driver1Name
            driverBinding.tvDescDriver1.text = team.driver1Desc
            Glide.with(this@DetailActivity)
                .load(team.driver1Pic)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(13,0)))
                .placeholder(R.color.whitish_gray)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(driverBinding.ivDriver1)

            driverBinding.tvNameDriver2.text = team.driver2Name
            driverBinding.tvDescDriver1.text = team.driver2Desc
            Glide.with(this@DetailActivity)
                .load(team.driver2Pic)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(13,0)))
                .placeholder(R.color.whitish_gray)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(driverBinding.ivDriver2)

            Glide.with(this@DetailActivity)
                .load(team.galleryPic2)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(13,0)))
                .placeholder(R.color.light_taupe)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(galleryBinding.ivPic2)

            Glide.with(this@DetailActivity)
                .load(team.galleryPic3)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(13,0)))
                .placeholder(R.color.light_taupe)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(galleryBinding.ivPic3)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}