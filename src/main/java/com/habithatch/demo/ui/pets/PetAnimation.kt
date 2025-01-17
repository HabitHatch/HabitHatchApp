package com.habithatch.demo.ui.pets

import android.util.Log

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.R
import com.habithatch.demo.core.animation.ImageStateAnimation
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.PetMoodAnimationsFactory

/**
 * A pet animation that displays a pet.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun PetAnimation(
    pet: Pet,
    modifier: Modifier = Modifier,
) {
    val imageShape = MaterialTheme.shapes.medium
    val animation by pet.animationState.collectAsStateWithLifecycle()
    Log.d("PetAnimation", "pet: $pet")
    Row(
        modifier = modifier,
    ) {
        Card(
            shape = imageShape,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
        ) {
            if (animation != null) {
                val frame by animation!!.state.collectAsStateWithLifecycle()
                DisposableEffect(animation) {
                    animation!!.start()

                    onDispose {
                        animation!!.stop()
                    }
                }
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = frame),
                    contentDescription = "animation",
                )
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable()
fun PetAnimationPreview() {
    val animation = ImageStateAnimation(R.mipmap.cat)
    val petMoodAnimations =
        PetMoodAnimationsFactory()
            .create(
                animation = animation,
            )
    val pet =
        Pet(
            nameRes = R.string.cat_name,
            coverImage = R.mipmap.cat,
            petMoodAnimations = petMoodAnimations,
        )
    pet.updateMood(emptyList())

    PetAnimation(
        pet = pet,
    )
}
