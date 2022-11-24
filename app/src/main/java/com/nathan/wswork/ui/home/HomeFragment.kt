package com.nathan.wswork.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.wswork.R
import com.nathan.wswork.data.model.Car
import com.nathan.wswork.databinding.FragmentHomeBinding
import com.nathan.wswork.ui.adapter.CarsAdapter
import com.nathan.wswork.ui.adapter.OnCarListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home), OnCarListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by sharedViewModel()
    private val adapter: CarsAdapter by lazy { CarsAdapter(this) }


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

            button.setOnClickListener {

                Toast.makeText(requireContext(), "Só pra fazer algo", Toast.LENGTH_SHORT).show()

            }

            buttonOpenUserLayout.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_userFragment)
            }
        }
    }

    override fun onCarClicked(car: Car) {

        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(car)
        findNavController().navigate(action)

    }

}