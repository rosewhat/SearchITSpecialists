package com.moskovsky.searchitspecialists.ui.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.moskovsky.searchitspecialists.R
import com.moskovsky.searchitspecialists.databinding.ItemSpecialistsInfoBinding
import com.moskovsky.searchitspecialists.domain.User
import com.moskovsky.searchitspecialists.ui.SpecialistsAdapter
import com.moskovsky.searchitspecialists.ui.user.DetailUserFragment

class CategoriesSpecialistsAdapter (private val specialists: List<User>) :
RecyclerView.Adapter<CategoriesSpecialistsAdapter.SpecialistViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialistViewHolder {
        val binding =
            ItemSpecialistsInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecialistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecialistViewHolder, position: Int) {
        val user = specialists[position]
        holder.bind(specialists[position])
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val fragment = DetailUserFragment()
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            fragment.arguments = bundle

            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = specialists.size

    inner class SpecialistViewHolder(private val binding: ItemSpecialistsInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(specialist: User) {
            binding.tvItemName.text = specialist.name
            binding.tvItemSurname.text = specialist.surname
            binding.tvItemSpec.text = specialist.specialist


            binding.techContainer.removeAllViews() // Удаляем предыдущие технологии

            // Проверяем, что selectedTechnologies не является null
            specialist.selectedTechnologies?.let { technologies ->
                for (tech in technologies) {
                    val textView = TextView(binding.root.context).apply {
                        text = tech.trim()
                        setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
                        setBackgroundResource(R.drawable.rounded_text)
                        setPadding(24, 24, 24, 24) // Увеличиваем padding
                        textSize = 18f
                        layoutParams = ViewGroup.MarginLayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply {
                            setMargins(16, 16, 16, 16) // Увеличиваем margin
                        }
                    }
                    binding.techContainer.addView(textView)
                }
            }

        }
    }
}