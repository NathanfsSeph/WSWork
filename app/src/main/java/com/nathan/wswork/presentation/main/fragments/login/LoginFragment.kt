package com.nathan.wswork.presentation.main.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.domain.model.User
import com.nathan.wswork.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by sharedViewModel()


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setUpViews()
    }

    private fun setUpViews() {
        with(binding) {
            loginRegisterTextView.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_userFragment)
            }
            loginConfirmButton.setOnClickListener {
                var email = loginEmailEditText.text.toString()
                var password = loginPasswordEditText.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    var user: User? = viewModel.getUser(email, password)
                    if(user != null){
                        isLogged = true
                        saveLoggedUser(user)
                    }
                }
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            loginTurnBackImageView.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    companion object {
        var isLogged = false
        var loggedUser: User? = null
        private fun saveLoggedUser(user: User) {
            loggedUser = user
        }
    }

}