package io.irfanshadikrishad.assignment4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import io.irfanshadikrishad.assignment4.R
import io.irfanshadikrishad.assignment4.models.DataModel

class CustomAdapter(
    private val context: Context,
    private val dataList: List<DataModel>
) : BaseAdapter() {

    override fun getCount(): Int = dataList.size

    override fun getItem(position: Int): Any = dataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.itemImage)
        val titleView = view.findViewById<TextView>(R.id.itemTitle)
        val descriptionView = view.findViewById<TextView>(R.id.itemDescription)

        val item = dataList[position]
        imageView.setImageResource(item.imageResId)
        titleView.text = item.title
        descriptionView.text = item.description

        return view
    }
}
