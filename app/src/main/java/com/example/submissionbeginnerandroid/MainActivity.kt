package com.example.submissionbeginnerandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionbeginnerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.carSubs.setHasFixedSize(true)

        list.addAll(getListCars())
        showRecyclerList()
    }

    private fun getListCars(): ArrayList<Car> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCar = ArrayList<Car>()
        for (i in dataName.indices) {
            val car = Car(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCar.add(car)
        }
        dataPhoto.recycle()
        return listCar
    }

    private fun showRecyclerList() {
        binding.carSubs.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        binding.carSubs.adapter = listCarAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Pindah ke AboutActivity
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}