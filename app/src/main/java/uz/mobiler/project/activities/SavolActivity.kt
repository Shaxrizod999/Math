package uz.mobiler.project.activities

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_savol.*
import kotlinx.android.synthetic.main.natijalar.*
import kotlinx.android.synthetic.main.natijalar.view.*
import uz.mobiler.project.R
import uz.mobiler.project.adapters.VariantlarRecyclerAdapter
import uz.mobiler.project.databinding.ActivitySavolBinding
import uz.mobiler.project.fragments.CalculatorFragment
import uz.mobiler.project.fragments.TimerPickerFragment
import uz.mobiler.project.models.VariantlarModel
import uz.mobiler.project.receiver.AlarmReceiver
import uz.mobiler.project.variantlar.OnbeshFragment
import uz.mobiler.project.viewModel.VariantlarViewModel
import java.text.DateFormat
import java.util.*
import java.util.Collections.list

class SavolActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener  {

    private lateinit var binding: ActivitySavolBinding
    private lateinit var adapter: VariantlarRecyclerAdapter
    private lateinit var viewModel: VariantlarViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySavolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = VariantlarRecyclerAdapter()
        viewModel = ViewModelProvider(this)[VariantlarViewModel::class.java]
        viewModel.getMutableList().observe(this, {
            adapter.differ.submitList(it)
        })
        binding.rv.adapter = adapter

        binding.test.setOnClickListener {
            binding.rv.visibility = View.VISIBLE
            binding.test.visibility = View.GONE
            binding.tugat.visibility = View.VISIBLE
            binding.kalkulyator.visibility = View.VISIBLE
            binding.vaqt.visibility = View.VISIBLE
            binding.countTime.visibility = View.VISIBLE

        }
        binding.tugat.setOnClickListener {

            binding.rv.visibility = View.GONE
            binding.kalkulyator.visibility = View.GONE
            binding.vaqt.visibility = View.GONE
            binding.countTime.visibility = View.GONE
            showBottomSheetDialog()
        }
        binding.dtmdanqaytish.setOnClickListener {
            finish()
        }
        binding.vaqt.setOnClickListener {
            val timePicker = TimerPickerFragment()
            timePicker.show(supportFragmentManager, "time picker")
        }
    }
    @SuppressLint("SetTextI18n")
    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)
        val dialogView =layoutInflater.inflate(R.layout.natijalar, null, false)
        dialogView.jamisavollarsoni.text = "Variantdagi savollar soni : 6 ta "
        dialogView.togrijavolarsoni.text = "To'g'ri javoblar soni : " +  adapter.countrueAnswers.toString() + " ta"
        dialog.setContentView(dialogView)
        dialog.show()
    }
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, hourOfDay)
        c.set(Calendar.MINUTE, minute)
        c.set(Calendar.SECOND, 0)
        updateTimeText(c)
        setAlarm(c)
    }
    private fun setAlarm(c: Calendar) {

        val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        if(c.before(Calendar.getInstance()))
        {
            c.add(Calendar.DATE, 1)
        }
        manager.setExact(AlarmManager.RTC_WAKEUP, c.timeInMillis, pendingIntent)
    }
    private fun updateTimeText(c: Calendar) {
        val time = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.time)
        count_time.text = ("Vaqt o'rnatildi: $time")
    }
}