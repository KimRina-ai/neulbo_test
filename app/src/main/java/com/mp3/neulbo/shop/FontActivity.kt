package com.mp3.neulbo.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.mp3.neulbo.ShopActivity


import com.mp3.neulbo.*

class FontActivity : AppCompatActivity() {

    private lateinit var goback: ImageButton

    private lateinit var font1: ImageButton
    private lateinit var font2: ImageButton
    private lateinit var font3: ImageButton

    var auth : FirebaseAuth? = null

    var myRef = FirebaseDatabase.getInstance().reference

    private lateinit var points: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_font)


        goback=findViewById(R.id.goBack)

        font1 = findViewById(R.id.font1Image)
        font2 = findViewById(R.id.font2Image)
        font3 = findViewById(R.id.font3Image)
        auth = Firebase.auth
        val uid = auth?.currentUser?.uid
        points=findViewById(R.id.pointText)

        getPointValue(uid.toString()) { currentValue ->

            points.setText(currentValue+"points")
        }


        //뒤로가기 버튼
        goback.setOnClickListener {
            val intentSend = Intent(this, ShopActivity::class.java)
            startActivity(intentSend)
            finish()
        }


    }
    fun getPointValue(userId: String, callback: (String?) -> Unit) {
        val pointRef = myRef.child("user").child(userId).child("point")
        pointRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val currentValue = dataSnapshot.getValue(Int::class.java)?.toString()
                callback(currentValue)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}