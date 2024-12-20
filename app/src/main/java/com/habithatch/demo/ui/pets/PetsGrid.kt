package com.habithatch.demo.ui.pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.data.entities.Pet

@Composable
fun PetsGrid(
    pets: List<Pet>,
    columns: Int = 2,
    outSidePadding: Dp = 50.dp,
    spaceBetween: Dp = 30.dp,
    title: String = "Choose your companion",
    confirmText: String = "I am happy with my choice",
    onConfirm: (Pet) -> Unit
) {
    val currentPet = remember { mutableStateOf<Pet?>(null) }

    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
                text = title,
                style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
                columns = GridCells.Fixed(columns),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(outSidePadding),
                horizontalArrangement = Arrangement.spacedBy(spaceBetween),
                verticalArrangement = Arrangement.spacedBy(spaceBetween)
        ) {
            itemsIndexed(pets) { _, pet ->
                PetCard(
                        pet = pet,
                        isChecked = currentPet.value == pet,
                        onPetSelected = {
                            if (currentPet.value == pet) {
                                currentPet.value = null
                            } else {
                                currentPet.value = pet
                            }
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
                onClick = { currentPet.value?.let { onConfirm(it) } },
                enabled = currentPet.value != null,
                colors = ButtonDefaults.buttonColors().copy(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                )
        ) {
            Text(text = confirmText)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    PetsGrid(
            pets = HabitHatchDevConfig.pets,
            onConfirm = {}
    )
}
