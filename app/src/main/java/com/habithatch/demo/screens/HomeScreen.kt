package com.habithatch.demo.screens


import androidx.navigation.NavHostController
import com.habithatch.demo.Screen
import com.habithatch.demo.components.GoalList
import com.habithatch.demo.components.PetAnimation
import com.habithatch.demo.viewModels.HomeViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    val user = viewModel.user.collectAsState()
    val goals = viewModel.goals.collectAsState()
    if (user.value == null) {
        LoadingScreen()
        return
    }

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
            pet = user.value!!.pet,
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
            Text(text = "Goals", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            GoalList(
                goals = goals.value,
            )
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
