package com.raveline.landingpage.styles

import com.raveline.landingpage.components.iconBoxId
import com.raveline.landingpage.model.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LightInGray.rgb
            ).borderRadius(
                topLeft = 20.px,
                topRight = 20.px,
                bottomLeft = 20.px,
                bottomRight = 0.px,
            )
            .backgroundColor(Colors.White)
            .transition(
                CSSTransition(property = "border", duration = 600.ms),
                CSSTransition(property = "background", duration = 600.ms)
            )
    }

    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Double,
                color = Theme.Primary.rgb
            )
            .backgroundColor(Theme.Primary.rgb)
    }

    /*
    This rule is to modify attributes that are under the main attribute that is being changed
    * */
    cssRule(suffix = " > #$iconBoxId") {
        Modifier
            .backgroundColor(Colors.White)
            .transition(
                CSSTransition(property = "background", duration = 600.ms)
            )
    }

    cssRule(suffix = ":hover > #$iconBoxId") {
        Modifier.backgroundColor(Colors.WhiteSmoke)
    }

    cssRule(suffix = " > p") {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(property = "color", duration = 600.ms)
            )
    }

    cssRule(":hover > p") {
        Modifier
            .color(Colors.WhiteSmoke)
    }


}