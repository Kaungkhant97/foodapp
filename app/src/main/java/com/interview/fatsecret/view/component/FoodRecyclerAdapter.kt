package com.interview.fatsecret.view.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.interview.fatsecret.R
import com.interview.fatsecret.view.FoodListViewObject


class FoodRecyclerAdapter(val foodlist:ArrayList<FoodListViewObject>, val clickListner: (food:FoodListViewObject) -> Unit ) :  RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder>(){

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val idtextView: TextView;
        val nametextView: TextView;
        val amounttextView: TextView;

        init {
            // Define click listener for the ViewHolder's View.
            idtextView = view.findViewById(R.id.foodId_textview)
            nametextView = view.findViewById(R.id.foodname_textview)
            amounttextView = view.findViewById(R.id.foodamount_textview)

        }

         fun bind(food: FoodListViewObject, clickListner :(food:FoodListViewObject)->Unit) {
             idtextView.text = food.id
            nametextView.text = food.name;
            amounttextView.text = food.quantity;

            view.setOnClickListener( { clickListner(food) });


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_viewholder_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foodlist.get(position),clickListner);
    }

    override fun getItemCount(): Int {
        return foodlist.size;
    }

    fun addnewdata(foodlist: List<FoodListViewObject>?) {
        if (foodlist != null) {
            this.foodlist.clear();
            this.foodlist.addAll(foodlist)
            notifyDataSetChanged()
        };

    }
}