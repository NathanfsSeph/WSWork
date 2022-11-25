package com.nathan.wswork.presentation.main.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nathan.wswork.R
import com.nathan.wswork.domain.model.Car
import com.nathan.wswork.databinding.ListItemCarBinding


class CarsAdapter(
    private val listener: OnCarListener
): ListAdapter<Car, CarsViewHolder>(DiffUtilItemCallBack()) {

    class DiffUtilItemCallBack : DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CarsViewHolder(
            ListItemCarBinding.inflate(inflater),
            listener
        )
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

}

interface OnCarListener {
    fun onCarClicked(car : Car)
}

class CarsViewHolder(private val binding : ListItemCarBinding, private val listener: OnCarListener) : RecyclerView.ViewHolder(binding.root){

    fun bindView(car : Car){

        with(binding){

            itemCarImageView.setImageResource(chooseImageCar(car))

            itemCarTextView.text = "${car.marca_nome} ${car.nome_modelo}"

            itemCarMaterialCardView.setOnClickListener{
                listener.onCarClicked(car)
            }

            executePendingBindings()

        }

    }

    private fun chooseImageCar(car : Car) : Int {
        var response : Int

        when(car.id) {
            1 -> {
                response = TOYOTA_COROLLA_XEI
            }
            2 -> {
                response = FORD_MAVERICK
            }
            3 -> {
                response = FORD_KA_2015
            }
            4 -> {
                response = VW_GOL_2015
            }
            5 -> {
                response = VW_VOYAGE
            }
            7 -> {
                response = FIAT_UNO_MILLE
            }
            8 -> {
                response = TOYOTA_COROLLA_XEI
            }
            10 -> {
                response = TOYOTA_COROLLA_2004
            }
            11 -> {
                response = VW_FUSCA
            }
            16 -> {
                response = VW_GOL_2012
            }
            17 -> {
                response = FORD_KA_2013
            }
            else -> {
                response = CANT_FIND_VEHICLE
            }
        }
        return response
    }

    companion object {
        const val TOYOTA_COROLLA_XEI = R.drawable.car_01
        const val TOYOTA_COROLLA_2004 = R.drawable.car_10

        const val FORD_MAVERICK = R.drawable.car_02
        const val FORD_KA_2015 = R.drawable.car_03
        const val FORD_KA_2013 = R.drawable.car_17

        const val VW_GOL_2015 = R.drawable.car_04
        const val VW_GOL_2012 = R.drawable.car_16
        const val VW_VOYAGE = R.drawable.car_05
        const val VW_FUSCA = R.drawable.car_11

        const val FIAT_UNO_MILLE = R.drawable.car_07

        const val CANT_FIND_VEHICLE = R.drawable.car_00
    }
}