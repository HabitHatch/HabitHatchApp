package com.habithatch.demo.ui.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun ImageBox(
    imageRes: Int,
    name: String,
    modifier: Modifier = Modifier,
    isChecked: Boolean,
) {
    val borderColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else Color.Companion.Transparent,
        label = "borderAnimation",
    )
    val indicatorColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "indicatorColorAnimation",
    )
    val indicatorPadding by animateDpAsState(
        targetValue = if (isChecked) 8.dp else 10.dp,
        label = "indicatorPaddingAnimation",
    )

    Card(
        shape = MaterialTheme.shapes.large,
        modifier =
            modifier
                .border(
                    width = if (isChecked) 2.dp else 0.dp,
                    color = borderColor,
                    shape = MaterialTheme.shapes.large,
                ),
    ) {
        Box(modifier = Modifier.aspectRatio(1f)) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Pet image",
                contentScale = ContentScale.Companion.Crop,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.large),
            )

            Box(
                modifier =
                    modifier
                        .size(48.dp)
                        .padding(indicatorPadding)
                        .background(indicatorColor, CircleShape)
                        .align(Alignment.BottomEnd),
            ) {
                if (isChecked) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected $name",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
        }
    }
}
