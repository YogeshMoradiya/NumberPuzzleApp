package com.example.numberpuzzle

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.numberpuzzle.R.id.btnhome


class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btnr:Button
    lateinit var btn_ok:Button
    lateinit var btnhome:Button

    var btn = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnr = findViewById(R.id.btnr)
        btnhome=findViewById(R.id.btnhome)

        btn.add(btn1)
        btn.add(btn2)
        btn.add(btn3)
        btn.add(btn4)
        btn.add(btn5)
        btn.add(btn6)
        btn.add(btn7)
        btn.add(btn8)
        btn.add(btn9)
        btn.add(btnr)
        btn.add(btnhome)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)
        click(9)
        click(10)
    }

    fun click(i: Int) {
        btn[i].setOnClickListener {
            if (i == 0) {
                change(0, 1)
                change(0, 3)
                change(0, 1, 2)
                change(0, 3, 6)
            }
            if (i == 1) {
                change(1, 2)
                change(1, 0)
                change(1, 4)
                change(1, 4, 7)
            }
            if (i == 2) {
                change(2, 1)
                change(2, 5)
                change(2, 1, 0)
                change(2, 5, 8)
            }
            if (i == 3) {
                change(3, 0)
                change(3, 4)
                change(3, 6)
                change(3, 4, 5)
            }
            if (i == 4) {
                change(4, 1)
                change(4, 3)
                change(4, 5)
                change(4, 7)
            }
            if (i == 5) {
                change(5, 2)
                change(5, 4)
                change(5, 8)
                change(5, 4, 3)
            }
            if (i == 6) {
                change(6, 3)
                change(6, 7)
                change(6, 3, 0)
                change(6, 7, 8)
            }
            if (i == 7) {
                change(7, 6)
                change(7, 4)
                change(7, 8)
                change(7, 4, 1)
            }
            if (i == 8) {
                change(8, 5)
                change(8, 7)
                change(8, 7, 6)
                change(8, 5, 2)
            }
            if (i == 9) {
                val ab = ArrayList<String>()
                repeat(9) {
                    while (true) {
                        val a = (Math.random() * 9).toInt()
                        if (!ab.contains("$a")) {
                            ab.add("$a")
                            break
                        }
                    }
                }
                ab[ab.indexOf("0")] = ""
                ab.forEachIndexed { index, _ ->
                    btn[index].text = ab[index]
                }
            }
                if (btn[0].text.toString().equals("1") && btn[1].text.toString()
                        .equals("2") && btn[2].text.toString().equals("3") && btn[3].text.toString()
                        .equals("4") && btn[4].text.toString().equals("5") && btn[5].text.toString()
                        .equals("6") && btn[6].text.toString().equals("7") && btn[7].text.toString()
                        .equals("8")) {
                    Toast.makeText(this@MainActivity, "You Win", Toast.LENGTH_LONG).show()
                    showWinDialog()
                }
                  else {
                  }
        }
        btnhome.setOnClickListener {
            // Redirect to the Start/Home page
            val intent = Intent(this, startpage::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
    private fun showWinDialog() {
        val dialogView = layoutInflater.inflate(R.layout.win_dialog, null)
        val dialog = AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create()
        dialog.show()
        val btnOk = dialogView.findViewById<Button>(R.id.btn_ok)
        val win_home = dialogView.findViewById<Button>(R.id.win_home)
        btnOk.setOnClickListener {
            dialog.dismiss()
            val ab = ArrayList<String>()
            repeat(9) {
                while (true) {
                    val a = (Math.random() * 9).toInt()
                    if (!ab.contains("$a")) {
                        ab.add("$a")
                        break
                    }
                }
            }
            ab[ab.indexOf("0")] = ""
            ab.forEachIndexed { index, _ ->
                btn[index].text = ab[index]
            }
        }

        win_home.setOnClickListener {
            var intent = Intent(this@MainActivity, startpage::class.java)
            finish()
        }
    }
    private fun change(first: Int, second: Int) {
        if (btn[second].text.toString().isEmpty()) {
            btn[second].setText(btn[first].text.toString())
            btn[first].setText("")
        }
    }
    private fun change(first: Int, second: Int, third: Int) {
        if (btn[third].text.toString().isEmpty()) {
            btn[third].setText(btn[second].text.toString())
            btn[second].setText(btn[first].text.toString())
            btn[first].setText("")
        }
    }
}