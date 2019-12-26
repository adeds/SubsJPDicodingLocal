package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.ui.detail.DetailActivity
import ade.dicoding.sub2.util.POSTER_PATH
import ade.dicoding.sub2.util.loadImageURL
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_content.view.*
import org.jetbrains.anko.toast

class MovieAdapter(
    private val activity: Activity?,
    var contents: MutableList<Movies.Result>?
) :
    RecyclerView.Adapter<MovieAdapter.AcademyViewHolder>(), Filterable {
    var itemsFiltered: MutableList<Movies.Result>? = contents

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_content, parent, false)
        return AcademyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {
        val item = itemsFiltered?.get(position)
        if (item != null)
            item.apply {
                holder.tvTitle.text = title
                holder.tvDescription.text = overview
                holder.tvDate.text = String.format("Release: %s", releaseDate)
                holder.tvRate.text = String.format("Rating %s", popularity)
                holder.itemView.setOnClickListener { v: View? ->
                    DetailActivity.start(
                        activity!!,
                        item.title ?: "",
                        true,
                        id
                    )
                    activity?.toast(title.toString())
                }
                holder.imgPoster.loadImageURL(POSTER_PATH + posterPath)
            }
    }

    override fun getItemCount(): Int {
        return itemsFiltered?.size ?: 0
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0.toString()
                if (charString.isEmpty()) {
                    itemsFiltered = contents
                } else {
                    val filteredList = mutableListOf<Movies.Result>()
                    contents?.filter {
                        when {
                            it.title!!.contains(charString, true) ||
                                    it.overview!!.contains(charString, true) -> filteredList.add(it)
                            else -> false
                        }
                    }
                    itemsFiltered = filteredList
                }
                val filterResult = FilterResults()
                filterResult.values = itemsFiltered
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                itemsFiltered = p1?.values as MutableList<Movies.Result>
                notifyDataSetChanged()
            }

        }
    }


    inner class AcademyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle by lazy { itemView.tv_item_title }
        val tvDescription by lazy { itemView.tv_item_description }
        val tvDate by lazy { itemView.tv_item_date }
        val tvRate by lazy { itemView.tv_item_rate }
        val imgPoster by lazy { itemView.img_poster }
    }

}