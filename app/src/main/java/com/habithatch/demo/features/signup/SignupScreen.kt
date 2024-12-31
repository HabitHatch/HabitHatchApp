package com.habithatch.demo.features.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.habithatch.demo.R
import com.habithatch.demo.ui.common.ImageBox
import com.habithatch.demo.ui.common.ImageTextCard
import com.habithatch.demo.ui.common.SelectionGrid

/**
 * The signup screen composable. Is shown when the user first starts the App
 * and is asked to select a pet.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SignupScreen(
    state: SignupScreenState = rememberSignupScreenState(),
) {
    Column(
        modifier = Modifier.Companion.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.pet_selection_cta),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        SelectionGrid(
            elements = state.pets,
            onConfirm = state.onPetConfirmed,
            card = { pet, isChecked, onPetSelected ->
                ImageTextCard(
                    imageContent = {
                        ImageBox(
                            imageRes = pet.imageRes,
                            isChecked = isChecked,
                        )
                    },
                    text = {
                        Text(
                            text = pet.name,
                        )
                    },
                    onSelected = onPetSelected,
                )
            },
        )
    }
}
