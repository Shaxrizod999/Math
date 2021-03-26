package uz.mobiler.project.activities

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import uz.mobiler.project.R
import uz.mobiler.project.databinding.ActivityDtmtwstlariBinding
import uz.mobiler.project.fragments.TimerPickerFragment
import uz.mobiler.project.receiver.AlarmReceiver
import uz.mobiler.project.variantlar.OnbeshFragment
import java.text.DateFormat
import java.util.*

class DtmtestlariActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDtmtwstlariBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDtmtwstlariBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dtmdanqaytish.setOnClickListener {
            finish()
        }

        binding.onbesh.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,OnbeshFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}