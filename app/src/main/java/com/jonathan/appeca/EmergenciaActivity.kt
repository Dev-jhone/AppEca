package com.jonathan.appeca

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.jonathan.appeca.databinding.ActivityEmergenciaBinding

class EmergenciaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmergenciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEmergenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarAcoes()
    }

    private fun configurarAcoes() {
        binding.btnLigar190.setOnClickListener { abrirDiscador("190") }
        binding.btnLigar100.setOnClickListener { abrirDiscador("100") }
        binding.btnLigar192.setOnClickListener { abrirDiscador("192") }

        binding.btnVoltar.setOnClickListener { finish() }
    }

    private fun abrirDiscador(numero: String) {
        startActivity(
            Intent(Intent.ACTION_DIAL).apply {
                data = "tel:$numero".toUri()
            }
        )
    }
}
