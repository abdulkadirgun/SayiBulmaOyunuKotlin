package com.rtech.saybulmaoyunukotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.rtech.saybulmaoyunukotlin.databinding.ActivityGameResultScreenBinding

class GameResultScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameResultScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameResultScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var intent = intent
        var randomSayi = intent.getIntExtra("randomSayi",0)
        var sonuc = intent.getBooleanExtra("sonuc",false)

        if (sonuc) {
            binding.textView2.text = "KAZANDINIZ"
            binding.imageView2.setImageResource(R.drawable.smile_face)
        }
        else {
            binding.textView2.text = "KAYBETTİNİZ (bulamadığınız sayı: $randomSayi)"
            binding.imageView2.setImageResource(R.drawable.sad_face)
        }
        binding.buttonTekrarOyna.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@GameResultScreenActivity,
                GameMainScreenActivity::class.java)
                finish()
                startActivity(intent)
            }
        })
    }

}