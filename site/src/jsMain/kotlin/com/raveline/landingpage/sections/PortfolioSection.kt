package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.PortfolioCard
import com.raveline.landingpage.components.SectionTitle
import com.raveline.landingpage.model.EnumPortfolio
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.styles.NavigationItemStyle
import com.raveline.landingpage.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

const val scrollableContainerId = "scrollableContainerId"

@Composable
fun PortfolioSection() {
    Box(
        modifier = Modifier
            .id(EnumSection.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 24.px),
            alignment = Alignment.CenterHorizontally,
            section = EnumSection.Portfolio
        )

        PortfolioCards(breakpoint)
        PortfolioNavigation()
    }
}

@Composable
fun PortfolioCards(breakpoint: Breakpoint) {
    Row(
        modifier = Modifier
            .id(scrollableContainerId)
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 960.px
                else if (breakpoint > Breakpoint.SM) 624.px
                else 360.px
            )
            .margin(
                bottom = 24.px
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
    ) {
        EnumPortfolio.values().forEach { portfolio ->
            PortfolioCard(
                modifier = Modifier.margin(right = if (portfolio != EnumPortfolio.Five) 24.px else 0.px),
                portfolio = portfolio,
            )
        }
    }
}

@Composable
fun PortfolioNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FaArrowLeft(
            modifier = NavigationItemStyle
                .toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById(scrollableContainerId)
                        ?.scrollBy(x = -324.0, y = 0.0)
                },
            size = IconSize.XL
        )

        FaArrowRight(
            modifier = NavigationItemStyle
                .toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById(scrollableContainerId)
                        ?.scrollBy(x = 324.0, y = 0.0)
                },
            size = IconSize.XL
        )
    }
}




















