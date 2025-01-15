package com.habithatch.demo.core.query

import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import javax.inject.Inject

/**
 * Factory for creating [HabitFilter.Builder] instances.
 */
class HabitFilterBuilderFactory
    @Inject
    constructor(
        private val priorityProvider: HabitPriorityProvider,
        private val statusProvider: HabitStatusProvider,
    ) {
        val matchAllBuilder: HabitFilter.Builder
            get() = HabitFilter.Builder.matchAllBuilder(priorityProvider, statusProvider)
    }
