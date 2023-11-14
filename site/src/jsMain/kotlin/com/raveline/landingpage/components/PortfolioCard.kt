package com.raveline.landingpage.components

import androidx.compose.runtime.Composable
import com.raveline.landingpage.model.EnumPortfolio
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.styles.PortfolioSectionStyle
import com.raveline.landingpage.util.Constants
import com.raveline.landingpage.util.Constants.LINKEDIN_LINK
import com.raveline.landingpage.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


const val textParagraphTitleId: String = "textParagraphTitleId"
const val textParagraphDescriptionId: String = "textParagraphDescriptionId"
const val columnParentId = "columnParentId"
const val greenOverlayId = "greenBoxOverlayId"
const val imageLinkIconId = "imageLinkIconId"
const val boxParentId = "boxParentId"
const val imageBoxId = "imageBoxId"

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: EnumPortfolio,
    link: String = LINKEDIN_LINK
) {
    Link(
        modifier = PortfolioSectionStyle
            .toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        Column(
            modifier = modifier
                .id(columnParentId)
                .width(Width.MaxContent)
        ) {
            Box(
                modifier = Modifier
                    .id(boxParentId)
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier
                        .id(imageBoxId)
                        .borderRadius(r = 20.px)
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    description = "Portfolio Image"
                )

                Box(
                    modifier = Modifier
                        .id(greenOverlayId)
                        .fillMaxHeight()
                        .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142))
                ) {
                    Image(
                        modifier = Modifier
                            .id(imageLinkIconId)
                            .size(32.px),
                        src = Res.Icon.link,
                        description = "Link Icon"
                    )
                }

            }

            P(
                attrs = Modifier
                    .id(textParagraphTitleId)
                    .fillMaxWidth()
                    .fontFamily(Constants.LATO_FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .margin(topBottom = 0.px)
                    .toAttrs(),
            ) {
                Text(portfolio.title)
            }

            P(
                attrs = Modifier
                    .id(textParagraphDescriptionId)
                    .margin(topBottom = 0.px)
                    .fillMaxWidth()
                    .fontFamily(Constants.LATO_FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(60.percent)
                    .toAttrs(),
            ) {
                Text(portfolio.description)
            }
        }
    }
}