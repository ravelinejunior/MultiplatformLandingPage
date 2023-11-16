package com.raveline.landingpage.components

import androidx.compose.runtime.Composable
import com.raveline.landingpage.model.EnumAchievement
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.util.Constants.LATO_FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    achievement: EnumAchievement,
    animatedNumber: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(70.px)
                .margin(right = 20.px),
            src = achievement.icon,
            description = "Achievement Icon"
        )

        Column {
            P(
                attrs =
                Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(32.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(
                    if (achievement == EnumAchievement.Completed)
                        "$animatedNumber+"
                    else "$animatedNumber"
                )
            }

            P(
                attrs =
                Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(LATO_FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(60.percent)
                    .toAttrs()
            ) {
                Text(
                    achievement.description
                )
            }
        }
    }

}