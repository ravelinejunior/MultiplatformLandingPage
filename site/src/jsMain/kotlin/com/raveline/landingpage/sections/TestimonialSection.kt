package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.components.TestimonialCard
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.EnumTestimonial
import com.raveline.landingpage.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
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
fun TestimonialSection() {
    Box(
        modifier =
        Modifier
            .id(EnumSection.Testimonial.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 160.px),
        contentAlignment = Alignment.TopCenter
    ) {
        TestimonialContent()
    }
}

@Composable
fun TestimonialContent() {
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
            modifier = Modifier.margin(bottom = 24.px),
            section = EnumSection.Testimonial,
            alignment = Alignment.CenterHorizontally
        )
        Row(){
            TestimonialCard(testimonial = EnumTestimonial.First, breakpoint = breakpoint)
            TestimonialCard(testimonial = EnumTestimonial.Second, breakpoint = breakpoint)
        }
    }
}
