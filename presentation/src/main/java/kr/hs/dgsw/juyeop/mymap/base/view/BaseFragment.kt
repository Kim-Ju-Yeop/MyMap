package kr.hs.dgsw.juyeop.mymap.base.view

import androidx.databinding.ViewDataBinding
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import kr.hs.dgsw.juyeop.mymap.R
import kr.hs.dgsw.juyeop.mymap.BR
import kr.hs.dgsw.juyeop.mymap.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

abstract class BaseFragment<VB: ViewDataBinding, VM: BaseViewModel> : DaggerFragment() {

    private lateinit var mBinding: VB
    private lateinit var mViewModel: VM

    protected abstract val viewModel: VM
    protected abstract fun observerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
        observerViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mBinding.isInitialized) mBinding.unbind()
    }

    private fun setUp() {
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        mBinding.setVariable(BR.viewModel, mViewModel)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
    }

    private fun layoutRes(): Int {
        val split = ((Objects.requireNonNull<Type>(javaClass.genericSuperclass) as ParameterizedType).actualTypeArguments[0] as Class<*>)
            .simpleName.replace("Binding$".toRegex(), "")
            .split("(?<=.)(?=\\p{Upper})".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()
        for (i in split.indices) {
            name.append(split[i].toLowerCase(Locale.ROOT))
            if (i != split.size - 1) name.append("_")
        }
        return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
    }
}