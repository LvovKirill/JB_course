package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workouttrainingconstruction.DataBase.DataBase
import com.example.workouttrainingconstruction.DataBase.Exercise
import com.example.workouttrainingconstruction.databinding.FragmentAddExerciseBinding

class AddExerciseFragment : Fragment() {
    var binding: FragmentAddExerciseBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        binding!!.btnCancel.setOnClickListener { activity!!.onBackPressed() }
        binding!!.btnAdd.setOnClickListener {
            val exercise = Exercise(binding!!.editText.text.toString())
            DataBase.Companion.getDatabase(activity)!!.exerciseDao().insertExercise(exercise)
            AllExerciseFragment.Companion.list.add(exercise)
            activity!!.onBackPressed()
        }
        return binding!!.root
    }

    companion object {
        fun newInstance(): AddExerciseFragment {
            val addExerciseFragment = AddExerciseFragment()
            val args = Bundle()
            return addExerciseFragment
        }
    }
}