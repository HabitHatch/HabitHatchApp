package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.util.disableAll
import com.habithatch.demo.core.util.getUsed
import com.habithatch.demo.core.util.removeByLabel
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject

/**
 * Query for filtering and sorting goals.
 *
 * @param filter The filter for the goals.
 * @param sortOptions The sort options for the goals.
 * @param defaultComparator The default comparator for the goals.
 */
@Immutable
data class GoalQuery(
    val filterBuilder: GoalFilter.Builder,
    val sortOptions: List<GoalSortOption> = emptyList(),
    val defaultComparator: Comparator<GoalModel> = compareBy { 0 },
) {
    init {
        this.checkValid()
    }

    val filter: GoalFilter
        get() = filterBuilder.build()

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(sortOption: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it.label == sortOption.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator() = (getActiveComparator() ?: compareBy { 0 }).then(defaultComparator)

    private fun setActiveSortOption(sortOption: GoalSortOption): GoalQuery {
        val disabledOptions = sortOptions.removeByLabel(sortOption.label).disableAll()
        return this.copy(sortOptions = disabledOptions + sortOption)
    }

    private fun getActiveComparator() = sortOptions.getUsed().firstOrNull()?.comparator

    @Throws(IllegalStateException::class)
    private fun checkValid() {
        check(sortOptions.getUsed().size <= 1) { "There must be no more than one active sortOption" }
    }

    /** @suppress */
    override fun toString(): String =
        """
         GoalQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()

    /**
     * Factory for creating [GoalQuery] instances.
     */
    class Factory
        @Inject
        constructor(
        ) {
            fun createGoalQuery(
                filterBuilder: GoalFilter.Builder,
                sortOptions: List<GoalSortOption> = emptyList(),
                defaultComparator: Comparator<GoalModel> = compareBy { 0 },
            ) = GoalQuery(
                filterBuilder = filterBuilder,
                sortOptions = sortOptions,
                defaultComparator = defaultComparator,
            )
        }
}
