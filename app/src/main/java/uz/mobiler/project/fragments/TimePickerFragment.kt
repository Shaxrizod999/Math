package uz.mobiler.project.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TimerPickerFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val instance = Calendar.getInstance()
        val hour = instance.get(Calendar.HOUR_OF_DAY)
        val minute = instance.get(Calendar.MINUTE)

        return TimePickerDialog(activity,
                activity as TimePickerDialog.OnTimeSetListener, hour, minute, true)
    }
}