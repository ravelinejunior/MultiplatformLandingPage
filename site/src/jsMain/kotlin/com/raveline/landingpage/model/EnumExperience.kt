package com.raveline.landingpage.model

import com.raveline.landingpage.util.Constants.LOREM_IPSUM_LONG


enum class EnumExperience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Kotlin Multi-Platform Developer",
        description = LOREM_IPSUM_LONG,
        company = "Google",
        from = "February 2022",
        to = "NOW",
    ),
    Second(
        number = "02",
        jobPosition = "Mobile Developer",
        description = LOREM_IPSUM_LONG,
        company = "Facebook",
        from = "January 2021",
        to = "October 2021",
    ),
    Third(
        number = "03",
        jobPosition = "Freelancer",
        description = LOREM_IPSUM_LONG,
        company = "Netflix",
        from = "March 2020",
        to = "August 2020",
    ),
    Fourth(
        number = "04",
        jobPosition = "Backend Developer",
        description = LOREM_IPSUM_LONG,
        company = "Instagram",
        from = "January 2021",
        to = "October 2021",
    ),
    Fifth(
        number = "05",
        jobPosition = "Mobile Flutter Developer",
        description = LOREM_IPSUM_LONG,
        company = "Linkedin",
        from = "January 2021",
        to = "October 2022",
    ),
    Sixth(
        number = "06",
        jobPosition = "Golang Developer",
        description = LOREM_IPSUM_LONG,
        company = "BMW",
        from = "January 2022",
        to = "October 2023",
    )
}