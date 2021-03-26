package uz.mobiler.project.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import uz.mobiler.project.models.VariantlarModel

class VarinatlarRepsitory {
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var firebaseReference : DatabaseReference
    private var mutableList = MutableLiveData<List<VariantlarModel>>()
    private lateinit var variantlar: List<VariantlarModel>
    fun getMutableLiveData(): MutableLiveData<List<VariantlarModel>>{
        firebaseReference = firebaseDatabase.getReference("math/applicants/DTM test/2015 tests/1-variant")
        firebaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                variantlar = ArrayList<VariantlarModel>()
                snapshot.children.forEach{
                    var value = it.getValue(VariantlarModel::class.java)
                    if (value != null)
                    {
                        (variantlar as ArrayList<VariantlarModel>).add(value)
                    }
                }
                mutableList.value = variantlar
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return mutableList
    }
}