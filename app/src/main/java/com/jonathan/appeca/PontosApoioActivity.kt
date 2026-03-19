package com.jonathan.appeca

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.jonathan.appeca.databinding.ActivityPontosApoioBinding

class PontosApoioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPontosApoioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPontosApoioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarAcoes()
    }

    private fun configurarAcoes() {
        binding.btnVoltar.setOnClickListener { finish() }

        binding.btnCras.setOnClickListener {
            abrirMapa(getString(R.string.cras_endereco))
        }

        binding.btnCreas.setOnClickListener {
            abrirMapa(getString(R.string.creas_endereco))
        }

        binding.btnConselhoTutelar.setOnClickListener {
            abrirMapa(getString(R.string.conselho_tutelar_endereco))
        }
    }

    private fun abrirMapa(endereco: String) {
        val uri = "geo:0,0?q=$endereco".toUri()

        try {
            startActivity(
                Intent(Intent.ACTION_VIEW, uri)
                    .setPackage("com.google.android.apps.maps")
            )
        } catch (_: Exception) {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            } catch (_: Exception) {
                Toast.makeText(
                    this,
                    getString(R.string.erro_mapa),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
