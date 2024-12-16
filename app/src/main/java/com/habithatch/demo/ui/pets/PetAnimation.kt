package com.habithatch.demo.ui.pets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Pet

@Composable
fun PetAnimation(
    pet: Pet,
    isPetHappy: Boolean,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    val borderColor = if(isPetHappy) {
        MaterialTheme.colorScheme.tertiary.copy()

    }else {
        MaterialTheme.colorScheme.error.copy()
    }
    Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
    ) {
        Card(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .border(4.dp, borderColor, MaterialTheme.shapes.medium)
        ) {
            Image(
                    painter = painterResource(id = pet.imageRes),
                    contentDescription = "${pet.name} image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}
