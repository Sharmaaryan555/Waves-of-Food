package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.example.wavesoffood.databinding.NotificationItemBinding

class NotificationAdapter(private var notification:ArrayList<String>,private var notificationImage :ArrayList<Int>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
       val bindings = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(bindings)
    }

    override fun getItemCount(): Int = notification.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
      holder.bind(position)
    }

    inner class NotificationViewHolder(private val bindings: NotificationItemBinding) :RecyclerView.ViewHolder(bindings.root) {
        fun bind(position: Int) {
           bindings.apply {
               notificationTextView.text = notification[position]
               notificationImageView.setImageResource(notificationImage[position])
           }
        }

    }
}