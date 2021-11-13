package com.rtech.saybulmaoyunukotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rtech.saybulmaoyunukotlin.databinding.ActivityGamePageBinding

class GameMainScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGamePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sayac = 5
        var randomSayi = (0..100).random()

        binding.textViewKalanHak.text = "Kalan Hak: $sayac, Random sayı: " + randomSayi.toString()



        binding.buttonTahminEt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                sayac--

                var sayi : Int? = null
                sayi  = binding.edittextTahminSayi.text.toString().toIntOrNull()

                if(sayi == null){
                    Toast.makeText(applicationContext, "lütfen sayı giriniz",
                        Toast.LENGTH_SHORT).show()
                    sayac++
                    return
                }

                if(sayac == 0 || sayi == randomSayi){
                    val intent = Intent(this@GameMainScreenActivity,
                        GameResultScreenActivity::class.java)

                    if (sayi == randomSayi)
                        intent.putExtra("sonuc",true)
                    else
                        intent.putExtra("sonuc",false)

                    intent.putExtra("randomSayi",randomSayi)
                    finish()
                    startActivity(intent)
                }
                else if(sayi < randomSayi) {
                    binding.textViewYonlendir.setTextColor(Color.GREEN)
                    binding.textViewYonlendir.text = "ARTTIR"
                    binding.edittextTahminSayi.setText("")
                }
                else{
                    binding.textViewYonlendir.setTextColor(Color.RED)
                    binding.textViewYonlendir.text = "AZALT"
                    binding.edittextTahminSayi.setText("")
                }

                binding.textViewKalanHak.text = "Kalan Hak: ${sayac}, Random sayı: " +
                        randomSayi.toString()


            }
        })
    }

}
