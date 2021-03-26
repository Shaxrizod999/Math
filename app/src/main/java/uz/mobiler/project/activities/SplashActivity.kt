package uz.mobiler.project.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import uz.mobiler.project.MainActivity
import uz.mobiler.project.R
import uz.mobiler.project.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val timer = object : CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                finish()
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        timer.start()
    }

}