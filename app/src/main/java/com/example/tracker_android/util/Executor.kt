package com.example.tracker_android.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal interface Executor {

    fun launchMain(function: suspend () -> Unit)

    fun launchIO(function: suspend () -> Unit)
}

internal class mExecutor: Executor {

    override fun launchMain(function: suspend () -> Unit) {
        CoroutineScope(Dispatchers.Main).launch { function.invoke() }
    }

    override fun launchIO(function: suspend () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch { function.invoke() }
    }
}