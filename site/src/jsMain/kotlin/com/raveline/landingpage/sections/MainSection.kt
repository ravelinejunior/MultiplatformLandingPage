package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.Header
import com.raveline.landingpage.components.SocialBar
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.styles.MainButtonStyle
import com.raveline.landingpage.styles.MainImageStyle
import com.raveline.landingpage.util.Constants.LATO_FONT_FAMILY
import com.raveline.landingpage.util.Constants.LOREM_IPSUM_LONG
import com.raveline.landingpage.util.Constants.SECTION_WIDTH
import com.raveline.landingpage.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: () -> Unit) {
    Box(
        modifier =
        Modifier
            .id(EnumSection.Home.id)
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent(onMenuClicked = onMenuClicked)
    }
}

@Composable
fun MainBackground() {
    Image(
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
        src = Res.Image.background,
        description = "Background Image"
    )
}

@Composable
fun MainContent(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Header(onMenuClicked = onMenuClicked)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent
                ),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint)
                MainImage()
            }
        }

    }
}

@Composable
fun MainText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (breakpoint > Breakpoint.MD) {
            SocialBar()
        }
        Column {

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 46.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs(),
            ) {
                Text("Hello, I'm")
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 20.px, 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 68.px else 48.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs(),
            ) {
                Text("Franklin Júnior")
            }

            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs(),
            ) {
                Text("Native/Hybrid Mobile Developer.")
            }

            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs(),
            ) {
                Text("Automotive Android Engineer.")
            }

            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs(),
            ) {
                Text("Java/Kotlin/Web Developer")
            }

            P(
                attrs = Modifier
                    .margin(bottom = 24.px)
                    .maxWidth(400.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(16.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs(),
            ) {
                Text(LOREM_IPSUM_LONG)
            }

            Button(
                attrs = MainButtonStyle
                    .toModifier()
                    .height(60.px)
                    .border(width = 0.px)
                    .borderRadius(r = 8.px)
                    .fontWeight(FontWeight.Bolder)
                    .fontFamily(LATO_FONT_FAMILY)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(
                    modifier = Modifier
                        .color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None),
                    text = "Hire me",
                    path = EnumSection.Contact.path
                )
            }
        }
    }
}

@Composable
fun MainImage() {
    Column(
        Modifier.fillMaxSize(80.percent).fillMaxHeight().margin(top = 16.px)
    ) {
        Image(
            modifier = MainImageStyle
                .toModifier()
                .fillMaxWidth()
            ,
            src = Res.Image.car,
            description = "Main Image",
        )
    }
}
