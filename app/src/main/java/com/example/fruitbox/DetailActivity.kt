
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
        val fruitName = intent.getStringExtra("FRUIT_NAME").toString()
        val fruitDescription = intent.getStringExtra("FRUIT_DESCRIPTION").toString()
        val fruitImageRes = intent.getIntExtra("FRUIT_IMAGE", 0)

        with(binding){
            textViewNameDetail.text = fruitName
            textViewDescription.text = fruitDescription
            imageViewDetail.setImageResource(fruitImageRes)



        }
    }
}
