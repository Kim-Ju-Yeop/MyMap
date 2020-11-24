package kr.hs.dgsw.juyeop.mymap.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.juyeop.domain.entity.Alert
import kr.hs.dgsw.juyeop.mymap.R
import kr.hs.dgsw.juyeop.mymap.databinding.ItemAlertBinding
import kr.hs.dgsw.juyeop.mymap.viewmodel.adapter.AlertItemViewModel

class AlertItemAdapter : RecyclerView.Adapter<AlertItemAdapter.ViewHolder>() {

    private lateinit var alertItemList: List<Alert>

    fun setList(alertItemList: List<Alert>) {
        this.alertItemList = alertItemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_alert, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(alertItemList[position])
        }
    }

    override fun getItemCount(): Int {
        return alertItemList.size
    }

    class ViewHolder(val binding: ItemAlertBinding): RecyclerView.ViewHolder(binding.root) {
        val viewModel = AlertItemViewModel()

        fun bind(alert: Alert) {
            viewModel.bind(alert)
            binding.viewModel = viewModel
        }
    }
}