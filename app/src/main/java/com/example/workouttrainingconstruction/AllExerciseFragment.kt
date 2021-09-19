package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouttrainingconstruction.DataBase.DataBase
import com.example.workouttrainingconstruction.DataBase.Exercise
import com.example.workouttrainingconstruction.databinding.FragmentAllExerciseBinding
import java.util.*

class AllExerciseFragment : Fragment() {
    var binding: FragmentAllExerciseBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllExerciseBinding.inflate(inflater, container, false)
        list = DataBase.Companion.getDatabase(activity)!!.exerciseDao().allExercise
        binding!!.recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ExerciseRecyclerAdapter(activity, list)
        binding!!.recyclerView.adapter = adapter
        binding!!.floatingActionButton.setOnClickListener {
            val youFragment: AddExerciseFragment = AddExerciseFragment.Companion.newInstance()
            activity!!.supportFragmentManager.popBackStack()
            val fragmentManager = activity!!.supportFragmentManager
            fragmentManager.beginTransaction()
                .add(R.id.trContainer, youFragment, "createTrainingFrag")
                .addToBackStack("createTrainingFrag")
                .commit()
        }
        return binding!!.root
    }

    companion object {
        var adapter: ExerciseRecyclerAdapter? = null
        var list: MutableList<Exercise> = ArrayList()
    }
}