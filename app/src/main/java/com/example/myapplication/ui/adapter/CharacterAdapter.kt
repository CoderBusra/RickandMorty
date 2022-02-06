package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.CharacterRickMorty
import com.example.myapplication.databinding.ListItemBinding
import java.util.*

class CharacterAdapter(
    val characterList: ArrayList<CharacterRickMorty>,
    val listener: CharacterClickListener
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    class CharacterViewHolder(var view: ListItemBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ListItemBinding>(
            inflater,
            R.layout.list_item, parent, false
        )
        return CharacterViewHolder(view)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        holder.view.data = characterList[position]
        holder.view.listener = listener
    }


    fun updateCharacterList(newCountryList: List<CharacterRickMorty>) {
        characterList.clear()
        characterList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}