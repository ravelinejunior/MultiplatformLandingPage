package com.raveline.landingpage.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.raveline.landingpage.components.AchievementCard
import com.raveline.landingpage.model.EnumAchievement
import com.raveline.landingpage.model.EnumSection
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.util.Constants
import com.raveline.landingpage.util.ObserveViewportEntered
import com.raveline.landingpage.util.animateNumber
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
import kotlinx.coroutines.launch
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
        contentAlignment = Alignment.Center
    ) {
        AchievementsContent(breakpoint = breakpoint)
    }
}

@Composable
fun AchievementsContent(breakpoint: Breakpoint) {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember {
        mutableStateOf(false)
    }
    val animatedNumber = remember {
        mutableStateListOf(0, 0, 0, 0)
    }
    ObserveViewportEntered(
        sectionId = EnumSection.Achievements.id,
        distanceFromTop = 840.0,
        onViewportEntered = {
            viewportEntered = true
            EnumAchievement.values().forEach { achievement ->
                scope.launch {
                    animateNumber(
                        number = achievement.number,
                        delay = if (achievement.number < 30) 100L else 16L,
                        onUpdate = {
                            animatedNumber[achievement.ordinal] = it
                        }
                    )
                }
            }
        }
    )

    SimpleGrid(numColumns(base = 1, md = 2, lg = 4)) {
        EnumAchievement.values().forEach { achievement ->
            AchievementCard(
                modifier = Modifier.margin(
                    right = if (achievement == EnumAchievement.Team) 0.px
                    else {
                        if (breakpoint > Breakpoint.MD) 0.px else 40.px
                    },
                    left = if (achievement == EnumAchievement.Completed) 0.px
                    else {
                        if (breakpoint > Breakpoint.MD) 20.px else 0.px
                    },
                    bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                ),
                animatedNumber = if (viewportEntered) animatedNumber[achievement.ordinal] else 0,
                achievement = achievement,
            )
        }
    }
}