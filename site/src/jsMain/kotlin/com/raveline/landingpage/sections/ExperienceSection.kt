package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.ExperienceCard
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.model.EnumExperience
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() {
    Box(
        modifier =
        Modifier
            .id(EnumSection.Experience.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 60.percent
                    else 90.percent
                )
                .margin(bottom = 24.px),
            section = EnumSection.Experience
        )

        EnumExperience.values().forEach { experience ->
            ExperienceCard(
                breakpoint = breakpoint,
                active = (
                        experience == EnumExperience.First
                                || experience == EnumExperience.Fourth
                                || experience == EnumExperience.Sixth
                        ),
                experience = experience
            )
        }
    }
}










