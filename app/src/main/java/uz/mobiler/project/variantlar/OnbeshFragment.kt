package uz.mobiler.project.variantlar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.motion_09_coordinatorlayout_header.*
import uz.mobiler.project.MainActivity
import uz.mobiler.project.R
import uz.mobiler.project.activities.DtmtestlariActivity
import uz.mobiler.project.activities.SavolActivity
import uz.mobiler.project.adapters.VariantlarRecyclerAdapter
import uz.mobiler.project.databinding.ActivitySavolBinding
import uz.mobiler.project.databinding.FragmentOnbeshBinding
import uz.mobiler.project.viewModel.VariantlarViewModel

class OnbeshFragment : Fragment() {

    private lateinit var binding: FragmentOnbeshBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOnbeshBinding.inflate(inflater, container, false)


        binding.variant1.setOnClickListener {
            val intent = Intent(requireContext(), SavolActivity::class.java)
            startActivity(intent)
        }



        return  binding.root
    }
}