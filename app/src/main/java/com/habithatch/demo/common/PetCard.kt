package com.habithatch.demo.common

import com.habithatch.demo.data.entities.Pet
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun PetCard(
    pet: Pet,
    isChecked: Boolean,
    onPetSelected: () -> Unit
) {
    val indicatorColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "indicatorColorAnimation"
    )
    val indicatorSize by animateDpAsState(
        targetValue = if (isChecked) 36.dp else 32.dp,
        label = "indicatorSizeAnimation"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPetSelected() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (isChecked) 2.dp else 0.dp,
                    color = if (isChecked) MaterialTheme.colorScheme.primary else Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = pet.imageRes),
                    contentDescription = "${pet.name} image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(12.dp))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .size(indicatorSize)
                        .clip(CircleShape)
                        .background(indicatorColor)
                ) {
                    if (isChecked) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected ${pet.name}",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = pet.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
