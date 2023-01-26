package com.example.clickcpunter

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.clickcpunter.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
//var viewModel: MainViewModel = MainViewModel()
class MainActivity : AppCompatActivity() {
    var bildingclass: ActivityMainBinding? = null // когда нельзя инницилизировать переменную сразу
    val viewModels: MainViewModel by viewModels()
    private var count = 0 //


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //

        bildingclass =
            ActivityMainBinding.inflate(layoutInflater) // инструмент для упрощения взаимодействия с VIEW
        setContentView(bildingclass?.root) // получение ссылки на root


        val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "database"
        ).build() // проимходит использования DAO для создания экземпляра базы данных
        val dao = db.dao() //
        lifecycleScope.launch {
            count = dao.getAll().firstOrNull()?.count ?: 0
            bildingclass?.textView?.text = count.toString()
        } // происходмит передача данных в фоновом режиме
        bildingclass?.buttonCounter?.setOnClickListener {
            viewModels.setColor(Color.GREEN)
            count++
            bildingclass?.textView?.text = count.toString()
            lifecycleScope.launch {
                dao.insert(Entity(1, count))
            }// происходит запис в фоновом режиме
        }




        lifecycleScope.launch {
            viewModels.color.collect {
                bildingclass?.layout?.setBackgroundColor(it)
            }

        }
    }
}





