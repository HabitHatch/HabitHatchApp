package com.habithatch.demo.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
    ) {
        Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
        ) {
            Image(
                    painter = painterResource(id = pet.imageRes),
                    contentDescription = "${pet.name} image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}
