package uz.mobiler.project.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*
import uz.mobiler.project.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false)


        binding.qoshish.setOnClickListener {

            var amal = binding.hozirgiAmal.text.toString()
            var amal1 = binding.hozirgiAmal.text.toString()

            val len = amal.length

            if(amal.substring(len - 1) != "+" && len < 15)
            {
                amal += "+"
            }
            binding.oldingiAmal.text = amal



        }

        binding.hammasiniOchirish.setOnClickListener {

            binding.ac.text = "AC"
            binding.oldingiAmal.text = ""
            binding.hozirgiAmal.text = "0"

        }

        binding.ochirish.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal != "" && amal != "0") {
                amal = amal.substring(0, amal.length - 1)
                binding.hozirgiAmal.text = amal
                binding.oldingiAmal.text = amal
            }
            if (hozirgi_amal.length() == 0) {
                binding.hozirgiAmal.text = "0"
            }
        }



        binding.noll.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal.equals("0")) amal = ""
            if (amal.length <= 15) {
                amal += "0"
            }
            binding.hozirgiAmal.text = amal;

        }


        binding.nuqta.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal.length <= 15 && !amal.contains(",")) {
                amal += ","
            }
            binding.hozirgiAmal.text = amal;


        }


        binding.bir.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "1"
            }
            binding.hozirgiAmal.text = amal;


        }
        binding.ikki.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "2"
            }
            binding.hozirgiAmal.text = amal
        }
        binding.uch.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "3"
            }
            binding.hozirgiAmal.text = amal


        }
        binding.tort.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "4"
            }
            binding.hozirgiAmal.text = amal
        }
        binding.besh.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "5"
            }
            binding.hozirgiAmal.text = amal


        }
        binding.olti.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "6"
            }
            binding.hozirgiAmal.text = amal


        }
        binding.yetti.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "7"
            }
            binding.hozirgiAmal.text = amal


        }
        binding.sakkiz.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "8"
            }
            binding.hozirgiAmal.text = amal


        }

        binding.toqqiz.setOnClickListener {

            var amal = hozirgi_amal.text.toString()
            if (amal == "0") amal = ""
            if (amal.length <= 15) {
                amal += "9"
            }
            binding.hozirgiAmal.text = amal


        }

        return binding.root
    }
}



