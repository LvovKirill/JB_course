package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workouttrainingconstruction.databinding.FragmentTrainingBinding

class TrainingFragment : Fragment() {
    var binding: FragmentTrainingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingBinding.inflate(inflater, container, false)
        try {
            binding!!.nameTraining.text = arguments!!.getString("nameTraining")
        } catch (e: Exception) {
        }
        return binding!!.root
    }

    companion object {
        fun newInstance(nameTraining: String?): TrainingFragment {
            val trainingFragment = TrainingFragment()
            val args = Bundle()
            args.putString("nameTraining", nameTraining)
            trainingFragment.arguments = args
            return trainingFragment
        }
    }
}