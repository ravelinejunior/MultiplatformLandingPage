package com.raveline.landingpage.model

import com.raveline.landingpage.util.Res


enum class EnumPortfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "PetGram",
        description = "Web/Mobile App"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "CookingSmart",
        description = "Web/Mobile Ap"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}