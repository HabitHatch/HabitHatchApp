package com.habithatch.demo.features.settings

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository,
    habitHatchConfig: HabitHatchConfig
) : ViewModel() {
    val bottomNavigationItems: List<NavigationItem> = habitHatchConfig.navigationItems

    fun deleteAccount() {
        viewModelScope.launch {
            goalRepository.deleteAll()
            userRepository.deleteUser()
        }
    }
}