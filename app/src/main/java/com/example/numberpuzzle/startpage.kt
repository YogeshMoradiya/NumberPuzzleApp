package com.example.numberpuzzle;

import android.app.Activity;
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class startpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startpage)

        val play: Button = findViewById(R.id.play)
        play.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val share: Button = findViewById(R.id.share)
        share.setOnClickListener {
            shareApp()
        }


        }

    private fun shareApp() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Number Puzzle App")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this,R.style.ExitDialog)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                super.onBackPressed()
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
            .show()
            .apply {
                getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this@startpage, R.color.black))
                getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this@startpage, R.color.black))
            }
    }
}