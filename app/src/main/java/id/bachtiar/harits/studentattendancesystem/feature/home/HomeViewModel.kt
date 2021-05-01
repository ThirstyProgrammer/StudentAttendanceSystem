package id.bachtiar.harits.studentattendancesystem.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel() {

    val TAG = "HOME_VIEW_MODEL"
    private var db = Firebase.firestore

    fun submitData() {
        val jadwal = hashMapOf(
            "title" to "Matematika",
            "day" to "Senin"
        )

        db.collection("Jadwal")
            .add(jadwal)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun getData() {
        db.collection("Jadwal")
            .get()
            .addOnSuccessListener { result ->
                result.forEach { document ->

                    Log.d(TAG, "${document.id} => ${document.data} => ${document.reference}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}