package com.example.pizza2.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pizza2.Domain.BannerModel
import com.example.pizza2.Domain.CategoryModel
import com.example.pizza2.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository= MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }


}