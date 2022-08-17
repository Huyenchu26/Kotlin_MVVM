package com.example.mvvmcleanarchitecture.presentation.base.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmcleanarchitecture.util.OnOneOffClickListener

abstract class BaseActivity : AppCompatActivity(), IView {
    abstract val layoutId: Int
    abstract fun initView()
    abstract fun initData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        initData()
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * prevent double click on view
     **/
    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
        try {
            val safeClickListener = OnOneOffClickListener {
                onSafeClick(it)
            }
            setOnClickListener(safeClickListener)
        } catch (E: Exception) {
        }
    }

}