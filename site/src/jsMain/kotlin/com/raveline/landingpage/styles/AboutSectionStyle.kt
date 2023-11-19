package com.raveline.landingpage.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@OptIn(ExperimentalComposeWebApi::class)
val AboutImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter {
                    grayscale(80.percent)
                }
            }
            .borderRadius(
                12.px
            )
            .rotate(0.deg)
            .transition(
                CSSTransition(
                    property = TransitionProperty.All,
                    duration = 600.ms
                ),
            )
    }
    hover {
        Modifier
            .styleModifier {
                filter {
                    grayscale(0.percent)
                }
            }
            .borderRadius(
                topLeft = 100.px,
                topRight = 100.px,
                bottomLeft = 100.px,
                bottomRight = 100.px,
            )
            .margin(right = 40.px)
            .rotate((16).deg)
    }
}

val AboutTextStyle by ComponentStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(CSSTransition(property = "opacity", duration = 600.ms))
    }

    hover {
        Modifier.opacity(100.percent)
    }
}