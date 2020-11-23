package kr.hs.dgsw.juyeop.mymap.widget.extension

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

fun AppCompatActivity.startActivity(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun AppCompatActivity.startActivityWithFinish(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    this.finish()
}

fun AppCompatActivity.startActivityWithTwoValue(context: Context, name1: String, name2: String, activity: Class<*>, value1: Serializable, value2: Serializable) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(name1, value1).putExtra(name2, value2))
}

fun AppCompatActivity.shortSnackbar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

inline fun <reified T: ViewModel> AppCompatActivity.getViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory)[T::class.java]
}
inline fun <reified T: ViewModel> AppCompatActivity.getViewModel(): T {
    return ViewModelProvider(this)[T::class.java]
}