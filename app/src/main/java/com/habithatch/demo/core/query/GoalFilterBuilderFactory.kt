package com.habithatch.demo.core.query

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import javax.inject.Inject

class GoalFilterBuilderFactory
    @Inject
    constructor(
        private val priorityProvider: GoalPriorityProvider,
        private val statusProvider: GoalStatusProvider,
    ) {
        val matchAllBuilder: GoalFilter.Builder
            get() = GoalFilter.Builder.matchAllBuilder(priorityProvider, statusProvider)
    }
