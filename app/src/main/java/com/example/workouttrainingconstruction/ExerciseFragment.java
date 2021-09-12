package com.example.workouttrainingconstruction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.workouttrainingconstruction.databinding.FragmentExerciseBinding;

import java.util.ArrayList;
import java.util.List;


public class ExerciseFragment extends Fragment {

    FragmentExerciseBinding binding;

    ExerciseRecyclerAdapter adapter;
//    public static ExerciseViewModel exerciseViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExerciseBinding.inflate(inflater, container, false);

        ArrayList<Exercise> list = new ArrayList<>();
        list.add(new Exercise("Exercise 1"));
        list.add(new Exercise("Exercise 2"));
        list.add(new Exercise("Exercise 3"));
        list.add(new Exercise("Exercise 4"));
        list.add(new Exercise("Exercise 5"));
        list.add(new Exercise("Exercise 6"));
        list.add(new Exercise("Exercise 7"));
        list.add(new Exercise("Exercise 8"));
        list.add(new Exercise("Exercise 9"));
        list.add(new Exercise("Exercise 10"));
        list.add(new Exercise("Exercise 11"));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ExerciseRecyclerAdapter(getActivity(), list);
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