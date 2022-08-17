package com.example.mvvmcleanarchitecture.util

import com.example.mvvmcleanarchitecture.BaseApplication
import com.example.mvvmcleanarchitecture.presentation.base.ext.toast

inline fun toast(value: () -> String): Unit =
    BaseApplication.INSTANCE.toast(value)