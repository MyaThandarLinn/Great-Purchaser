package com.example.gratepurchaser

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_in_activity.*
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_activity)
        supportActionBar?.hide()

        // initialize firebase
        FirebaseApp.initializeApp(this)

        //get Firebase Firestore instance
        val db = Firebase.firestore

        go_to_register.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        }

        val loginPhone = etPhone.text.toString()
        val loginPass = etPassword.text.toString()

        go_to_home.isEnabled = true

        go_to_home.setOnClickListener {
            sign_in_progress.visibility = View.VISIBLE

            if(isCheck()){
                sign_in_progress.visibility = View.GONE
                go_to_home.isEnabled = false
                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))

//                    db.collection("users").whereEqualTo("phone",loginPhone).whereEqualTo("password",loginPass)
//                        .get().addOnSuccessListener{
//                            if (!it.isEmpty){
//                                sign_in_progress.visibility = View.GONE
//                                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
//                            }
//                            else {
//                                toast("ldkjlkj")
//                                go_to_home.isEnabled = true
//                            }
//                        }
            }
            else{
                toast("No Connection !")
                sign_in_progress.visibility = View.GONE
            }
        }
    }

    private fun isCheck(): Boolean{
        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null){
            info = connectivity!!.activeNetworkInfo
            if (info != null){
                if (info!!.state == NetworkInfo.State.CONNECTED){
                    return true
                }
            }
        }
        return false
    }
}

