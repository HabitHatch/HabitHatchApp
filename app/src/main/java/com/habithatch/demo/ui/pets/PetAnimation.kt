package com.habithatch.demo.ui.pets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.theme.success
import com.habithatch.demo.data.entities.Pet

@Composable
fun borderColor(isPetHappy: Boolean) = if (isPetHappy) MaterialTheme.colorScheme.success else MaterialTheme.colorScheme.error

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun PetAnimation(
    pet: Pet,
    isPetHappy: Boolean,
    modifier: Modifier = Modifier,
) {
    val imageShape = MaterialTheme.shapes.medium

    Row(
        modifier = modifier,
    ) {
        Card(
            shape = imageShape,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .border(4.dp, borderColor(isPetHappy), imageShape),
        ) {
            Image(
                painter = painterResource(id = pet.imageRes),
                contentDescription = stringResource(R.string.pet_image_description),
                modifier =
                    Modifier
                        .fillMaxSize()
                        .clip(imageShape),
            )
        }
    }
}
