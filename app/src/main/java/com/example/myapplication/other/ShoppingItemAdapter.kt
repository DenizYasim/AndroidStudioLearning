package com.example.myapplication.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.db.entities.Shoppingitem
import com.example.myapplication.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items : List<Shoppingitem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingitem = items[position]

        holder.itemView.tvName.text = curShoppingitem.name
        holder.itemView.tvAmount.text = "${curShoppingitem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingitem)
        }
        holder.itemView.ivPlus.setOnClickListener{
            curShoppingitem.amount++
            viewModel.upsert(curShoppingitem)
        }

        holder.itemView.ivMinus.setOnClickListener{
            if(curShoppingitem.amount>0){
                curShoppingitem.amount--
                viewModel.upsert(curShoppingitem)
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size


    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}