package com.example.gratepurchaser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_in_activity.*
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_activity)
        supportActionBar?.hide()

     // initialize firebase
        FirebaseApp.initializeApp(this)

        //get firestore instance
        val db = Firebase.firestore

        go_to_register.setOnClickListener {
             startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        }

        go_to_home.setOnClickListener {
            val loginPhone = etPhone.text.toString()
            val loginPass = etPassword.text.toString()

            sign_in_progress.visibility = View.VISIBLE

            db.collection("users").whereEqualTo("phone",loginPhone).whereEqualTo("password",loginPass)
                .get().addOnSuccessListener{
                    if (!it.isEmpty){
                        sign_in_progress.visibility = View.GONE
                        startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                    }
                    else {
                        toast("ldkjlkj")
                        sign_in_progress.visibility = View.VISIBLE
                    }
                }
        }
    }
}

