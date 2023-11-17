package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.components.TestimonialCard
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.EnumTestimonial
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.util.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.ms
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
    var selectedPage by remember {
        mutableStateOf(0)
    }

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
                .margin(bottom = 24.px)
                .fillMaxWidth(),
            section = EnumSection.Testimonial,
            alignment = Alignment.CenterHorizontally
        )

        TestimonialCards(
            breakpoint = breakpoint,
            selectedPage = selectedPage
        )
        TestimonialNavigation(
            selectedPage = selectedPage,
            onPageSelected = { page ->
                selectedPage = page
            }
        )
    }
}

@Composable
fun TestimonialCards(
    breakpoint: Breakpoint,
    selectedPage: Int
) {
    val testimonial1 =
        listOf(
            EnumTestimonial.First,
            EnumTestimonial.Third,
            EnumTestimonial.Fifth,
        )

    val testimonial2 = listOf(
        EnumTestimonial.Second,
        EnumTestimonial.Fourth,
        EnumTestimonial.Sixth,
    )

    SimpleGrid(
        numColumns(base = 1, md = 2),
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ),
    ) {
        Box() {
            testimonial1.forEach { testimonial ->
                TestimonialCard(
                    modifier = Modifier
                        .margin(
                            right = if (breakpoint > Breakpoint.SM) 40.px else 0.px,
                            left = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                        )
                        .visibility(
                            setVisibility(
                                selectedPage = selectedPage,
                                testimonial = testimonial
                            )
                        )
                        .opacity(
                            setOpacity(
                                selectedPage = selectedPage,
                                testimonial = testimonial
                            )
                        )
                        .transition(
                            CSSTransition(property = "visibility", duration = 600.ms),
                            CSSTransition(property = "opacity", duration = 600.ms),
                        ),
                    testimonial = testimonial,
                    breakpoint = breakpoint
                )

            }
        }

        Box() {
            testimonial2.forEach { testimonial ->
                TestimonialCard(
                    modifier = Modifier
                        .margin(
                            right = if (breakpoint > Breakpoint.SM) 40.px else 0.px,
                            left = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                        )
                        .visibility(
                            setVisibility(
                                selectedPage = selectedPage,
                                testimonial = testimonial
                            )
                        )
                        .opacity(
                            setOpacity(
                                selectedPage = selectedPage,
                                testimonial = testimonial
                            )
                        )
                        .transition(
                            CSSTransition(property = "visibility", duration = 600.ms),
                            CSSTransition(property = "opacity", duration = 600.ms),
                        ),
                    testimonial = testimonial,
                    breakpoint = breakpoint
                )

            }
        }
    }
}

@Composable
fun TestimonialNavigation(
    selectedPage: Int,
    onPageSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(3) { index ->
            Box(
                modifier = Modifier
                    .margin(right = 12.px)
                    .cursor(Cursor.Pointer)
                    .size(12.px)
                    .borderRadius(52.px)
                    .backgroundColor(
                        if (selectedPage == index) Theme.Primary.rgb
                        else Theme.LightGray.rgb
                    )
                    .onClick {
                        onPageSelected(index)
                    }
            )

        }
    }
}


private fun setVisibility(
    selectedPage: Int,
    testimonial: EnumTestimonial
): Visibility {
    return when (testimonial) {
        EnumTestimonial.First -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 0) Visibility.Visible else Visibility.Hidden
        }

        EnumTestimonial.Second -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 0) Visibility.Visible else Visibility.Hidden
        }

        EnumTestimonial.Third -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 1) Visibility.Visible else Visibility.Hidden
        }

        EnumTestimonial.Fourth -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 1) Visibility.Visible else Visibility.Hidden
        }

        EnumTestimonial.Fifth -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 2) Visibility.Visible else Visibility.Hidden
        }

        EnumTestimonial.Sixth -> {
            println("Selected visibility testimonial ${testimonial.ordinal}")
            if (selectedPage == 2) Visibility.Visible else Visibility.Hidden
        }
    }
}

private fun setOpacity(
    selectedPage: Int,
    testimonial: EnumTestimonial
): CSSSizeValue<CSSUnit.percent> {
    return when (testimonial) {

        EnumTestimonial.First -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 0) 100.percent else 0.percent
        }

        EnumTestimonial.Second -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 0) 100.percent else 0.percent
        }

        EnumTestimonial.Third -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 1) 100.percent else 0.percent
        }

        EnumTestimonial.Fourth -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 1) 100.percent else 0.percent
        }

        EnumTestimonial.Fifth -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 2) 100.percent else 0.percent
        }

        EnumTestimonial.Sixth -> {
            println("Selected opacity testimonial ${testimonial.ordinal}")
            if (selectedPage == 2) 100.percent else 0.percent
        }

    }
}

















