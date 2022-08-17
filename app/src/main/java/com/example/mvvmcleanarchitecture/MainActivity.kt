package com.example.mvvmcleanarchitecture


import com.example.mvvmcleanarchitecture.presentation.base.ui.BaseActivity
import com.example.mvvmcleanarchitecture.presentation.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main
    override fun initView() {
        initFragment()
    }

    override fun initData() {
    }



    private fun initFragment() {
        supportFragmentManager.apply {
            findFragmentByTag(TAG) ?: beginTransaction()
                .add(R.id.flContainer, LoginFragment(), TAG)
                .commitAllowingStateLoss()
        }
    }


    companion object {
        private const val TAG = "MainActivity"
    }

}