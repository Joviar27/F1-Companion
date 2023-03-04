package com.example.f1companion

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.f1companion.databinding.AboutBinding
import com.example.f1companion.databinding.MainBinding
import jp.wasabeef.transformers.glide.RoundedCornersTransformation

class AboutActivity : AppCompatActivity(){
    private lateinit var binding:AboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this@AboutActivity)
            .load(R.drawable.profile)
            .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(13,0)))
            .placeholder(R.color.light_taupe)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.ivProfil)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}