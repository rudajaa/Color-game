package com.example.colorgame

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            // Логіка для кнопки "Правила"
            findViewById<ImageButton>(R.id.rulesButton).setOnClickListener {
                // Здійсніть перехід на сторінку з правилами
                val intent = Intent(this, RulesActivity::class.java)
                startActivity(intent)
            }

            // Логіка для кнопки "Рекорди"
            findViewById<ImageButton>(R.id.scoresButton).setOnClickListener {
                // Здійсніть перехід на сторінку з рекордами
                val intent = Intent(this, ScoresActivity::class.java)
                startActivity(intent)
            }

            // Логіка для кнопки "Звук"
           // findViewById<ImageButton>(R.id.soundButton).setOnClickListener {
                // Ваша логіка для увімкнення/вимкнення звуку
          //  }


        //створення рамки
        // Отримати посилання на текстове поле
        val gameTitleTextView = findViewById<TextView>(R.id.gameTitle)

        // Перевірка, чи встановлено рамку, якщо ні, то встановити
        if (gameTitleTextView.background == null) {
            val shapeDrawable = ShapeDrawable(RectShape())
            val paint = Paint().apply {
                style = Paint.Style.STROKE
                strokeWidth = 10f // Товщина лінії
                color = ContextCompat.getColor(
                    this@MainActivity,
                    R.color.dark_green
                ) // Колір з файлу colors.xml
            }
            shapeDrawable.paint.color = Color.TRANSPARENT
            shapeDrawable.paint.strokeWidth = 10f
            shapeDrawable.paint.style = Paint.Style.STROKE
            shapeDrawable.paint.isAntiAlias = true
            shapeDrawable.paint.color =
                ContextCompat.getColor(this@MainActivity, R.color.dark_green)
            gameTitleTextView.setPadding(20, 20, 20, 20) // Встановлення відступу зверху
            gameTitleTextView.background = shapeDrawable
        }

        // Оновлення розмірів рамки, щоб вона відображалася на всю довжину тексту
        gameTitleTextView.viewTreeObserver.addOnGlobalLayoutListener {
            val shapeDrawable = gameTitleTextView.background as ShapeDrawable
            val rectShape = shapeDrawable.shape as RectShape
            rectShape.resize(gameTitleTextView.width.toFloat(), gameTitleTextView.height.toFloat())
        }

        //кнопка
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.backgroundTintList = resources.getColorStateList(R.color.dark_green)
        startButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        val imageMonaLisa = findViewById<ImageView>(R.id.mona_lisa_image)
        imageMonaLisa.visibility = View.VISIBLE
    }
}
