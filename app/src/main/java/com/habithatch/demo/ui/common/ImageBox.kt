package com.habithatch.demo.ui.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R

/**
 * A box with an image and a checkmark indicator.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun ImageBox(
    imageRes: Int,
    modifier: Modifier = Modifier,
    isChecked: Boolean,
) {
    val cardShape = MaterialTheme.shapes.large
    val borderColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else Color.Transparent,
        label = "borderAnimation",
    )
    val indicatorColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "indicatorColorAnimation",
    )

    Card(
        shape = cardShape,
        modifier =
            modifier
                .border(
                    width = if (isChecked) 2.dp else 0.dp,
                    color = borderColor,
                    shape = cardShape,
                ),
    ) {
        Box(modifier = Modifier.aspectRatio(1f)) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = stringResource(R.string.pet_image_description),
                modifier =
                    Modifier
                        .fillMaxSize()
                        .clip(cardShape),
            )

            Box(
                modifier =
                    modifier
                        .size(48.dp)
                        .padding(10.dp)
                        .align(Alignment.BottomEnd),
            ) {
                Icon(
                    painter = painterResource(R.drawable.vuesax_tick_circle),
                    contentDescription = stringResource(R.string.pet_selected_description),
                    tint = indicatorColor,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    }
}
