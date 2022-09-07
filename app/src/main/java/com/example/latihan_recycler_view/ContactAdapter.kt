package com.example.latihan_recycler_view

import android.app.Activity
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihan_recycler_view.databinding.ContactItemBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    private val diffCallBack = object : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitData(list: ArrayList<Contact>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(differ.currentList[position]) {
                binding.apply {
                    ivProfilePicture.setImageResource(profilePicture)

                    tvName.text = name
                    tvMessage.text = message
                    tvTime.text = time
                }
            }
        }

    }

    override fun getItemCount(): Int = differ.currentList.size

    class ViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root)
}