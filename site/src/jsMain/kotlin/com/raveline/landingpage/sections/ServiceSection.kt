package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.components.ServiceCard
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.EnumService
import com.raveline.landingpage.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ServiceSection() {
    Box(
        modifier = Modifier
            .id(EnumSection.Service.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 60.px)
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
            section = EnumSection.Service,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 3)) {
            EnumService.values().forEach { service ->
                ServiceCard(service)
            }
        }
    }
}