package kr.hs.dgsw.juyeop.mymap.widget.extension

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

fun Fragment.startActivity(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Fragment.startActivityWithFinish(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    requireActivity().finish()
}

fun Fragment.startActivityWithValue(context: Context, name: String, activity: Class<*>, value: Serializable) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(name, value))
}

fun Fragment.shortSnackbar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

inline fun <reified T: ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory)[T::class.java]
}
inline fun <reified T: ViewModel> Fragment.getViewModel(): T {
    return ViewModelProvider(this)[T::class.java]
}