package kr.hs.dgsw.juyeop.mymap.view.fragment

import android.app.DatePickerDialog
import androidx.lifecycle.Observer
import kr.hs.dgsw.juyeop.mymap.base.view.BaseFragment
import kr.hs.dgsw.juyeop.mymap.databinding.FragmentHomeBinding
import kr.hs.dgsw.juyeop.mymap.view.activity.AlertActivity
import kr.hs.dgsw.juyeop.mymap.view.activity.QrCodeActivity
import kr.hs.dgsw.juyeop.mymap.viewmodel.fragment.HomeViewModel
import kr.hs.dgsw.juyeop.mymap.viewmodelfactory.fragment.HomeViewModelFactory
import kr.hs.dgsw.juyeop.mymap.widget.extension.getViewModel
import kr.hs.dgsw.juyeop.mymap.widget.extension.startActivity
import kr.hs.dgsw.juyeop.mymap.widget.extension.startActivityWithFinish
import java.util.*
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    override val viewModel: HomeViewModel
        get() = getViewModel(viewModelFactory)

    override fun observerViewModel() {
        with(viewModel) {
            onQrCodeEvent.observe(this@HomeFragment, Observer {
                startActivity(requireContext().applicationContext, QrCodeActivity::class.java)
            })
            onDatePickerEvent.observe(this@HomeFragment, Observer {
                val datePickerDialogListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    var formatMonth = (month+1).toString()
                    var formatDay = dayOfMonth.toString()

                    if (month < 10) formatMonth = "0" + formatMonth
                    if (dayOfMonth < 10) formatDay = "0" + formatDay

                    todayDate.value = "$year-$formatMonth-$formatDay"
                    getMySpot()
                }
                val datePickerDialog = DatePickerDialog(requireContext(), datePickerDialogListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH))
                datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
                datePickerDialog.show()
            })
            onAlertEvent.observe(this@HomeFragment, Observer {
                startActivity(requireContext(), AlertActivity::class.java)
            })
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMySpot()
    }
}