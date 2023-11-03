
package com.example.fruitbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fruitbox.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data buah dari Intent
        val fruitName = intent.getStringExtra("FRUIT_NAME")
        val fruitWeight = intent.getStringExtra("FRUIT_WEIGHT")
        val fruitImageRes = intent.getIntExtra("FRUIT_IMAGE", R.drawable.apple)

        // Menetapkan data buah ke antarmuka pengguna
        binding.imageViewDetail.setImageResource(fruitImageRes)
        binding.textViewNameDetail.text = fruitName
    }
}
