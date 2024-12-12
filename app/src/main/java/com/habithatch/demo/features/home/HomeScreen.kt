package com.habithatch.demo.features.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.navigation.NavHostController
import com.habithatch.demo.common.LoadingScreen
import com.habithatch.demo.common.PetAnimation
import com.habithatch.demo.common.goals.GoalListScreen
import com.habithatch.demo.core.Screen
import com.habithatch.demo.data.entities.User

@Composable
fun HomeScreen(
    navController: NavHostController,
    user: User?
) {
    Log.d("HomeScreen", "User: $user")
    if (user == null) {
        Log.e("HomeScreen", "User should not be null")
        LoadingScreen()
    } else {

        Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
        ) {
            Text(
                    text = "Home",
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 10.dp)
            )

            PetAnimation(
                    pet = user.pet,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth(0.5f)
                        .padding(top = 45.dp)
            )
            Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .padding(top = 300.dp)
            ) {
                GoalListScreen()
            }


            Button(
                    onClick = { navController.navigate(Screen.Settings.route) },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
            ) {
                Text("Go to Settings")
            }
        }
    }
}
