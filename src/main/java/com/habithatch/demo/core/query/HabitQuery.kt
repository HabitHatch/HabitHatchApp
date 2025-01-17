package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import javax.inject.Inject
import com.habithatch.demo.core.util.disableAll
import com.habithatch.demo.core.util.getUsed
import com.habithatch.demo.core.util.removeByUIIndex
import com.habithatch.demo.data.models.HabitModel

/**
 * Query for filtering and sorting habits.
 *
 * @param filter The filter for the habits.
 * @param sortOptions The sort options for the habits.
 * @param defaultComparator The default comparator for the habits.
 */
@Immutable
data class HabitQuery(
    val filterBuilder: HabitFilter.Builder,
    val sortOptions: List<HabitSortOption> = emptyList(),
    val defaultComparator: Comparator<HabitModel> = compareBy { 0 },
) {
    init {
        this.checkValid()
    }

    val filter: HabitFilter
        get() = filterBuilder.build()

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(sortOption: HabitSortOption): HabitQuery {
        require(sortOptions.filter { it.labelRes == sortOption.labelRes }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator() = (getActiveComparator() ?: compareBy { 0 }).then(defaultComparator)

    private fun setActiveSortOption(sortOption: HabitSortOption): HabitQuery {
        val disabledOptions = sortOptions.removeByUIIndex(sortOption.uiIndex).disableAll()
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
         HabitQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()

    /**
     * Factory for creating [HabitQuery] instances.
     */
    class Factory
        @Inject
        constructor() {
            fun createQuery(
                filterBuilder: HabitFilter.Builder,
                sortOptions: List<HabitSortOption> = emptyList(),
                defaultComparator: Comparator<HabitModel> = compareBy { 0 },
            ) = HabitQuery(
                filterBuilder = filterBuilder,
                sortOptions = sortOptions,
                defaultComparator = defaultComparator,
            )
        }
}
