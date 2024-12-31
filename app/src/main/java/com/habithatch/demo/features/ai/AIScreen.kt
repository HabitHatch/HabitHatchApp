package com.habithatch.demo.features.ai

import android.Manifest

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun AIScreen(
    state: AIScreenState = rememberAIScreenState(),
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
) {
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { granted ->
                if (granted) state.onStartListening()
            },
        )

    if (state.showPermissionDialog) {
        launcher.launch(Manifest.permission.RECORD_AUDIO)
    }

    Scaffold(
        topBar = topNavBar,
        bottomBar = bottomNavBar,
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = state.text,
                modifier =
                    Modifier.padding(end = 8.dp),
            )
            IconButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    state.onStartListening()
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vuesax_microphone_2),
                    contentDescription = stringResource(R.string.microphone_icon_description),
                    tint = if (state.isListening) Color.Red else MaterialTheme.colorScheme.outline,
                )
            }
        }
    }
}
