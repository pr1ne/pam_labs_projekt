package com.example.project4.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.project4.R
import com.example.project4.model.ConsultationCard

class ItemAdapter(private val context: Context, private val dataset: MutableList<ConsultationCard>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.avatarImg)
        val dName: TextView = view.findViewById(R.id.docName)
        val address: TextView = view.findViewById(R.id.addr)
        val cab: TextView = view.findViewById(R.id.cab)
        val time: TextView = view.findViewById(R.id.time)
        val date: TextView = view.findViewById(R.id.date)
        val call: com.google.android.material.button.MaterialButton = view.findViewById(R.id.callDoc)
        val remove: com.google.android.material.button.MaterialButton = view.findViewById(R.id.dismissCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.avatar)
        holder.dName.text =  context.resources.getString(item.dName)
        holder.address.text =  context.resources.getString(item.address)
        holder.cab.text =  context.resources.getString(item.cab)
        holder.time.text = item.time
        holder.date.text =  item.date

        holder.call.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + item.number)
            context.startActivity(intent)
        }
        holder.remove.setOnClickListener{
            dataset.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataset.size)
        }
    }

    override fun getItemCount() = dataset.size
}