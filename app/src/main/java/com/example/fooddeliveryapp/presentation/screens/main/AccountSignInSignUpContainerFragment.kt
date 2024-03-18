package com.example.fooddeliveryapp.presentation.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentAccountBinding
import com.example.fooddeliveryapp.databinding.FragmentAccountSigninSignupContainerBinding


class AccountSignInSignUpContainerFragment : Fragment() {

    private var _binding: FragmentAccountSigninSignupContainerBinding? = null
    private val binding: FragmentAccountSigninSignupContainerBinding
        get() = _binding ?: throw RuntimeException("FragmentAccountBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountSigninSignupContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //test
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_accountContainerFragment_to_signUpFragment)
        }
        binding.buttonSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_accountContainerFragment_to_signInFragment)
        }
        binding.buttonAccount.setOnClickListener {
            findNavController().navigate(R.id.action_accountContainerFragment_to_accountFragment)
        }
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        } else {
            AnimationUtils.loadAnimation(context, R.anim.slide_out_right)
        }
    }

}