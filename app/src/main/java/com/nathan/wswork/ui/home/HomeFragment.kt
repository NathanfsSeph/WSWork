package com.nathan.wswork.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.data.response.CarsItem
import com.nathan.wswork.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()

    }

    private fun setUpClickListeners() {
        with(binding) {
            button.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    car = CarsItem(
                        id = 1,
                        marca_id = 1,
                        marca_nome = "TOYOTA",
                        nome_modelo = "COROLLA XEI",
                        ano = 2016,
                        combustivel = "flex",
                        num_portas = 4,
                        valor_fipe = 70.0,
                        cor  = "Azul",
                        timestamp_cadastro = 1636636150
                    )
                )

                findNavController().navigate(action)
            }

            buttonOpenUserLayout.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_userFragment)
            }
        }
    }
}