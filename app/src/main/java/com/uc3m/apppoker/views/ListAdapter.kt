package com.uc3m.apppoker.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uc3m.apppoker.databinding.RecyclerViewItemBinding
import com.uc3m.apppoker.models.Hand
import com.uc3m.apppoker.models.Usuario
//class ListAdapter{}

 class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var handList = emptyList<Hand>()


    class MyViewHolder(val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItemHand = handList[position]
        val currentItemUser =
        with(holder){
            //binding.nickName.text = "Registro de todas las manos"
            binding.Manos.text = currentItemHand.hand.toString()


        }
    }

    override fun getItemCount(): Int {

        return handList.size
    }

    fun setData(hands: List<Hand>){
        this.handList = hands
        notifyDataSetChanged()
    }



 }
