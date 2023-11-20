package com.raveline.landingpage.styles

import com.raveline.landingpage.model.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val BoxEffectSectionStyle by ComponentStyle {
    base {
        Modifier
            .borderRadius(
                topRight = 20.px,
                topLeft = 20.px,
                bottomLeft = 20.px,
                bottomRight = 0.px,
            )
            .color(Theme.Secondary.rgb)
            .lineHeight(1.2)
            .backgroundColor(Theme.LightGray.rgb)
            .transition(
                CSSTransition(property = TransitionProperty.All, duration = 600.ms),
            )

    }
    hover {
        Modifier
            .borderRadius(
                topRight = 20.px,
                topLeft = 20.px,
                bottomLeft = 20.px,
                bottomRight = 20.px,
            )
            .backgroundColor(Theme.Primary.rgb)
            .color(Colors.White)
            .lineHeight(1.4)
            .fontWeight(FontWeight.Bold)
            .transition(
                CSSTransition(property = TransitionProperty.All, duration = 600.ms),
            )
    }
}