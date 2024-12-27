package com.habithatch.demo.ui.pets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Pet

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun PetCard(
    pet: Pet,
    isChecked: Boolean,
    onPetSelected: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable { onPetSelected() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PetImageBox(pet = pet, isChecked = isChecked)
        Spacer(modifier = Modifier.height(8.dp))
        Text(pet.name, style = MaterialTheme.typography.bodyLarge)
    }
}

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun PetImageBox(
    pet: Pet,
    isChecked: Boolean,
) {
    val borderColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else Color.Transparent,
        label = "borderAnimation",
    )

    Card(
        shape = MaterialTheme.shapes.large,
        modifier =
            Modifier
                .fillMaxWidth()
                .border(
                    width = if (isChecked) 2.dp else 0.dp,
                    color = borderColor,
                    shape = MaterialTheme.shapes.large,
                ),
    ) {
        Box(modifier = Modifier.aspectRatio(1f)) {
            Image(
                painter = painterResource(id = pet.imageRes),
                contentDescription = pet.name,
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.large),
            )
            PetSelectionIndicator(
                modifier =
                    Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .clip(CircleShape),
                isChecked = isChecked,
                petName = pet.name,
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun PetSelectionIndicator(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    petName: String,
) {
    val indicatorColor by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "indicatorColorAnimation",
    )
    val indicatorSize by animateDpAsState(
        targetValue = if (isChecked) 36.dp else 32.dp,
        label = "indicatorSizeAnimation",
    )

    Box(
        modifier = modifier.size(indicatorSize).background(indicatorColor, CircleShape),
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Selected $petName",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
