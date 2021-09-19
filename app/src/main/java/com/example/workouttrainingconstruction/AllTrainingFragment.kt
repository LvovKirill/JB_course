package com.example.workouttrainingconstruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouttrainingconstruction.DataBase.DataBase
import com.example.workouttrainingconstruction.DataBase.Training
import com.example.workouttrainingconstruction.databinding.FragmentAllTrainingBinding
import java.util.*

class AllTrainingFragment : Fragment() {
    var binding: FragmentAllTrainingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllTrainingBinding.inflate(inflater, container, false)
        list = DataBase.Companion.getDatabase(activity)!!.trainingDao().allTraining
        binding!!.recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = TrainingRecyclerAdapter(activity, list)
        binding!!.recyclerView.adapter = adapter
        binding!!.floatingActionButton.setOnClickListener {
            val youFragment: AddTrainingFragment = AddTrainingFragment.Companion.newInstance()
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
        var adapter: TrainingRecyclerAdapter? = null
        var list: MutableList<Training> = ArrayList()
    }
}