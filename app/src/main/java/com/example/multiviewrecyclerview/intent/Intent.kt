package com.example.multiviewrecyclerview.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

inline fun <reified T : Any> Activity.extraNotNull(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.getLong(key)
    requireNotNull(if (value is T) value else default) { key }
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

inline fun <reified T : Any> Context.launchActivity(
    vararg pairs: Pair<String, Any?>
) {
    val intent = newIntent<T>(this)
    intent.putExtras(bundleOf(*pairs))
    startActivity(intent)
}