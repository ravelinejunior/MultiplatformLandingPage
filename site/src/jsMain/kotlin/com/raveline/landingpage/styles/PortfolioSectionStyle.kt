package com.raveline.landingpage.styles

import com.raveline.landingpage.components.boxParentId
import com.raveline.landingpage.components.columnParentId
import com.raveline.landingpage.components.greenOverlayId
import com.raveline.landingpage.components.imageBoxId
import com.raveline.landingpage.components.imageLinkIconId
import com.raveline.landingpage.components.textParagraphDescriptionId
import com.raveline.landingpage.components.textParagraphTitleId
import com.raveline.landingpage.model.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PortfolioSectionStyle by ComponentStyle {

    cssRule(" > #$columnParentId > #$boxParentId > #$greenOverlayId") {
        Modifier.width(0.px)
            .borderRadius(
                r = 20.px
            )
            .transition(
                CSSTransition(property = "width", duration = 600.ms),
                CSSTransition(property = "borderRadius", duration = 600.ms),
            )
    }

    cssRule(":hover > #$columnParentId > #$boxParentId > #$greenOverlayId") {
        Modifier.width(300.px)
            .borderRadius(
                r = 20.px
            ).transition(
                CSSTransition(property = "width", duration = 600.ms),
                CSSTransition(property = "borderRadius", duration = 600.ms),
            )
    }

    cssRule(" > #$columnParentId > #$boxParentId > #$greenOverlayId > #$imageBoxId") {
        Modifier
            .borderRadius(r = 16.px)
            .transition(
                CSSTransition(property = "borderRadius", duration = 600.ms)
            )
    }

    cssRule(":hover > #$columnParentId > #$boxParentId > #$greenOverlayId > #$imageBoxId") {
        Modifier.borderRadius(r = 100.percent)
    }

    cssRule(" > #$columnParentId > #$boxParentId > #$greenOverlayId > #$imageLinkIconId") {
        Modifier.visibility(Visibility.Hidden)

    }

    cssRule(":hover > #$columnParentId > #$boxParentId > #$greenOverlayId > #$imageLinkIconId") {
        Modifier.visibility(Visibility.Visible)
            .transition(
                CSSTransition(property = "visibility", duration = 600.ms)
            )
    }

    cssRule(" > #$columnParentId > #$textParagraphTitleId") {
        Modifier
            .color(Theme.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "color", duration = 600.ms),
                CSSTransition(property = "translate", duration = 600.ms),
            )
    }

    cssRule(":hover > #$columnParentId > #$textParagraphTitleId") {
        Modifier
            .translateX(10.percent)
            .color(Theme.Primary.rgb)
            .transition(
                CSSTransition(property = "translate", duration = 600.ms),
                CSSTransition(property = "color", duration = 600.ms),
            )
    }

    cssRule(" > #$columnParentId > #$textParagraphDescriptionId") {
        Modifier
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "translate", duration = 600.ms),
            )
    }

    cssRule(":hover > #$columnParentId > #$textParagraphDescriptionId") {
        Modifier
            .translateX(10.percent)
            .transition(
                CSSTransition(property = "translate", duration = 600.ms),
            )
    }

}

val PortfolioArrowIconStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(CSSTransition(property = "color", duration = 600.ms))
    }

    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}



















