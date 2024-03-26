package com.example.fooddeliveryapp.presentation.screens.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentSignInBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding
        get() = _binding ?: throw RuntimeException()

    private val testCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testCoroutineScope.launch {
            launchSignUpFragment()
            launchAccountFragment()
        }
    }

    private suspend fun launchSignUpFragment() {
        binding.bSignUpDir.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            testCoroutineScope.launch {
                delay(1000L)

                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }
        }
        binding.progressBar.visibility = View.GONE
    }

    // args - name, phone, password
    private fun launchAccountFragment() {
        binding.bSignIn.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            testCoroutineScope.launch {
                delay(1000L)

                findNavController().navigate(R.id.action_signInFragment_to_accountFragment)
            }
        }
        binding.progressBar.visibility = View.GONE
    }

}