package com.example.jangleproducerkt.ui.view


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.jangleproducerkt.R
import com.example.jangleproducerkt.util.DebugLog
import com.example.jangleproducerkt.util.TestObj
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mTestObj: TestObj
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DebugLog.write(mTestObj.deneme())
        DebugLog.write("TEST TEST")
    }



}

interface FragmentHandler {

    fun onOpenCreateUsers(view: View)
}
