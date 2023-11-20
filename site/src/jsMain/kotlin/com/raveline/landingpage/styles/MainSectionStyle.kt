@file:OptIn(ExperimentalComposeWebApi::class)

package com.raveline.landingpage.styles

import com.raveline.landingpage.model.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import kotlin.random.Random

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(property = "color", duration = 600.ms),
            )
    }
    anyLink {
        Modifier.color(Theme.Secondary.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
            .transition(
                CSSTransition(property = "color", duration = 600.ms),
            )
    }
}
val NavigationTextItemStyle by ComponentStyle {
    base {
        Modifier.color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(property = "color", duration = 500.ms),
            )
    }
    anyLink {
        Modifier.color(Theme.Secondary.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
            .fontWeight(FontWeight.Bolder)
            .transition(
                CSSTransition(property = "color", duration = 500.ms),
            )
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

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(CSSTransition(property = "color", duration = 500.ms))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(300.px)
            .fontWeight(FontWeight.Normal)
            .transition(
                CSSTransition(property = "width", duration = 500.ms),
                CSSTransition(property = "font-weight", duration = 500.ms)
            )
    }

    hover {
        Modifier.width(600.px)
            .fontWeight(FontWeight.Bold)
            .transition(
                CSSTransition(property = "width", duration = 500.ms),
                CSSTransition(property = "font-weight", duration = 500.ms)
            )
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter {
                    grayscale(100.percent)
                    borderRadius(r = 16.px)
                }
            }.transition(
                CSSTransition(property = "width", duration = 200.ms)
            )
    }
    hover {
        Modifier
            .styleModifier {
                filter {
                    grayscale(0.percent)
                }
            }
    }
}













