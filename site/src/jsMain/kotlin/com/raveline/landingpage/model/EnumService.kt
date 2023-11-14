package com.raveline.landingpage.model

import com.raveline.landingpage.util.Constants.LOREM_IPSUM_SHORTEST
import com.raveline.landingpage.util.Res


enum class EnumService(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = Res.Icon.android,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = LOREM_IPSUM_SHORTEST
    ),

    Golang(
        icon = Res.Icon.golang,
        imageDesc = "Golang Icon",
        title = "Golang",
        description = LOREM_IPSUM_SHORTEST
    ),
    Web(
        icon = Res.Icon.web,
        imageDesc = "Desktop Icon",
        title = "Web Development",
        description = LOREM_IPSUM_SHORTEST
    ),
    Design(
        icon = Res.Icon.design,
        imageDesc = "Pen Icon",
        title = "UX/UI Design",
        description = LOREM_IPSUM_SHORTEST
    ),
    Business(
        icon = Res.Icon.business,
        imageDesc = "Chart Icon",
        title = "Business Analysis",
        description = LOREM_IPSUM_SHORTEST
    ),
    SEO(
        icon = Res.Icon.seo,
        imageDesc = "Megaphone Icon",
        title = "SEO Marketing",
        description = LOREM_IPSUM_SHORTEST
    ),
}