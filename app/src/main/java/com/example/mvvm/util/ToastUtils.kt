package com.example.mvvm.util

import com.example.mvvm.BaseApplication
import com.example.mvvm.presentation.base.ext.toast

inline fun toast(value: () -> String): Unit =
    BaseApplication.INSTANCE.toast(value)