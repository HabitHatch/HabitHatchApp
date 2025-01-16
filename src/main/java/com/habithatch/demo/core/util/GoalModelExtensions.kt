package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.HabitModel

fun Collection<HabitModel>.allDone(): Boolean = this.all(HabitModel::isDone)
