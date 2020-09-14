package com.m2f.imdb.features.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.m2f.imdb.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_character.view.*

typealias CharacterUI = com.m2f.IMDB.core.common.model.domain.Character

class CharacterAdapter(private val onItemSelected: (CharacterUI) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.CharacterUIViewholder>(), Filterable {

    private var originalData: List<CharacterUI> = emptyList()

    private var data: List<CharacterUI> = emptyList()
        set(newList) {
            val calculateDiff = DiffUtil.calculateDiff(CharacterUIDiffCallback(field, newList))
            calculateDiff.dispatchUpdatesTo(this)
            field = newList
        }

    fun initData(list: List<CharacterUI>) {
        originalData = list
        data = list
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterUIViewholder {
        return CharacterUIViewholder(
          LayoutInflater.from(parent.context)
            .inflate(R.layout.row_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterUIViewholder, position: Int) {
        holder.bind(data[position])
    }

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterCharacterUI: String = constraint.toString().toLowerCase()

            val results = FilterResults()

            val list: List<CharacterUI> = originalData

            val count = list.size
            val nlist = mutableListOf<CharacterUI>()

            var filterableCharacterUI: CharacterUI

            for (i in 0 until count) {
                filterableCharacterUI = list[i]
                if (filterableCharacterUI.name.toLowerCase().contains(filterCharacterUI)) {
                    nlist.add(filterableCharacterUI)
                }
            }

            results.values = nlist
            results.count = nlist.size

            return results
        }

        override fun publishResults(constraint: CharSequence, result: FilterResults) {
            data = result.values as List<CharacterUI>
        }

    }

    inner class CharacterUIViewholder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(item: CharacterUI) = with(itemView) {
            val image = "${item.thumbnail.path}.${item.thumbnail.extension}".replace("http", "https")
            Glide.with(iv_character).load(image).into(iv_character)
            tv_character.text = item.name
            setOnClickListener {
                onItemSelected(item)
            }
        }
    }

}

class CharacterUIDiffCallback(private val oldList: List<CharacterUI>, private val newList: List<CharacterUI>) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return old.id == new.id &&
                old.name == new.name &&
                old.comics.size == new.comics.size &&
                old.description == new.description &&
                old.modified == new.modified &&
                old.resourceURI == new.resourceURI &&
                old.series.size == new.series.size &&
                old.thumbnail == new.thumbnail &&
                old.urls.size == new.urls.size
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }
}