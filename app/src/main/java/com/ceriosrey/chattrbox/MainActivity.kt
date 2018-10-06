package com.ceriosrey.chattrbox

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var handler: Handler? = null
    var animationHandler: Handler? = null
    var imageLogo: ImageView? = null
    var textViewName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageLogo = findViewById(R.id.imageView_logo_main)
        textViewName = findViewById(R.id.textView_name)
        handler = Handler()
        animationHandler = Handler()
        animationHandler?.postDelayed({ animateViews() }, 1000)
        handler?.postDelayed(
                { goToNextActivity() },
                5000
        )
    }

    fun goToNextActivity() {
        val intent: Intent = Intent(this, EssentialsActivity::class.java)
        startActivity(intent)
    }

    fun animateViews() {
        val objectAnimatorImageLogo = ObjectAnimator.ofFloat(imageLogo, "translationY", 0f, -800f)
        val objectAnimatorName = ObjectAnimator.ofFloat(textViewName, "translationY", 0f, 700f)
        val imageFadeOut = ObjectAnimator.ofFloat(imageLogo, "alpha", 1f, 0f)
        val textViewFadeOut = ObjectAnimator.ofFloat(textViewName, "alpha", 1f, 0f)
        imageFadeOut.duration = 3500
        textViewFadeOut.duration = 3500
        objectAnimatorImageLogo.duration = 3500
        objectAnimatorName.duration = 3500
        imageFadeOut.start()
        textViewFadeOut.start()
        objectAnimatorName.start()
        objectAnimatorImageLogo.start()
    }
}
