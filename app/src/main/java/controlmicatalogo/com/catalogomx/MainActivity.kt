package controlmicatalogo.com.catalogomx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token
                Log.d("token: ", token)

                edit_text_token.setText(token)

                // Log and toast
                //val msg = getString("Hola este es el token", token)
                Toast.makeText(baseContext, "Token Obtenido", Toast.LENGTH_SHORT).show()
            })

        FirebaseMessaging.getInstance().subscribeToTopic("ofertas")
            .addOnCompleteListener { task ->
                var msg = "Subcripcion a tema exitoso"
                if (!task.isSuccessful) {
                    msg = "Subscripcion a tema no completado"
                }
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
    }
}
