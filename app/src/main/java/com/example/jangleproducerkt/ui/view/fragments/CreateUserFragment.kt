package com.example.jangleproducerkt.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.example.jangleproducerkt.R
import com.example.jangleproducerkt.databinding.FragmentCreateUserBinding
import com.example.jangleproducerkt.ui.binding.FragmentDataBindingComponent
import com.example.jangleproducerkt.ui.util.autoCleared
import com.example.jangleproducerkt.util.DebugLog
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class CreateUserFragment : DaggerFragment() ,CreateUserFragmentHandler{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var createUserViewModel: CreateUserViewModel

   private var binding by autoCleared<FragmentCreateUserBinding>()
   private  var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DebugLog.write()
        val dataBinding = DataBindingUtil.inflate<FragmentCreateUserBinding>(
            inflater,
            R.layout.fragment_create_user,
            container,
            false,
            dataBindingComponent
        )
        binding=dataBinding
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        activity?.title = "Create User(s)"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createUserViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CreateUserViewModel::class.java)

    }



    /*
    override fun onCreateUsers(view: View) {
      DebugLog.write()
    }

    override fun onOpenProfile(view: View) {
       DebugLog.write()
        navController().navigate(CreateUserFragmentDirections.openProfile())

    }*/


}

internal interface CreateUserFragmentHandler {

   // fun onCreateUsers(view: View)

   // fun onOpenProfile(view: View)
}
