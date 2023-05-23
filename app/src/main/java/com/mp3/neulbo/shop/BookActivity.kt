package com.mp3.neulbo.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.mp3.neulbo.ShopActivity


import com.mp3.neulbo.*

class BookActivity : AppCompatActivity() {

    private lateinit var goback: ImageButton

    private lateinit var item1: ImageButton
    private lateinit var item2: ImageButton
    private lateinit var item3: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_book)


        goback=findViewById(R.id.goBack)

        item1 = findViewById(R.id.item1Image)
        item2 = findViewById(R.id.item2Image)
        item3 = findViewById(R.id.item3Image)


        //뒤로가기 버튼
        goback.setOnClickListener {
            val intentSend = Intent(this, ShopActivity::class.java)
            startActivity(intentSend)
            finish()
        }


    }
}