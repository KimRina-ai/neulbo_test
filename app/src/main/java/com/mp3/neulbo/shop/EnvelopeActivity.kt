package com.mp3.neulbo.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.mp3.neulbo.ShopActivity


import com.mp3.neulbo.*

class EnvelopeActivity : AppCompatActivity() {

    private lateinit var goback: ImageButton

    private lateinit var envelope1: ImageButton
    private lateinit var envelope2: ImageButton
    private lateinit var envelope3: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_envelope)


        goback=findViewById(R.id.goBack)

        envelope1 = findViewById(R.id.envelope1Image)
        envelope2 = findViewById(R.id.envelope2Image)
        envelope3 = findViewById(R.id.envelope3Image)


        //뒤로가기 버튼
        goback.setOnClickListener {
            val intentSend = Intent(this, ShopActivity::class.java)
            startActivity(intentSend)
            finish()
        }


    }
}