package aula.fib.br.trabalhocubas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_candidato.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.widget.ImageView
import java.io.File
import java.nio.file.Files.exists
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.constraint.ConstraintLayout


class Candidato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidato)

        val intent = intent

        if (intent != null) {
            val voto = intent.getStringExtra("voto")

            this.candidatos(voto)
        }
    }

    private fun candidatos(voto: String){
        if(voto == "13"){
            nomeDoCandidato.text = "Haddad - PT"

            imagemCandidato.setImageResource(R.drawable.haddad)
        }
        else if(voto == "17"){
            nomeDoCandidato.text = "Bolsonaro - PDT"

            imagemCandidato.setImageResource(R.drawable.bolsonaro)
        }
        else if(voto == "10"){
            nomeDoCandidato.text = "Ronaldinho 10 - CBF"

            imagemCandidato.setImageResource(R.drawable.ronaldinho)
        }
        else{
            nomeDoCandidato.text = ""
            Toast.makeText(this@Candidato, "Erro ao votar!", Toast.LENGTH_LONG).show()
        }
    }
}
