package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterFruit: FruitAdapter
    private lateinit var fruitList: List<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.searchView.requestFocus()
        setContentView(binding.root)

        fruitList = generateFruitData()
        adapterFruit = FruitAdapter(fruitList) { fruit ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("FRUIT_NAME", fruit.name)
            intent.putExtra("FRUIT_WEIGHT", fruit.weight)
            intent.putExtra("FRUIT_IMAGE", fruit.gambar)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Anda Memilih ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvFruit.apply {
                adapter = adapterFruit
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            }

            // Mengatur listener untuk SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    // Ketika pengguna memasukkan teks pencarian, filter data buah
                    filterFruit(newText)
                    return true
                }
            })
        }
    }

    private fun filterFruit(query: String?) {
        val filteredFruitList = if (!query.isNullOrBlank()) {
            fruitList.filter { it.name.contains(query, ignoreCase = true) }
        } else {
            fruitList
        }

        // Perbarui data yang ditampilkan oleh adapter dengan data buah yang sudah difilter
        adapterFruit.updateData(filteredFruitList)
    }

    private fun generateFruitData(): List<Fruit> {
        return listOf(
            Fruit("Apel", "1kg", R.drawable.apple),
            Fruit("Pisang", "1kg", R.drawable.bananas),
            Fruit("Jeruk", "1kg", R.drawable.orange),
            Fruit("Mangga", "1kg", R.drawable.mango),
            Fruit("Anggur", "1kg", R.drawable.grape),
            Fruit("Semangka", "1kg", R.drawable.watermelon),
            Fruit("Nanas", "1kg", R.drawable.pineapple),
            Fruit("Strawberry", "1kg", R.drawable.strawberry),
            Fruit("Ceri", "1kg", R.drawable.cherries),
            Fruit("Persik", "1kg", R.drawable.peach)
        )
    }
}
