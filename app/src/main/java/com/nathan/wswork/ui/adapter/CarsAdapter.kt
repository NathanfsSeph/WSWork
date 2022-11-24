package com.nathan.wswork.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nathan.wswork.R
import com.nathan.wswork.data.model.Car
import com.nathan.wswork.databinding.ListItemCarBinding
import kotlinx.android.synthetic.main.list_item_car.view.*


class CarsAdapter(
    private val listener: OnCarListener
): ListAdapter<Car,CarsViewHolder>(DiffUtilItemCallBack()) {

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

            itemCarTextView.text = "${car.marca_nome} ${car.nome_modelo}"

            itemCarMaterialCardView.setOnClickListener{
                listener.onCarClicked(car)
            }

            executePendingBindings()

        }

    }
}