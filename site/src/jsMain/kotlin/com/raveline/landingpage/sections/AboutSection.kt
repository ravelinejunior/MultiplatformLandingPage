package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

@Composable
fun AboutSection() {
    Box(
        modifier =
        Modifier
            .id(EnumSection.About.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 160.px),
        contentAlignment = Alignment.TopCenter
    ) {
        SectionTitle(
            section = EnumSection.About,
            alignment = Alignment.End
        )
    }
}