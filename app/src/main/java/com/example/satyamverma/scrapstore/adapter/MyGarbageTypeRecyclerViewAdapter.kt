package com.example.satyamverma.scrapstore.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.satyamverma.scrapstore.R

import com.example.satyamverma.scrapstore.fragment.SelectGarbageTypeFragment.OnListFragmentInteractionListener
import com.example.satyamverma.scrapstore.data.DummyContent.GarbageType

/**
 * [RecyclerView.Adapter] that can display a [GarbageType] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyGarbageTypeRecyclerViewAdapter(private var mValues:ArrayList<GarbageType>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyGarbageTypeRecyclerViewAdapter.DummyItemViewHolder>() {
    
    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyItemViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_garbagetype, parent, false)
        return DummyItemViewHolder(view)
    }

    public override fun onBindViewHolder(holder: DummyItemViewHolder, position: Int) {
//        holder.setData(DummyItems.garbageTypes[position])
        holder.setData(mValues[position])
//        holder.mItem = mValues.get(position)
//        holder.mIdView.setText(mValues.get(position).id)
//holder.mContentView.setText(mValues.get(position).content)

        holder.mView.setOnClickListener(object : View.OnClickListener {
            public override fun onClick(v: View) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener!!.onListFragmentInteraction(holder.mItem!!)
                }
            }
        })
    }

    public override fun getItemCount(): Int {
        return mValues.size
//        return GarbageType.garbageTypes.size
    }

    inner class DummyItemViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        // val mContentView:TextView
//        var mItem: GarbageType? = null
        var mItem: GarbageType? = null
        var mOverlay:ImageView? = null
        var img:ImageView

        init {
            mIdView = mView.findViewById<TextView>(R.id.gbg_type_name)
            mOverlay = mView.findViewById<ImageView>(R.id.gbg_type_overlay)
            img = mView.findViewById<ImageView>(R.id.gbg_icon)
//mContentView = mView.findViewById<TextView>(R.id.content)
        }

        public override fun toString(): String {
            return super.toString() + " '" + mIdView.getText() + "'"
        }

        fun setData(garbageType: GarbageType) {
            mItem = garbageType
            mIdView.text = garbageType.id
            img.setImageResource(garbageType.img_resource!!)
            img.setOnClickListener{
                mOverlay!!.visibility = if (mOverlay!!.visibility == View.VISIBLE) {
                    View.GONE
                } else View.VISIBLE
            }

            mView.setOnClickListener {
                mOverlay!!.visibility = if (mOverlay!!.visibility == View.VISIBLE) {
                    View.GONE
                } else View.VISIBLE
            }
            
        }
    }
}
