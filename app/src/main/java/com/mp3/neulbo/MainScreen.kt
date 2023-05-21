package com.mp3.neulbo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.ImageButton
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.coroutines.delay

class MainScreen : AppCompatActivity() {


    private lateinit var add_button: ImageButton
    private lateinit var calendar_button: ImageButton
    private lateinit var message: ImageButton
    private lateinit var paper_plane: ImageView
    private lateinit var plane: Animation
    private lateinit var plane_2: Animation



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        add_button = findViewById(R.id.add)
        calendar_button=findViewById(R.id.calendar)
        paper_plane=findViewById(R.id.paper_plane)
        message=findViewById(R.id.message)
        plane=AnimationUtils.loadAnimation(this,R.anim.save_diary)
        plane_2=AnimationUtils.loadAnimation(this,R.anim.receive)


        if(intent.hasExtra("login")) {
            message.startAnimation(plane_2)
        }

        paper_plane.visibility= View.INVISIBLE
        if(intent.hasExtra("diaryText")){
            paper_plane.visibility= View.VISIBLE
            paper_plane.startAnimation(plane)
            paper_plane.visibility= View.INVISIBLE

        }
        //일기 추가 버튼
        add_button.setOnClickListener {
            val intent = Intent(this, DiaryActivity::class.java)
            startActivity(intent)
            finish()

        }
        //캘린더 버튼
        calendar_button.setOnClickListener{
            val intent = Intent(this, calendar::class.java)
            startActivity(intent)
            finish()
        }
        //비행기 버튼
        message.setOnClickListener{
            message.setAlpha(0)
            message.setClickable(false)
        }


    }


}