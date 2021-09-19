package com.example.workouttrainingconstruction

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.workouttrainingconstruction.DataBase.Exercise

class ExerciseRecyclerAdapter internal constructor(context: Context?, data: List<Exercise>) :
    RecyclerView.Adapter<ExerciseRecyclerAdapter.ViewHolder>() {
    private val mData: List<Exercise>
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.exercise_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = mData[position]
        holder.myTextView.text = exercise.name
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var myTextView: TextView
        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }

        init {
            myTextView = itemView.findViewById(R.id.exerciseName)
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener {
                val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                val myFragment: DeleteFragment = DeleteFragment.Companion.newInstance(
                    mData[position].name,
                    "deleteExercise", position, mData[position].id
                )
                Log.d("myTag", Integer.toString(position))
                fragmentManager.beginTransaction().add(R.id.trContainer, myFragment, "deleteFrag")
                    .addToBackStack("deleteFrag")
                    .commit()
                true
            }
        }
    }

    fun getItem(id: Int): Exercise {
        return mData[id]
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }
}