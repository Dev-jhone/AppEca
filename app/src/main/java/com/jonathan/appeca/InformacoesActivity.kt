package com.jonathan.appeca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jonathan.appeca.databinding.ActivityInformacoesBinding

class InformacoesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformacoesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInformacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener { finish() }
    }
}
