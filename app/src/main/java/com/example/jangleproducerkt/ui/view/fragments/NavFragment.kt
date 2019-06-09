package com.example.jangleproducerkt.ui.view.fragments

import android.os.Bundle
import android.os.Debug
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.example.jangleproducerkt.R
import com.example.jangleproducerkt.databinding.FragmentNavBinding
import com.example.jangleproducerkt.databinding.FragmentProfileBinding
import com.example.jangleproducerkt.ui.binding.FragmentDataBindingComponent
import com.example.jangleproducerkt.ui.util.autoCleared
import com.example.jangleproducerkt.util.DebugLog
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class NavFragment : DaggerFragment(), NavFragmentHandler {


    private var binding by autoCleared<FragmentNavBinding>()
    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DebugLog.write()
        val dataBinding = DataBindingUtil.inflate<FragmentNavBinding>(
            inflater,
            R.layout.fragment_nav,
            container,
            false,
            dataBindingComponent
        )
        binding = dataBinding
        binding.handler = this
        activity?.title = getString(R.string.app_name)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        return binding.root
    }

    override fun onOpenCreateUsers(view: View) {
        DebugLog.write()
        navController().navigate(NavFragmentDirections.openCreateUser())
    }

    override fun onOpenProfile(view: View) {
        DebugLog.write()
        navController().navigate(NavFragmentDirections.openProfile())
    }

    private fun navController() = findNavController()

}

interface NavFragmentHandler {

    fun onOpenCreateUsers(view: View)

    fun onOpenProfile(view: View)
}