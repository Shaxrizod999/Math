package uz.mobiler.project.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import uz.mobiler.project.R
import uz.mobiler.project.activities.DtmtestlariActivity
import uz.mobiler.project.databinding.FragmentAbituriyentBinding

class AbituriyentFragment : Fragment() {

    private lateinit var binding: FragmentAbituriyentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentAbituriyentBinding.inflate(layoutInflater, container, false)
        binding.dtmtestlari.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.card_animation1)
        binding.abituriyent.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.card_animation1)
        binding.qollanma.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.card_animation1)
        binding.masalalartoplami.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.card_animation1)
        binding.dtmtestlari.setOnClickListener {
            val intent = Intent(requireContext(), DtmtestlariActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}