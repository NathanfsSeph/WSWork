package com.nathan.wswork.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.databinding.FragmentLoginBinding
import com.nathan.wswork.ui.user.UserViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: UserViewModel by sharedViewModel()


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
            loginTurnBackImageView.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

}