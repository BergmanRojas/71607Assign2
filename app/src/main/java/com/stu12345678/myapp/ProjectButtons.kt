package com.stu12345678.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp


@Composable
fun ToMovie1Button(
    onClick: () -> Unit,
    buttonWidth: Dp,
    buttonHeight: Dp,
    imageId: Int,
    cornerRadius: Dp
) {
    val image: Painter = painterResource(id = imageId)

    Box(
        modifier = Modifier
            .size(width = buttonWidth, height = buttonHeight)
            .clip(RoundedCornerShape(cornerRadius))
            .clickable { onClick() }
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Composable
fun ToMovie2Button(
    onClick: () -> Unit,
    buttonWidth: Dp,
    buttonHeight: Dp,
    imageId: Int,
    cornerRadius: Dp
) {
    val image: Painter = painterResource(id = imageId)

    Box(
        modifier = Modifier
            .size(width = buttonWidth, height = buttonHeight)
            .clip(RoundedCornerShape(cornerRadius))
            .clickable { onClick() }
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ToMovie3Button(
    onClick: () -> Unit,
    buttonWidth: Dp,
    buttonHeight: Dp,
    imageId: Int,
    cornerRadius: Dp
) {
    val image: Painter = painterResource(id = imageId)

    Box(
        modifier = Modifier
            .size(width = buttonWidth, height = buttonHeight)
            .clip(RoundedCornerShape(cornerRadius))
            .clickable { onClick() }
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ToMovie4Button(
    onClick: () -> Unit,
    buttonWidth: Dp,
    buttonHeight: Dp,
    imageId: Int,
    cornerRadius: Dp
) {
    val image: Painter = painterResource(id = imageId)

    Box(
        modifier = Modifier
            .size(width = buttonWidth, height = buttonHeight)
            .clip(RoundedCornerShape(cornerRadius))
            .clickable { onClick() }
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}
