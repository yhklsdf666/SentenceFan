package com.yhklsdf.rx

import com.yhklsdf.rx.scheduler.IoMainScheduler

object SchedulerUtils {
    fun <T> ioToMain(): IoMainScheduler<T> = IoMainScheduler()
}