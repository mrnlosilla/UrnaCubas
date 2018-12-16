package aula.fib.br.trabalhocubas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_votar.*
import android.media.MediaPlayer


class Votar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_votar)

        val botaoVotar = findViewById<Button>(R.id.votar)
        botaoVotar.setOnClickListener {
            var voto = numbers.text.toString()

            if (voto.isEmpty()) {
                Toast.makeText(this@Votar, "Digite um número!", Toast.LENGTH_LONG).show()
            }
            else if(voto != "13" && voto != "17" && voto != "10"){
                Toast.makeText(this@Votar, "Candidato Inexistente!", Toast.LENGTH_LONG).show()
            }
            else {
                var mp = MediaPlayer.create(this, R.raw.urna)

                try {
                    if (mp.isPlaying) {
                        mp.stop()
                        mp.release()
                        mp = MediaPlayer.create(this, R.raw.urna)
                    }

                    mp.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                val intent = Intent(this@Votar, Candidato::class.java)
                intent.putExtra("voto", voto)
                startActivity(intent)
            }
        }
    }
}
