package com.uc3m.apppoker.views
/*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uc3m.apppoker.databinding.RecyclerViewItemBinding
import com.uc3m.apppoker.models.Usuario


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(), android.widget.ListAdapter {

    private var userList = emptyList<Usuario>()

    class MyViewHolder(val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        with(holder){
            binding.firstName.text = currentItem.nickname.toString()
            binding.LastName.text = currentItem.password.toString()

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(usuarioList: List<Usuario>){
        this.userList = usuarioList
        notifyDataSetChanged()
    }

}*/