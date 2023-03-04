package com.example.f1companion

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.f1companion.databinding.MainBinding

class MainActivity : AppCompatActivity() {

    private val teamList = ArrayList<Team>()
    private lateinit var binding : MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvF1team.setHasFixedSize(true)
        teamList.addAll(getTeamList())

        showRecyclerView(teamList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.about_page){
            val moveToAbout = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(moveToAbout)
        }
        return super.onOptionsItemSelected(item)
    }

    //Mengambil data dari setiap tim secukupnya untuk meningkatkan performa
    private fun getTeamList() : ArrayList<Team>{
        val name = resources.getStringArray(R.array.thumbnail_title)
        val shortOverview = resources.getStringArray(R.array.thumbnail_overview)
        val thumbnailPic = resources.getStringArray(R.array.image_thumbnail)

        val teamList = ArrayList<Team>()

        for (index in name.indices) {
            teamList.add(
                Team(
                    name[index],
                    thumbnailPic[index],
                    shortOverview[index]
                )
            )
        }
        return teamList
    }

    private fun showRecyclerView(teamList : ArrayList<Team>){
        binding.rvF1team.layoutManager = LinearLayoutManager(this@MainActivity)
        val teamAdapter = TeamAdapter(teamList, onItemClicked = {
            toDetailPage(it)
        })
        binding.rvF1team.adapter = teamAdapter
    }

    private fun toDetailPage(position : Int){
        val team = getTeam(position)
        val moveWithTeam = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithTeam.putExtra(DetailActivity.EXTRA_TEAM,team)
    }

    //Mengambil data dari tim yang dipilih item recyclerview nya
    private fun getTeam(index: Int): Team {
        return Team(
            fullName = resources.getStringArray(R.array.detail_title)[index],
            headerPic = resources.getStringArray(R.array.image_header)[index],
            bannerPic = resources.getStringArray(R.array.image_banner)[index],
            longOverview = resources.getStringArray(R.array.detail_overview)[index],
            bioBase = resources.getStringArray(R.array.detail_team_base)[index],
            bioTeamChief = resources.getStringArray(R.array.detail_team_chief)[index],
            bioTechnical = resources.getStringArray(R.array.detail_team_technical)[index],
            bioChassis = resources.getStringArray(R.array.detail_team_chassis)[index],
            bioPU = resources.getStringArray(R.array.detail_team_PU)[index],
            bioEntry = resources.getStringArray(R.array.detail_team_entry)[index],
            bioWC = resources.getStringArray(R.array.detail_team_WC)[index],
            bioHighest = resources.getStringArray(R.array.detail_team_highest)[index],
            bioPoles = resources.getStringArray(R.array.detail_team_pole)[index],
            bioFL = resources.getStringArray(R.array.detail_team_FL)[index],
            driver1Name = resources.getStringArray(R.array.detail_driver1_name)[index],
            driver1Desc = resources.getStringArray(R.array.detail_driver1_overview)[index],
            driver1Pic = resources.getStringArray(R.array.image_driver1)[index],
            driver2Name = resources.getStringArray(R.array.detail_driver2_name)[index],
            driver2Desc = resources.getStringArray(R.array.detail_driver2_overview)[index],
            driver2Pic = resources.getStringArray(R.array.image_driver2)[index],
            galleryPic1 = resources.getStringArray(R.array.image_pic1)[index],
            galleryPic2 = resources.getStringArray(R.array.image_pic2)[index],
            galleryPic3 = resources.getStringArray(R.array.image_pic3)[index]
        )
    }
}