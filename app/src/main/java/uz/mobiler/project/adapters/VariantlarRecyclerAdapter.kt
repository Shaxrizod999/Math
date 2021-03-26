package uz.mobiler.project.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.mobiler.project.R
import uz.mobiler.project.databinding.ItemViewVariantlarBinding
import uz.mobiler.project.models.VariantlarModel
import java.util.*
import kotlin.collections.ArrayList


class VariantlarRecyclerAdapter() : RecyclerView.Adapter<VariantlarRecyclerAdapter.ViewHolder>() {


    var count = 0
    var countrueAnswers = 0
    var countisCheked = 0
    var a : Int? = null

    private val itemCallBack = object : DiffUtil.ItemCallback<VariantlarModel>() {
        override fun areItemsTheSame(oldItem: VariantlarModel, newItem: VariantlarModel): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: VariantlarModel, newItem: VariantlarModel): Boolean {
            return oldItem.question == newItem.question
        }
    }
    val differ = AsyncListDiffer(this, itemCallBack)
    inner class ViewHolder(private val binding: ItemViewVariantlarBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(variantlar: VariantlarModel) {

            binding.javob1.text = variantlar.ans1
            binding.javob2.text = variantlar.ans2
            binding.javob3.text = variantlar.ans3
            binding.javob4.text = variantlar.ans4
            binding.savolraqami.text = "$count - savol"
            Picasso.get().load(variantlar.question).into(binding.savol)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemViewVariantlarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val variantlarModel = differ.currentList[position]
        count = position + 1
        holder.onBind(variantlarModel)

        var isChekked = false
        holder.itemView.findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { _, checkedId ->
            var correct = false

            when (checkedId) {
                R.id.javob1 -> {
                        correct = variantlarModel.trueans == 1
                }
                R.id.javob2 -> {
                    correct = variantlarModel.trueans == 2
                }
                R.id.javob3 -> {
                    correct = variantlarModel.trueans == 3
                }
                R.id.javob4 -> {
                    correct = variantlarModel.trueans == 4
                }
            }

            if (correct) {
                countrueAnswers++
                if (!isChekked)
                {
                    countisCheked++
                }
                isChekked = true
            }
            else if (isChekked) {
                countrueAnswers--
            }
        }
    }
}
