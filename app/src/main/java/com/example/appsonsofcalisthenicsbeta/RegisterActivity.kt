package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity() {


        private var userName by Delegates.notNull<String>()
        private var email by Delegates.notNull<String>()
        private var password by Delegates.notNull<String>()
        private var rePassword by Delegates.notNull<String>()



    private lateinit var etNewUser: EditText
    private lateinit var etNewEmail: EditText
    private lateinit var etNewPassword: EditText
    private lateinit var etConfirmPass: EditText
    private lateinit var cbTerms:CheckBox
    private lateinit var tvConditions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNewUser = findViewById(R.id.etNewUser)
        etNewEmail = findViewById(R.id.etnewEmail)
        etNewPassword = findViewById(R.id.etNewPassword)
        etConfirmPass = findViewById(R.id.etConfirmPass)

        cbTerms = findViewById(R.id.cbTerms)
        tvConditions = findViewById(R.id.tvConditions)

    }

    fun register(view: View){

        userName = etNewUser.text.toString()
        email = etNewEmail.text.toString()
        password = etNewPassword.text.toString()
        rePassword = etConfirmPass.text.toString()

        if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty())
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()

        if (!cbTerms.isChecked) Toast.makeText(this,"Acepta los términos y condiciones de uso", Toast.LENGTH_SHORT).show()

        if (!userName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !rePassword.isEmpty() && cbTerms.isChecked) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        var dateRegister = SimpleDateFormat("dd/MM/yyyy").format(Date())
                        var dbRegister = FirebaseFirestore.getInstance()
                        dbRegister.collection("users").document(email).set(
                            hashMapOf(
                                "user" to userName,
                                "dateRegister" to dateRegister,
                                "email" to email,
                                "contraseña" to rePassword
                            )
                        )
                        goMain(email, "email")
                    }

                }
        }
    }

    private fun goMain(email: String, provider: String){

        LoginActivity.userEmail = email
        LoginActivity.providerSession = provider

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun goTerms(view: View){

        val intent = Intent(this, TermsActivity::class.java)
        startActivity(intent)
    }
}