package com.joohernandes.mvvmstudy.commons

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun ImageView.setImageUrl(imageUrl: MutableLiveData<String>, placeHolder: Drawable?) {
    Glide.with(context).load(imageUrl.value).placeholder(placeHolder).into(this)
}

