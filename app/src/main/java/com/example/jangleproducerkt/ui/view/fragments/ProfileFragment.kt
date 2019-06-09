package com.example.jangleproducerkt.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.jangleproducerkt.R
import com.example.jangleproducerkt.databinding.FragmentProfileBinding
import com.example.jangleproducerkt.ui.binding.FragmentDataBindingComponent
import com.example.jangleproducerkt.ui.util.autoCleared
import com.example.jangleproducerkt.util.DebugLog
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class ProfileFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var profileViewModel: ProfileViewModel

    private var binding by autoCleared<FragmentProfileBinding>()
    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    //   private val params by navArgs<ProfileFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DebugLog.write()
        val dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(
            inflater,
            R.layout.fragment_profile,
            container,
            false,
            dataBindingComponent
        )
        binding = dataBinding
        activity?.title = "User(s) Profile"
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ProfileViewModel::class.java)

    }

}