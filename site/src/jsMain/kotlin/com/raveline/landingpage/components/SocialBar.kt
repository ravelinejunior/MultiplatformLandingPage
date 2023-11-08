package com.raveline.landingpage.components

import androidx.compose.runtime.Composable
import com.raveline.landingpage.styles.SocialLinkStyle
import com.raveline.landingpage.util.Constants.CAR_LINK
import com.raveline.landingpage.util.Constants.FACEBOOK_LINK
import com.raveline.landingpage.util.Constants.INSTAGRAM_LINK
import com.raveline.landingpage.util.Constants.LINKEDIN_LINK
import com.raveline.landingpage.util.Constants.TWITTER_LINK
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaCar
import com.varabyte.kobweb.silk.components.icons.fa.FaFacebook
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaTwitter
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar() {
    Column(
        modifier = Modifier
            .margin(right = 24.px)
            .padding(topBottom = 24.px)
            .minWidth(40.px)
            .borderRadius(r = 20.px)
            .backgroundColor(Colors.WhiteSmoke),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SocialLinks()
    }
}

@Composable
private fun SocialLinks() {
    Link(
        path = FACEBOOK_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        FaFacebook(
            modifier = SocialLinkStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }

    Link(
        path = INSTAGRAM_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }

    Link(
        path = TWITTER_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        FaTwitter(
            modifier = SocialLinkStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }

    Link(
        path = LINKEDIN_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }

    Link(
        path = CAR_LINK,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
    ) {
        FaCar(
            modifier = SocialLinkStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
}
