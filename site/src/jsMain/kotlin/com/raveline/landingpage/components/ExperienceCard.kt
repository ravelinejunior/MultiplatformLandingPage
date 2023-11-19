package com.raveline.landingpage.components

import androidx.compose.runtime.Composable
import com.raveline.landingpage.model.EnumExperience
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.util.Constants.LATO_FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: EnumExperience
) {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2),
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent
                else 90.percent
            ),
    ) {
        ExperienceDescription(
            active = active,
            description = experience.description
        )

        ExperienceDetails(
            breakpoint = breakpoint,
            active = active,
            experience = experience
        )
    }
}

@Composable
fun ExperienceDescription(
    active: Boolean,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 16.px)
            .padding(all = 16.px)
            .borderRadius(
                topRight = 20.px,
                topLeft = 20.px,
                bottomLeft = 20.px,
                bottomRight = 0.px,
            )
            .backgroundColor(if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        P(
            attrs =
            Modifier
                .margin(topBottom = 0.px)
                .fontFamily(LATO_FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Normal)
                .color(if (active) Colors.White else Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: EnumExperience
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(
                left = if (breakpoint >= Breakpoint.MD) 16.px else 0.px
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceBoxNumber(
                active = active,
                experience = experience
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs =
                Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(experience.jobPosition)
            }

            P(
                attrs =
                Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }

            P(
                attrs =
                Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
        }
    }
}

@Composable
fun ExperienceBoxNumber(
    active: Boolean,
    experience: EnumExperience
) {
    Box(
        modifier = Modifier
            .margin(right = 16.px)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(4.px)
                .backgroundColor(Theme.Primary.rgb)
        )
        Box(
            modifier = Modifier
                .size(40.px)
                .border(
                    width = 4.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .backgroundColor(if (active) Theme.Primary.rgb else Colors.White)
                .borderRadius(r = 48.percent),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs =
                Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Colors.White else Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }


}
























