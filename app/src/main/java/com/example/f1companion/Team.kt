package com.example.f1companion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    val name : String,
    val thumbnailPic : String,
    val shortOverview : String,

    val fullName: String,
    val headerPic : String,
    val bannerPic : String,
    val longOverview : String,

    val bioBase : String,
    val bioTeamChief : String,
    val bioTechnical : String,
    val bioChassis : String,
    val bioPU : String,
    val bioEntry : String,
    val bioWC : String,
    val bioHighest : String,
    val bioPoles : String,
    val bioFL : String,

    val driver1Name : String,
    val driver1Desc : String,
    val driver2Name : String,
    val driver2Desc : String,

    val galleryPic1 : String,
    val galleryPic2 : String,
    val galleryPic3 : String
    ) : Parcelable