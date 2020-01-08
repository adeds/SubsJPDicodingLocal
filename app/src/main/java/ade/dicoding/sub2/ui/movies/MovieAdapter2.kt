package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.util.POSTER_PATH
import ade.dicoding.sub2.util.loadImageURL
import android.util.Log
import android.view.View
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow
import kotlinx.android.synthetic.main.items_content.view.*


class MovieAdapter2(private val delegate: Holder.Delegate) : BaseAdapter() {
    private val section_item = 0

    init {
        addSectionMovie()
    }

    fun addItems(items: ArrayList<MoviesEntity>) {
        addItemListOnSection(section_item,items)
        notifyDataSetChanged()
    }

    override fun layout(sectionRow: SectionRow) = R.layout.items_content

    override fun viewHolder(layout: Int, view: View) = Holder(view, delegate)

    fun changeItems(list: MutableList<MoviesEntity>) {
        removeSection<ArrayList<MoviesEntity>>(0)
        addSectionMovie()
        addItemListOnSection(0,list)
        notifyDataSetChanged()
    }

     fun addSectionMovie() {
        addSection(ArrayList<MoviesEntity>())
    }

}

class Holder(view: View, private val delegate: Delegate) : BaseViewHolder(view) {
    interface Delegate {
        fun itemClick(movie: MoviesEntity)
    }

    private lateinit var movie: MoviesEntity

    override fun bindData(data: Any) {
        if (data is MoviesEntity) {
            movie = data
            itemView.apply {
                movie.apply {
                    tv_item_title.text = title
                    tv_item_description.text = overview
                    tv_item_date.text = String.format("Release: %s", releaseDate)
                    tv_item_rate.text = String.format("Rating %s", popularity)
//                    setOnClickListener { v: View? ->
//                        DetailActivity.startMovie(activity, item)
//                    }
                    img_poster.loadImageURL(POSTER_PATH + posterPath)
                }
            }
        }
    }

    override fun onClick(p0: View?) = delegate.itemClick(movie)

    override fun onLongClick(p0: View?): Boolean = false
}
