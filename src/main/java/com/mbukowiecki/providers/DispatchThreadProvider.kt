/*
 * Copyright 2021 Marcin Bukowiecki.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package com.mbukowiecki.providers

import com.mbukowiecki.bundle.ThreadAccessBundle
import com.mbukowiecki.evaluator.ThreadAccessEvaluator

/**
 * @author Marcin Bukowiecki
 */
class DispatchThreadProvider : AccessProvider {

    override fun provide(context: SetupContext) {
        ThreadAccessEvaluator.getInstance().getStatus(
            context,
            "ApplicationManager.getApplication().isDispatchThread()",
            "com.intellij.openapi.application.ApplicationManager",
            CheckCallback(
                context,
                ThreadAccessBundle.message("dispatchThread.label")
            )
        )
    }
}