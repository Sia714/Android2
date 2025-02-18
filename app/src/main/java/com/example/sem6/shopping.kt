package com.example.sem6

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class shopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)
        val rat1=findViewById<RatingBar>(R.id.ratingBar1)
        val rat2=findViewById<RatingBar>(R.id.ratingBar2)
        val rat3=findViewById<RatingBar>(R.id.ratingBar3)
        val rat4=findViewById<RatingBar>(R.id.ratingBar4)
        var t1=findViewById<TextView>(R.id.textView5)
        var t2=findViewById<TextView>(R.id.textView6)
        var t3=findViewById<TextView>(R.id.textView7)
        var t4=findViewById<TextView>(R.id.textView8)

        rat1.setOnRatingBarChangeListener{_,rating,_->
            t1.text="Your rating is $rating"
        }
        rat2.setOnRatingBarChangeListener{_,rating,_->
            t2.text="Your rating is $rating"
        }
        rat3.setOnRatingBarChangeListener{_,rating,_->
            t3.text="Your rating is $rating"
        }
        rat4.setOnRatingBarChangeListener{_,rating,_->
            t4.text="Your rating is $rating"
        }





    }
}