package com.raveline.landingpage.components

import androidx.compose.runtime.Composable
import com.raveline.landingpage.model.Theme
import com.raveline.landingpage.styles.InputStyle
import com.raveline.landingpage.styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

const val nameInputId = "inputNameID"
const val emailInputId = "inputEmailID"
const val descriptionEmailInputId = "inputDescriptionID"
const val controlClassForm = "form-control"
const val labelClassForm = "form-label"

@Composable
fun ContactForm(breakpoint: Breakpoint) {
    Form(
        action = "https://formspree.io/f/xbjeydwd",
        attrs = Modifier
            .attrsModifier {
                attr("method", "POST")
            }.toAttrs()
    ) {
        //Name
        Label(
            attrs = Modifier
                // USE THE BOOTSTRAP FRAMEWORK
                .classNames(labelClassForm)
                .toAttrs(),
            forId = nameInputId
        ) {
            Text("Name")
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id(nameInputId)
                .classNames(controlClassForm)
                .margin(bottom = 12.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 600.px
                    else 300.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Full Name")
                    attr("name", "name")
                    attr("required", "true")
                }
                .toAttrs()
        )
        //Email
        Label(
            attrs = Modifier
                // USE THE BOOTSTRAP FRAMEWORK
                .classNames(labelClassForm)
                .toAttrs(),
            forId = emailInputId
        ) {
            Text("Email")
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id(emailInputId)
                .classNames(controlClassForm)
                .margin(bottom = 12.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 600.px
                    else 300.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Email Address")
                    attr("name", "email")
                    attr("required", "true")
                }
                .toAttrs()
        )
        //Text Message
        Label(
            attrs = Modifier
                // USE THE BOOTSTRAP FRAMEWORK
                .classNames(labelClassForm)
                .toAttrs(),
            forId = descriptionEmailInputId
        ) {
            Text("Message")
        }
        TextArea(
            attrs = InputStyle.toModifier()
                .id(descriptionEmailInputId)
                .classNames(controlClassForm)
                .height(200.px)
                .margin(bottom = 20.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 600.px
                    else 300.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(2.px, 2.px, 1.px, 1.px, Theme.LighterGray.rgb)
                .attrsModifier {
                    attr("placeholder", "Type Your Message Here")
                    attr("name", "message")
                    attr("required", "true")
                }
                .toAttrs()
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(60.px)
                    .border(width = 0.px)
                    .borderRadius(r = 8.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Submit")
            }
        }
    }

}




















