package com.habithatch.demo.core.activities

import android.os.Bundle

import androidx.activity.ComponentActivity

/**
 * An activity that immediately finishes itself when created.
 * This is used for having an Activity change without any visual change.
 */
class ImmediatelyFinishingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}
