package com.example.homework4kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private lateinit var btnWhatsapp: MaterialButton
    private lateinit var etInput: EditText
    private lateinit var ivImage: ImageView
    private val content = registerForActivityResult(ActivityResultContracts.GetContent()) {
        ivImage.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWhatsapp = this.findViewById(R.id.btn_whats_app)
        etInput = this.findViewById(R.id.et_number_phone)
        ivImage = this.findViewById(R.id.btn_image)
        goToWhatsapp()
        choseImage()

    }

    private fun goToWhatsapp() {
        btnWhatsapp.setOnClickListener {
            val whatsappLink = "https://wa.me/"
            val lead = etInput.text.toString().trim()
            val whatsappIntent = Intent(Intent.ACTION_VIEW, Uri.parse("$whatsappLink$lead"))
            startActivity(whatsappIntent)
        }
    }

    private fun choseImage() {
        ivImage.setOnClickListener {
            content.launch("image/*")
        }
    }


}