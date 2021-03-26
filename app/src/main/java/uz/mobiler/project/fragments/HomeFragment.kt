package uz.mobiler.project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import uz.mobiler.project.R
import uz.mobiler.project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

   private lateinit var binding: FragmentHomeBinding
   private lateinit var animationUtils: AnimationUtils

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.cardAbituriyuent.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardDastur.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardDastur.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardMaktab.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardOlimpiada.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardOqiuvchi.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.cardSozlamalar.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.qoshimcha.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)
        binding.yangiliklar.animation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation_itam)

        binding.cardAbituriyuent.setOnClickListener {
            findNavController().navigate(R.id.abituriyentFragment)
            onStart()
        }
        binding.cardOqiuvchi.setOnClickListener {
            findNavController().navigate(R.id.oqituvchiFragment)
            onStart()
        }
        binding.cardOlimpiada.setOnClickListener {
            findNavController().navigate(R.id.studentFragment)
            onStart()
        }
        binding.cardMaktab.setOnClickListener {
            findNavController().navigate(R.id.maktabFragment)
            onStart()
        }
        binding.cardSozlamalar.setOnClickListener {
            findNavController().navigate(R.id.nav_slideshow)
            onStart()
        }

        return binding.root
    }
}