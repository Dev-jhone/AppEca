package com.jonathan.appeca

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jonathan.appeca.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarBoasVindas()
        configurarAcoes()
    }

    private fun configurarBoasVindas() {
        val emailUsuario = intent.getStringExtra("email_usuario")

        binding.txtBoasVindas.text = if (!emailUsuario.isNullOrBlank()) {
            getString(R.string.menu_boas_vindas_usuario, emailUsuario)
        } else {
            getString(R.string.menu_boas_vindas)
        }
    }

    private fun configurarAcoes() {
        binding.btnInformacoes.setOnClickListener {
            startActivity(Intent(this, InformacoesActivity::class.java))
        }

        binding.btnEmergencia.setOnClickListener {
            startActivity(Intent(this, EmergenciaActivity::class.java))
        }

        binding.btnPontosApoio.setOnClickListener {
            startActivity(Intent(this, PontosApoioActivity::class.java))
        }

        binding.btnEca.setOnClickListener {
            startActivity(Intent(this, EcaActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            finishAffinity()
        }
    }
}
