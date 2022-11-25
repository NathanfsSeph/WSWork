package com.nathan.wswork.presentation.main.fragments.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.domain.model.Car
import com.nathan.wswork.domain.model.Lead
import com.nathan.wswork.databinding.DialogBinding
import com.nathan.wswork.databinding.FragmentHomeBinding
import com.nathan.wswork.presentation.main.fragments.home.adapter.CarsAdapter
import com.nathan.wswork.presentation.main.fragments.home.adapter.OnCarListener
import com.nathan.wswork.presentation.main.fragments.login.LoginFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home), OnCarListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var dialog: AlertDialog

    private val viewModel: HomeViewModel by sharedViewModel()
    private val adapter: CarsAdapter by lazy { CarsAdapter(this) }

    private var isLogged : Boolean = false


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupObservers() {
        viewModel.homeScreenState.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it.cars)
            }
        }
    }

    private fun setupViews() {
        with(binding) {

            with(recyclerView) {
                adapter = this@HomeFragment.adapter
                val eita = adapter?.itemCount
            }

            homeToolbarUserImageView.setOnClickListener{
                if(!LoginFragment.isLogged) {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                } else {
                    var loggedUser = LoginFragment.loggedUser
                    Toast.makeText(requireContext(), "Você está logado como ${loggedUser?.firstName} ${loggedUser?.lastName}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showDialog(lead: Lead) {
        val build = AlertDialog.Builder(requireContext(), R.style.ThemeDialog).setCancelable(false)
        val dialogBinding = DialogBinding.inflate(LayoutInflater.from(requireContext()))

        setUpDialog(dialogBinding,lead)
        build.setView(dialogBinding.root)

        dialog = build.create()
        dialog.show()
    }

    private fun setUpDialog(dialogBinding: DialogBinding, lead: Lead) {
        with(dialogBinding) {
            dialogCancelButton.setOnClickListener { dialog.dismiss() }
            dialogIWantItButton.setOnClickListener {
                viewModel.saveLead(lead)
                dialog.dismiss()
            }
        }
    }

    override fun onCarClicked(car: Car) {
        val lead = LoginFragment.loggedUser?.let {
            Lead (
                userId = it.id,
                carId = car.id,
                userName = "${it.firstName} ${it.lastName}",
                userPhone = it.phone
            )
        }

        lead?.let { showDialog(it) }
    }

}