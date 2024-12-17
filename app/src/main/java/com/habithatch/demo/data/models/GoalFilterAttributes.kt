package com.habithatch.demo.data.models


import java.util.EnumMap
import kotlin.enums.enumEntries
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

/**
 * Filters goals based on priority and status.
 *
 * @param goalPriorityVisibleMap Maps each priority to its visibility.
 * @param goalStatusVisibleMap Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
data class GoalFilterAttributes(
    val goalPriorityVisibleMap: EnumMap<GoalPriority, Boolean>,
    val goalStatusVisibleMap: EnumMap<GoalStatus, Boolean>,
    val searchQuery: String?
) {
    init {
        validateMap(goalPriorityVisibleMap, ::goalPriorityVisibleMap.name)
        validateMap(goalStatusVisibleMap, ::goalStatusVisibleMap.name)
    }

    private inline fun <reified E : Enum<E>> validateMap(
        map: EnumMap<E, Boolean>,
        mapName: String
    ) {
        val missingKeys = enumEntries<E>() - map.keys
        require(missingKeys.isEmpty()) {
            """
                $mapName must contain all values of ${E::class.simpleName}:
                Missing keys: $missingKeys.
            """.trimIndent()
        }
    }

    companion object {
        fun createMatchAllInProgressFilter(): GoalFilterAttributes {
            val goalStatusVisibleMap = EnumMap(GoalStatus.entries.associateWith { it == GoalStatus.IN_PROGRESS })

            return GoalFilterAttributes(
                    goalPriorityVisibleMap = EnumMap(GoalPriority.entries.associateWith { true }),
                    goalStatusVisibleMap = goalStatusVisibleMap,
                    searchQuery = null
            )
        }

        fun createMatchAllFilter(): GoalFilterAttributes {
            return GoalFilterAttributes(
                    goalPriorityVisibleMap = EnumMap(GoalPriority.entries.associateWith { true }),
                    goalStatusVisibleMap = EnumMap(GoalStatus.entries.associateWith { true }),
                    searchQuery = null
            )
        }
    }
}
