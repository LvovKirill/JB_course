package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workouttrainingconstruction.DataBase.DataBase
import com.example.workouttrainingconstruction.databinding.FragmentDeleteBinding

class DeleteFragment : Fragment() {
    var binding: FragmentDeleteBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeleteBinding.inflate(inflater, container, false)
        if (arguments!!.getString("deleteType") == "deleteTraining") {
            binding!!.textMessage.text =
                "Do you really want to delete the training \"" + arguments!!.getString("name") + "\"?"
        } else if (arguments!!.getString("deleteType") == "deleteExercise") {
            binding!!.textMessage.text =
                "Do you really want to delete the exercise \"" + arguments!!.getString("name") + "\"?"
        }
        binding!!.btnNo.setOnClickListener { activity!!.onBackPressed() }
        binding!!.btnYes.setOnClickListener {
            if (arguments!!.getString("deleteType") == "deleteTraining") {
                DataBase.Companion.getDatabase(activity)!!
                    .trainingDao().deleteById(arguments!!.getInt("ID"))
                try {
                    AllTrainingFragment.Companion.list.removeAt(arguments!!.getInt("position"))
                } catch (e: Exception) {
                }
                AllTrainingFragment.Companion.adapter!!.notifyItemRemoved(arguments!!.getInt("position"))
                AllTrainingFragment.Companion.adapter!!.notifyItemRangeChanged(
                    arguments!!.getInt("position"),
                    AllTrainingFragment.Companion.list.size
                )
                activity!!.onBackPressed()
            } else if (arguments!!.getString("deleteType") == "deleteExercise") {
                DataBase.Companion.getDatabase(activity)!!
                    .exerciseDao().deleteByID(arguments!!.getInt("ID"))
                AllExerciseFragment.Companion.list.removeAt(arguments!!.getInt("position"))
                AllExerciseFragment.Companion.adapter!!.notifyItemRemoved(arguments!!.getInt("position"))
                AllExerciseFragment.Companion.adapter!!.notifyItemRangeChanged(
                    arguments!!.getInt("position"),
                    AllExerciseFragment.Companion.list.size
                )
                activity!!.onBackPressed()
            }
        }
        return binding!!.root
    }

    companion object {
        fun newInstance(
            name: String?,
            deleteType: String?,
            position: Int,
            id: Int?
        ): DeleteFragment {
            val deleteFragment = DeleteFragment()
            val args = Bundle()
            args.putString("name", name)
            args.putString("deleteType", deleteType)
            args.putInt("position", position)
            if (id != null) {
                args.putInt("ID", id)
            }
            deleteFragment.arguments = args
            return deleteFragment
        }
    }
}