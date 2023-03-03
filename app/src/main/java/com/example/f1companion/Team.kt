package com.example.f1companion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    val name : String = "default",
    val thumbnailPic : String = "default",
    val shortOverview : String = "default",

    val fullName: String = "default",
    val headerPic : String = "default",
    val bannerPic : String = "default",
    val longOverview : String = "default",

    val bioBase : String = "default",
    val bioTeamChief : String = "default",
    val bioTechnical : String = "default",
    val bioChassis : String = "default",
    val bioPU : String = "default",
    val bioEntry : String = "default",
    val bioWC : String = "default",
    val bioHighest : String = "default",
    val bioPoles : String = "default",
    val bioFL : String = "default",

    val driver1Name : String = "default",
    val driver1Desc : String = "default",
    val driver1Pic : String = "default",
    val driver2Name : String = "default",
    val driver2Desc : String = "default",
    val driver2Pic : String = "default",

    val galleryPic1 : String = "default",
    val galleryPic2 : String = "default",
    val galleryPic3 : String = "default"
    ) : Parcelable