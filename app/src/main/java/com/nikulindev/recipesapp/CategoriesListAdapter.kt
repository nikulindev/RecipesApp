package com.nikulindev.recipesapp

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikulindev.recipesapp.data.Category
import com.nikulindev.recipesapp.databinding.ItemCategoryBinding
import java.io.InputStream


class CategoriesListAdapter(private val dataSet: List<Category>) :
    RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick()
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val category: Category = dataSet[position]

        val drawable = try {
            val inputStream: InputStream? =
                viewHolder.binding.imageCategory.context.assets?.open(dataSet[position].imageUrl)
            Drawable.createFromStream(inputStream, null)

        } catch (e: Exception) {
            Log.e("!!!", "Image not found: ${category.imageUrl}")
            e.printStackTrace()
            null
        }

        with(viewHolder.binding) {
            textCategoryTitle.text = category.title
            textCategoryDescription.text = category.description
            imageCategory.setImageDrawable(drawable)
            imageCategory.contentDescription = "Изображение категории ${category.title}"
            root.setOnClickListener {
                itemClickListener?.onItemClick()
            }
        }

    }

    override fun getItemCount() = dataSet.size

}