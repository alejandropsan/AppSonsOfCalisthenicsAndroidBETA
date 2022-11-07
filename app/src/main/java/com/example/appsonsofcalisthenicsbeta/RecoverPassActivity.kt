package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RecoverPassActivity : AppCompatActivity() {

    private lateinit var etEmailRecover: EditText
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_pass)

        etEmailRecover = findViewById(R.id.etEmailRecover)
        mAuth = FirebaseAuth.getInstance()
    }

    fun resetPassword(v: View){
        var email = etEmailRecover.text.toString()
        if (!TextUtils.isEmpty(email)){
            mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Email enviado a $email", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)

                    }
                    else Toast.makeText(this, "No se encontró el usuario con este correo", Toast.LENGTH_SHORT).show()
                }


        }
        else Toast.makeText(this, "Indica un email", Toast.LENGTH_SHORT).show()
    }
}