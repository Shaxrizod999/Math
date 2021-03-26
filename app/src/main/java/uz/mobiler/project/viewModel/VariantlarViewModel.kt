package uz.mobiler.project.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.mobiler.project.models.VariantlarModel
import uz.mobiler.project.repository.VarinatlarRepsitory

class VariantlarViewModel: ViewModel() {

    private val repository = VarinatlarRepsitory()
    fun getMutableList(): MutableLiveData<List<VariantlarModel>> {
        return  repository.getMutableLiveData()
    }
}