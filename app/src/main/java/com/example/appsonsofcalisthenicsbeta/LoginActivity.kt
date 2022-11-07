package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class LoginActivity : AppCompatActivity() {

    companion object{
        lateinit var userEmail: String
        lateinit var providerSession: String
    }

    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var bPassword: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        bPassword = findViewById(R.id.bPassword)

        mAuth = FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()

        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) goMain(currentUser.email.toString(), currentUser.providerId)
    }


    override fun onBackPressed() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }

    fun login(View: View){
        loginUser()
    }
    private fun loginUser(){
        email = etEmail.text.toString()
        password = etPassword.text.toString()

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) goMain(email, "email")
                else Toast.makeText(this, "El usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show()
            }
    }

    private fun goMain(email: String, provider: String){

        userEmail = email
        providerSession = provider

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }




    fun forgotPassword(view: View){
        startActivity(Intent(this, RecoverPassActivity::class.java))
    }

    fun goRegister(view: View){
        startActivity(Intent(this, RegisterActivity::class.java))
    }






}