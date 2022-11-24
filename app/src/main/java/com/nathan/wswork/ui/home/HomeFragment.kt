package com.nathan.wswork.ui.home

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
import com.nathan.wswork.data.APIService
import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.databinding.DialogBinding
import com.nathan.wswork.databinding.FragmentHomeBinding
import com.nathan.wswork.ui.adapter.CarsAdapter
import com.nathan.wswork.ui.adapter.OnCarListener
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
                if (adapter.itemCount == 0)
                    println("Adapter é : ${adapter.itemCount}")
                else
                    println("Adapter se liga no bichao ${it.cars[0].marca_nome} ${it.cars[0].nome_modelo}")
            }
        }
    }

    private fun setupViews() {
        with(binding) {

            with(recyclerView) {
                adapter = this@HomeFragment.adapter
                val eita = adapter?.itemCount
                println("Adapter setupViews : $eita")
            }

            homeToolbarUserImageView.setOnClickListener{
                if(!isLogged) {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                } else {
                    val nomedousuário = "Nome Do Usuário"
                    Toast.makeText(requireContext(), "Você está logado como ${nomedousuário}", Toast.LENGTH_SHORT).show()
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
        val lead = Lead (
            userId = 1,
            carId = car.id,
            userName = "userName",
            userPhone = "userPhone"
        )

        showDialog(lead)
    }

}