package com.raveline.landingpage.model

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class EnumSkill(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Creative(
        title = "Creative",
        percentage = 80.percent
    ),
    Accountable(
        title = "Accountable",
        percentage = 90.percent
    ),
    HardWorking(
        title = "Hard Working",
        percentage = 100.percent
    ),
    Value(
        title = "Value for Money",
        percentage = 70.percent
    ),
    Delivery(
        title = "On-Time Delivery",
        percentage = 80.percent
    )
}