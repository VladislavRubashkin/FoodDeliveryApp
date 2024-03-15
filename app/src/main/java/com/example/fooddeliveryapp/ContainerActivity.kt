package com.example.fooddeliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * TODO !!!!!ПРИ СОЗДАНИИ НОВОЙ ВЕТКИ В Git, ПЕРЕКЛЮЧАТЬСЯ ОБРАТНО В Master И ДЕЛАТЬ New Branch ОТ НЕЁ!!!!!
 */

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_container)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}