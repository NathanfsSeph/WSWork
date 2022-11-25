package com.nathan.wswork.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.data.database.UserDao
import com.nathan.wswork.data.database.WSWDatabase
import com.nathan.wswork.data.model.User
import com.nathan.wswork.databinding.FragmentUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserFragment : Fragment(R.layout.fragment_user) {

    private lateinit var binding: FragmentUserBinding
    private lateinit var database: WSWDatabase
    private lateinit var userDao: UserDao
    private val viewModel : UserViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = WSWDatabase.getInstance(requireContext())
        userDao = database.userDao()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        setUpViews()

    }

    private fun setUpViews() {
        with(binding) {

            registerTurnBackImageView.setOnClickListener { activity?.onBackPressed() }

            buttonRegister.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {

                    val result = viewModel.saveUser(gettingUserData())

                    withContext(Dispatchers.Main){
                        Toast.makeText(
                            requireContext(),
                            if(result) "Usuário salvo com sucesso" else "Ocorreu uma falha no cadastro",
                            Toast.LENGTH_SHORT
                        ).show()

                        if(result) {
                            findNavController().navigate(R.id.action_userFragment_to_homeFragment)
                        }
                    }

                }
            }
        }
    }

    private fun gettingUserData(): User {
        return User(
            firstName = binding.editTextFirstName.text.toString(),
            lastName = binding.editTextLastName.text.toString(),
            phone = binding.editTextPhone.text.toString(),
            password = binding.editTextPassword.text.toString(),
            email = binding.editTextEmail.text.toString(),
            address = binding.editTextAddress.text.toString()
        )
    }

}