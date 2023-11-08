package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.Header
import com.raveline.landingpage.components.SocialBar
import com.raveline.landingpage.util.Constants.SECTION_WIDTH
import com.raveline.landingpage.util.Res
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun MainSection() {
    Box(
        modifier =
        Modifier.maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent()
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
fun MainContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        SocialBar()
    }
}