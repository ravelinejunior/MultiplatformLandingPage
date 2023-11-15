package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import com.raveline.landingpage.components.AchievementCard
import com.raveline.landingpage.model.EnumAchievement
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier =
        Modifier
            .id(EnumSection.Achievements.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.TopCenter
    ) {
        AchievementsContent(breakpoint = breakpoint)
    }
}

@Composable
fun AchievementsContent(breakpoint: Breakpoint) {
    SimpleGrid(numColumns(base = 1, md = 2, lg = 4)) {
        EnumAchievement.values().forEach { achievement ->
            AchievementCard(
                modifier = Modifier.margin(
                    right = if (achievement == EnumAchievement.Team) 0.px
                    else {
                        if (breakpoint > Breakpoint.MD) 0.px else 40.px
                    },
                    left = if (achievement == EnumAchievement.Completed) 0.px
                       else{
                        if (breakpoint > Breakpoint.MD) 20.px else 0.px
                    },
                    bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                ),
                achievement = achievement
            )
        }
    }
}