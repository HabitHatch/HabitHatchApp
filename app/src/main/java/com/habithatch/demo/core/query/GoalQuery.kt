package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.util.disableAll
import com.habithatch.demo.core.util.getUsed
import com.habithatch.demo.core.util.removeByLabel
import com.habithatch.demo.data.models.GoalModel

@Immutable
data class GoalQuery(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption>,
    val defaultComparator: Comparator<GoalModel>,
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    init {
        this.checkValidity()
    }

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(sortOption: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it.label == sortOption.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator() = (getActiveComparator() ?: compareBy { 0 }).then(defaultComparator)

    fun getFilterBuilder() = GoalFilter.Builder.createFromFilter(filter, priorityProvider, statusProvider)

    private fun setActiveSortOption(sortOption: GoalSortOption): GoalQuery {
        val disabledOptions = sortOptions.removeByLabel(sortOption.label).disableAll()
        return this.copy(sortOptions = disabledOptions + sortOption)
    }

    private fun getActiveComparator() = sortOptions.getUsed().firstOrNull()?.comparator

    @Throws(IllegalStateException::class)
    private fun checkValidity() {
        check(sortOptions.getUsed().size <= 1) {
            "There must be no more than one active sortOption"
        }
        check(filter.priorityVisibility.keys == priorityProvider.priorities.toSet()) {
            "Priority visible map must contain all priorities"
        }
        check(filter.statusVisibility.keys == statusProvider.statuses.toSet()) {
            "Status visible map must contain all statuses"
        }
    }

    override fun toString(): String =
        """
        GoalQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()
}
