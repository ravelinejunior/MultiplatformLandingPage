@file:OptIn(ExperimentalComposeWebApi::class)

package com.raveline.landingpage.styles

import com.raveline.landingpage.model.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import kotlin.random.Random

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(
                    property = "color", duration = 500.ms
                )
            )
    }
    anyLink {
        Modifier.color(Theme.Secondary.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val LogoStyle by ComponentStyle {
    base {
        Modifier.transform {
            rotate(0.deg)
        }.transition(
            CSSTransition(
                property = "transform", duration = 1000.ms
            )
        )
    }
    hover {
        Modifier.transform {
            rotate(
                Random.nextInt(360).deg
            )
        }
    }
}