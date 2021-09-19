package com.example.workouttrainingconstruction

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.workouttrainingconstruction.DataBase.Training

class TrainingRecyclerAdapter internal constructor(context: Context?, data: List<Training>) :
    RecyclerView.Adapter<TrainingRecyclerAdapter.ViewHolder>() {
    private val mData: List<Training>
    private val mInflater: LayoutInflater
    private val mClickListener: ItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.training_item, parent, false)
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
            mClickListener?.onItemClick(view, adapterPosition)
        }

        init {
            myTextView = itemView.findViewById(R.id.trainingName)
            itemView.setOnClickListener {
                val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                val myFragment: TrainingFragment =
                    TrainingFragment.Companion.newInstance(mData[position].name)
                fragmentManager.beginTransaction().add(R.id.trContainer, myFragment, "trainingFrag")
                    .addToBackStack("trainingFrag")
                    .commit()
            }
            itemView.setOnLongClickListener {
                val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                val myFragment: DeleteFragment = DeleteFragment.Companion.newInstance(
                    mData[position].name,
                    "deleteTraining", position, mData[position].id
                )
                fragmentManager.beginTransaction().add(R.id.trContainer, myFragment, "deleteFrag")
                    .addToBackStack("deleteFrag")
                    .commit()
                true
            }
        }
    }

    fun getItem(id: Int): Training {
        return mData[id]
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }
}