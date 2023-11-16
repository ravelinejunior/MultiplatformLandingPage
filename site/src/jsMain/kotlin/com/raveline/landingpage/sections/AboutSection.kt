package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.components.SkillBar
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.EnumSkill
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.styles.AboutImageStyle
import com.raveline.landingpage.styles.AboutTextStyle
import com.raveline.landingpage.util.Constants
import com.raveline.landingpage.util.Constants.LATO_FONT_FAMILY
import com.raveline.landingpage.util.Constants.LOREM_IPSUM_LONG
import com.raveline.landingpage.util.ObserveViewportEntered
import com.raveline.landingpage.util.Res
import com.raveline.landingpage.util.animateNumber
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

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
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ).margin(
                right = if (breakpoint >= Breakpoint.MD) 12.px
                else 8.px
            )
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier()
                .fillMaxWidth(80.percent),
            src = Res.Image.about,
            description = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0, 0, 0, 0, 0) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {

        ObserveViewportEntered(
            sectionId = EnumSection.About.id,
            distanceFromTop = 260.0,
            onViewportEntered = {
                viewportEntered = true
                EnumSkill.values().forEach { skill ->
                    coroutineScope.launch {
                        animateNumber(
                            number = skill.percentage.value.toInt(),
                            onUpdate = {
                                animatedPercentage[skill.ordinal] = it
                            }
                        )
                    }
                }
            }
        )

        SectionTitle(
            section = EnumSection.About,
            alignment = Alignment.CenterHorizontally
        )

        P(
            attrs =
            AboutTextStyle
                .toModifier()
                .maxWidth(500.px)
                .margin(topBottom = 24.px)
                .fontFamily(LATO_FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(LOREM_IPSUM_LONG)
        }

        EnumSkill.values().forEach { skill ->
            SkillBar(
                index = skill.ordinal,
                name = skill.name,
                percentage = if (viewportEntered) skill.percentage else 0.percent,
                animatedPercent = if(viewportEntered) animatedPercentage[skill.ordinal] else 0
            )
        }
    }
}






















