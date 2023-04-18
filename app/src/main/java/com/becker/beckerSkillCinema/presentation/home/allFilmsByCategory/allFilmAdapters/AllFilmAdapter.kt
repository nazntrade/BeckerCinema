package com.becker.beckerSkillCinema.presentation.home.allFilmsByCategory.allFilmAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.becker.beckerSkillCinema.databinding.ItemFilmBinding
import com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem
import com.becker.beckerSkillCinema.utils.loadImage

class AllFilmAdapter(
    private val onClick: (Int) -> Unit
) : PagingDataAdapter<com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem, AllFilmAdapter.AllFilmViewHolder>(AllFilmsDiffUtil()) {

    class AllFilmsDiffUtil : DiffUtil.ItemCallback<com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem>() {
        override fun areItemsTheSame(
            oldItem: com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem,
            newItem: com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem
        ) = oldItem.filmId == newItem.filmId

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem,
            newItem: com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem
        ) = oldItem == newItem
    }

    override fun onBindViewHolder(holder: AllFilmViewHolder, position: Int) {
        val item = getItem(position)
        (holder.binding).apply {
            item?.let {
                holder.binding.apply {
                    itemFilmPoster.loadImage(item.posterUrlPreview)
                    itemFilmName.text = item.nameRu
                    itemFilmGenre.text = item.genres.joinToString(", ") { it.genre }
                    if (item.rating != null) {
                        itemFilmRating.isInvisible = false
                        itemFilmRating.text = item.rating
                    } else itemFilmRating.isInvisible = true
                    itemFilmYear.text = item.yearHomeItem
                }
            }
        }
        holder.binding.itemFilmPoster.setOnClickListener { onClick(item!!.filmId) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFilmViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllFilmViewHolder(binding)
    }

    class AllFilmViewHolder(
        val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root)
}