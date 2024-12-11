package com.habithatch.demo

import android.os.Bundle
import androidx.activity.ComponentActivity

class ImmediatelyFinishingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}