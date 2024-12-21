package com.habithatch.demo.data.models


import java.util.EnumMap
import kotlin.enums.EnumEntries
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

/**
 * Filters goals based on priority and status.
 *
 * @param goalPriorityVisibleMap Maps each priority to its visibility.
 * @param goalStatusVisibleMap Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
data class GoalFilter(
    val goalPriorityVisibleMap: EnumMap<GoalPriority, Boolean>,
    val goalStatusVisibleMap: EnumMap<GoalStatus, Boolean>,
    val searchQuery: String?
) {
    init {
        validateMap(goalPriorityVisibleMap, GoalPriority.entries, ::goalPriorityVisibleMap.name)
        validateMap(goalStatusVisibleMap, GoalStatus.entries, ::goalStatusVisibleMap.name)
    }

    private inline fun <reified E : Enum<E>> validateMap(
        map: EnumMap<E, Boolean>,
        validKeys: EnumEntries<E>,
        mapName: String
    ) {
        val missingKeys = validKeys.toSet() - map.keys
        require(missingKeys.isEmpty()) {
            """
                $mapName must contain all values of ${E::class.simpleName}:
                Missing keys: $missingKeys.
            """.trimIndent()
        }
    }

    companion object {
        fun createMatchAllFilter(): GoalFilter {
            return GoalFilter(
                    goalPriorityVisibleMap = EnumMap(GoalPriority.entries.associateWith { true }),
                    goalStatusVisibleMap = EnumMap(GoalStatus.entries.associateWith { true }),
                    searchQuery = null
            )
        }
    }
}
