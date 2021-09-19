package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workouttrainingconstruction.DataBase.DataBase
import com.example.workouttrainingconstruction.DataBase.Training
import com.example.workouttrainingconstruction.databinding.FragmentAddTrainingBinding

class AddTrainingFragment : Fragment() {
    var binding: FragmentAddTrainingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTrainingBinding.inflate(inflater, container, false)
        binding!!.btnCancel.setOnClickListener { activity!!.onBackPressed() }
        binding!!.btnAdd.setOnClickListener {
            val training = Training(binding!!.editText.text.toString())
            DataBase.Companion.getDatabase(activity)!!.trainingDao().insertTraining(training)
            AllTrainingFragment.Companion.list.add(training)
            activity!!.onBackPressed()
        }
        return binding!!.root
    }

    companion object {
        fun newInstance(): AddTrainingFragment {
            val addTrainingFragment = AddTrainingFragment()
            val args = Bundle()
            return addTrainingFragment
        }
    }
}