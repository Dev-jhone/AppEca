package com.jonathan.appeca

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jonathan.appeca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarEstadoInicial()
        iniciarAnimacoes()
        configurarNavegacao()
    }

    private fun configurarEstadoInicial() {
        listOf(
            binding.txtTitulo,
            binding.txtDescricao,
            binding.btnIniciar
        ).forEach {
            it.alpha = 0f
            it.translationY = 40f
        }
    }

    private fun iniciarAnimacoes() {
        animar(binding.txtTitulo, 200)
        animar(binding.txtDescricao, 400)
        animar(binding.btnIniciar, 600)
    }

    private fun animar(view: android.view.View, delay: Long) {
        view.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(delay)
            .start()
    }

    private fun configurarNavegacao() {
        binding.btnIniciar.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}
