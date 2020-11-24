package kr.hs.dgsw.juyeop.mymap.view.adapter

import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.juyeop.mymap.databinding.ItemSpotBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.adapter.SpotItemViewModel

class SpotItemAdapter {


    class ViewHolder(val binding: ItemSpotBinding): RecyclerView.ViewHolder(binding.root) {
        val viewModel = SpotItemViewModel()

        fun bind() {

        }
    }
}