package com.habithatch.demo.core.activities

import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.habithatch.demo.core.app.AppTheme
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity
    @Inject
    constructor(
        private val config: HabitHatchConfig,
    ) : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            startActivity(Intent(this, ImmediatelyFinishingActivity::class.java))

            setContent {
                AppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        AppNavigation(
                            config = config,
                        )
                    }
                }
            }
        }
    }
