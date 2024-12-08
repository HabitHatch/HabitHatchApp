package com.habithatch.demo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.types.AllPets
import com.habithatch.demo.types.Pet

@Composable
fun PetsGrid(pets: List<Pet>) {
    val currentPet = remember { mutableStateOf<Pet?>(null) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(50.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        itemsIndexed(pets) { _, pet ->
            PetCard(
                pet = pet,
                isChecked = currentPet.value == pet,
                onPetSelected = {
                    if (currentPet.value == pet) currentPet.value = null
                    else currentPet.value = pet
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageGridPreview() {
    PetsGrid(pets = AllPets)
}
