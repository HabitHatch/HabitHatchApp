package com.habithatch.demo.core.activities

import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * An activity that immediately finishes itself when created.
 * This is used for having an Activity change without any visual change.
 */
@AndroidEntryPoint
class ImmediatelyFinishingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
