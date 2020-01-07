package ade.dicoding.sub2.ui.favorites.tivshow

import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.util.POSTER_PATH
import ade.dicoding.sub2.util.loadImageURL
import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_content.view.*

class TVFavAdapter(
    private val activity: Activity?,
    val callback: CallbackAdapter
) :
    PagedListAdapter<TVDetailEntity, TVFavAdapter.Holder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_content, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        if (item != null)
            item.apply {
                holder.tvTitle.text = title
                holder.tvDescription.text = overview
                holder.tvDate.text = String.format("Release: %s", firstAirDate)
                holder.tvRate.text = String.format("Rating %s", popularity)
                holder.itemView.setOnClickListener { v: View? ->
                    callback.clicked(item)
                }
                holder.imgPoster.loadImageURL(POSTER_PATH + posterPath)
            }
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle by lazy { itemView.tv_item_title }
        val tvDescription by lazy { itemView.tv_item_description }
        val tvDate by lazy { itemView.tv_item_date }
        val tvRate by lazy { itemView.tv_item_rate }
        val imgPoster by lazy { itemView.img_poster }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVDetailEntity> =
            object : DiffUtil.ItemCallback<TVDetailEntity>() {

                override fun areItemsTheSame(
                    oldNote: TVDetailEntity,
                    newNote: TVDetailEntity
                ): Boolean {
                    return oldNote.id == newNote.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldNote: TVDetailEntity,
                    newNote: TVDetailEntity
                ): Boolean {
                    return oldNote == newNote
                }
            }
    }

    interface CallbackAdapter {
        fun clicked(item: TVDetailEntity?)
    }

}