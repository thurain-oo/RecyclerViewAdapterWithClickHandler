package com.example.viewholderassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewholderassignment.R
import com.example.viewholderassignment.model.Vouncher
import kotlin.time.seconds

class VouncherItemAdapter(val context: Context,val dataset: List<Vouncher>):
    RecyclerView.Adapter<VouncherItemAdapter.VouncherItemViewHolder>() {

     var onVouncherItemClickListener: OnVouncherItemClickListener? = null

    fun setOnClickListener(clickListener: OnVouncherItemClickListener) {
        this.onVouncherItemClickListener = clickListener
    }

    class VouncherItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val customerName : TextView = view.findViewById(R.id.customer_name)
        val serialNo : TextView = view.findViewById(R.id.serial_no)
        val imageView : ImageView = view.findViewById(R.id.image_view)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VouncherItemViewHolder {
       val adapterLayout = LayoutInflater.from(parent.context)
           .inflate(R.layout.list_item,parent,false)
               return VouncherItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: VouncherItemViewHolder, position: Int) {
       val item = dataset[position]
        holder.customerName.text = context.resources.getString(item.customerName)
        holder.serialNo.text = context.resources.getString(item.serialNo)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.itemView.setOnClickListener {
        onVouncherItemClickListener!!.onVouncherItemClicked(item)

        }
    }

    override fun getItemCount(): Int {
      return dataset.size
    }
    interface OnVouncherItemClickListener{
        fun onVouncherItemClicked( vouncher : Vouncher)
    }
}


