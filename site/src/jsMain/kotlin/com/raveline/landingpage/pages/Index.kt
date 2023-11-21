package com.raveline.landingpage.pages

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.BackToTopButton
import com.raveline.landingpage.sections.AboutSection
import com.raveline.landingpage.sections.AchievementsSection
import com.raveline.landingpage.sections.ContactSection
import com.raveline.landingpage.sections.ExperienceSection
import com.raveline.landingpage.sections.FooterSection
import com.raveline.landingpage.sections.MainSection
import com.raveline.landingpage.sections.PortfolioSection
import com.raveline.landingpage.sections.ServiceSection
import com.raveline.landingpage.sections.TestimonialSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection()
            AboutSection()
            ServiceSection()
            PortfolioSection()
            AchievementsSection()
            TestimonialSection()
            ExperienceSection()
            ContactSection()
            FooterSection()
        }

        BackToTopButton()

    }
}
