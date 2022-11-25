package com.nathan.wswork.presentation.main.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathan.wswork.data.remotedatasource.APIService
import com.nathan.wswork.domain.repository.WSWRepository
import com.nathan.wswork.domain.model.Car
import com.nathan.wswork.domain.model.Lead
import com.nathan.wswork.data.remotedatasource.CarsBodyResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val repository: WSWRepository
) : ViewModel() {

    private val _homeScreenState: MutableLiveData<HomeScreenState> = MutableLiveData()
    val homeScreenState: LiveData<HomeScreenState> get() = _homeScreenState

    init {
        _homeScreenState.value = HomeScreenState()
    }

    fun getAllCars(){
        APIService.service.getCars()
            .enqueue(object : Callback<CarsBodyResponse> {
                override fun onResponse(
                    call: Call<CarsBodyResponse>,
                    response: Response<CarsBodyResponse>
                ) {
                    if(response.isSuccessful){
                        val cars : MutableList<Car> = mutableListOf()

                        response.body()?.let { carBodyResponse ->
                            for (result in carBodyResponse) {
                                val car = Car(
                                    id = result.id,
                                    ano = result.ano,
                                    combustivel = result.combustivel,
                                    cor = result.cor,
                                    marca_id = result.marca_id,
                                    marca_nome = result.marca_nome,
                                    nome_modelo = result.nome_modelo,
                                    num_portas = result.num_portas,
                                    timestamp_cadastro = result.timestamp_cadastro,
                                    valor_fipe = result.valor_fipe
                                )
                                cars.add(car)

                                viewModelScope.launch {
                                    repository.insertCar(car)
                                }
                            }
                        }
                        _homeScreenState.value = homeScreenState.value?.copy(
                            cars = cars
                        )

                    }
                }

                override fun onFailure(call: Call<CarsBodyResponse>, t: Throwable) {

                    viewModelScope.launch {
                        val recoveredCars = repository.getCars()

                        _homeScreenState.value = homeScreenState.value?.copy(
                            cars = recoveredCars
                        )
                    }

                }

            })
    }

    fun saveLead(lead: Lead){

        try {
            viewModelScope.launch {
                repository.insertLead(lead)
            }
        } catch (exception : Exception) {
            println("Something went wrong")
        }

    }

}