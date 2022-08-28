package jp.co.yumemi.android.code_check.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import jp.co.yumemi.android.code_check.SearchFragmentDirections
import jp.co.yumemi.android.code_check.data.Item
import jp.co.yumemi.android.code_check.databinding.RvItemSearchFragmentBinding

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
     lateinit var mContext:Context
     var listSearch= listOf<Item>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: RvItemSearchFragmentBinding): RecyclerView.ViewHolder (binding.root) {

        fun onBind(item: Item) {
            binding.repositoryNameView.text=item.name
            binding.rvItemSearch.setOnClickListener{
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemSearchFragmentBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listSearch[position])
        holder.itemView.setOnClickListener{
            val action =
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    listSearch[position]
                )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount():Int{
        return listSearch.size
    }

}