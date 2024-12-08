package com.habithatch.demo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.R

@Composable
fun PetsGrid(images: List<Int>) {
    val checkedStates = remember { mutableStateListOf<Boolean>().apply { addAll(List(images.size) { false }) } }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(50.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        itemsIndexed(images) { index, imageRes ->
            PetCard(
                imageRes = imageRes,
                isChecked = checkedStates[index],
                onToggleCheck = { checkedStates[index] = !checkedStates[index] }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageGridPreview() {
    val sampleImages = listOf(
        R.drawable.pet_cat,
        R.drawable.pet_fox,
        R.drawable.pet_rabbit,
        R.drawable.pet_ice_bear
    )
    PetsGrid(images = sampleImages)
}
