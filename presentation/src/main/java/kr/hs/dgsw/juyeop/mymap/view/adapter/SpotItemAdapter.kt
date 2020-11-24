package kr.hs.dgsw.juyeop.mymap.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.juyeop.domain.entity.Spot
import kr.hs.dgsw.juyeop.mymap.R
import kr.hs.dgsw.juyeop.mymap.databinding.ItemSpotBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.adapter.SpotItemViewModel

class SpotItemAdapter : RecyclerView.Adapter<SpotItemAdapter.ViewHolder>() {

    private lateinit var spotItemList: List<Spot>

    fun setList(spotItemList: List<Spot>) {
        this.spotItemList = spotItemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(spotItemList[position])
        }
    }

    override fun getItemCount(): Int {
        return spotItemList.size
    }

    class ViewHolder(val binding: ItemSpotBinding): RecyclerView.ViewHolder(binding.root) {
        val viewModel = SpotItemViewModel()

        fun bind(spot: Spot) {
            viewModel.bind(spot)
            binding.viewModel = viewModel
        }
    }
}