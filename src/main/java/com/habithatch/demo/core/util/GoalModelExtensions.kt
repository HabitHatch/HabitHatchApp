package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel

fun Collection<GoalModel>.allDone(): Boolean = this.all(GoalModel::isDone)
