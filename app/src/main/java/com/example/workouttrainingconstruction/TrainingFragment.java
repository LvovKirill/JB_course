package com.example.workouttrainingconstruction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workouttrainingconstruction.databinding.FragmentExerciseBinding;
import com.example.workouttrainingconstruction.databinding.FragmentTrainingBinding;

import java.util.ArrayList;


public class TrainingFragment extends Fragment {

    FragmentTrainingBinding binding;
    TrainingRecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTrainingBinding.inflate(inflater, container, false);

        ArrayList<Training> list = new ArrayList<>();
        list.add(new Training("Training 1"));
        list.add(new Training("Training 2"));
        list.add(new Training("Training 3"));
        list.add(new Training("Training 4"));
        list.add(new Training("Training 5"));
        list.add(new Training("Training 6"));
        list.add(new Training("Training 7"));
        list.add(new Training("Training 8"));
        list.add(new Training("Training 9"));
        list.add(new Training("Training 10"));
        list.add(new Training("Training 11"));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TrainingRecyclerAdapter(getActivity(), list);
        binding.recyclerView.setAdapter(adapter);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CreateExerciseFragment youFragment = new CreateExerciseFragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction().add(R.id.frameLayout, youFragment, "createExerciseFrag")
//                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
//                        .addToBackStack("createExerciseFrag")
//                        .commit();
            }
        });


        return binding.getRoot();
    }
}