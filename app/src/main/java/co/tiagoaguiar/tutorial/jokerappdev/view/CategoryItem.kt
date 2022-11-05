package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem( val category: Category): Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View): GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): CategoryViewHolder {
        return CategoryViewHolder(itemView)
    }
    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.tv_category).text = category.nome
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category).setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout(): Int {
        return R.layout.item_category
    }

}