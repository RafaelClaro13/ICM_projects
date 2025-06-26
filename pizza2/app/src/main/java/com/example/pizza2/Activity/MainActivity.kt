package com.example.pizza2.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pizza2.Adapter.CategoryAdapter
import com.example.pizza2.ViewModel.MainViewModel
import com.example.pizza2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel= MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initCategory()
    }

    private fun initCategory() {
        binding.progressBarBanner.visibility=View.VISIBLE
        viewModel.loadCategory().observeForever(){
            binding.categoryView
                .layoutManager=LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.HORIZONTAL,false

            )
            binding.categoryView.adapter=CategoryAdapter(it)
            binding.progressBarCategory.visibility= View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner(){
        binding.progressBarBanner.visibility= View.VISIBLE

        viewModel.loadBanner().observeForever{
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility= View.GONE
        }
        viewModel.loadBanner()
    }
}