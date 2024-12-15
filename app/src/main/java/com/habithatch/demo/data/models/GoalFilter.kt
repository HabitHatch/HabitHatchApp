package com.habithatch.demo.data.models


import java.util.EnumMap
import kotlin.enums.EnumEntries
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

/**
 * Filters goals based on priority and status.
 *
 * @param priorityVisibleMap Maps each priority to its visibility.
 * @param doneStateVisibleMap Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
data class GoalFilter(
    val priorityVisibleMap: EnumMap<GoalPriority, Boolean>,
    val doneStateVisibleMap: EnumMap<GoalStatus, Boolean>,
    val searchQuery: String?
) {
    init {
        validateMap(priorityVisibleMap, GoalPriority.entries, ::priorityVisibleMap.name)
        validateMap(doneStateVisibleMap, GoalStatus.entries, ::doneStateVisibleMap.name)
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
        fun matchAllFilter(): GoalFilter {
            return GoalFilter(
                    priorityVisibleMap = EnumMap(GoalPriority.entries.associateWith { true }),
                    doneStateVisibleMap = EnumMap(GoalStatus.entries.associateWith { true }),
                    searchQuery = null
            )
        }
    }
}
