package com.example.submissionbeginnerandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionbeginnerandroid.databinding.ItemCarBinding

class ListCarAdapter(private val listCar: ArrayList<Car>) : RecyclerView.Adapter<ListCarAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCar[position]
        holder.binding.apply {
            imgItemPhoto.setImageResource(photo)
            tvItemName.text = name
            tvItemDescription.text = description

            root.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_NAME, name)
                    putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
                    putExtra(DetailActivity.EXTRA_PHOTO, photo)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = listCar.size

    class ListViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root)
}
