package com.example.satyamverma.scrapstore.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.satyamverma.scrapstore.R

//import com.example.satyamverma.scrapstore.fragment.QuantitiesFragment.OnListFragmentInteractionListener
import com.example.satyamverma.scrapstore.fragment.SelectGarbageTypeFragment
import com.example.satyamverma.scrapstore.fragment.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyQuantitiesRecyclerViewAdapter(private val mValues: List<DummyItem>, private val mListener: SelectGarbageTypeFragment.OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyQuantitiesRecyclerViewAdapter.QuantityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuantityViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_quantities, parent, false)
        return QuantityViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuantityViewHolder, position: Int) {
//        holder.mItem = mValues[position]
//        holder.mIdView.text = mValues[position].id
//        holder.mContentView.text = mValues[position].content
        holder.setData(mValues[position])

//        holder.mView.setOnClickListener {
//            mListener?.onListFragmentInteraction(holder.mItem!!)
//        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class QuantityViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mQauntNumView: TextView
        var mItem: DummyItem? = null
        var mPlusBtn: Button? = null
        var mMinusBtn: Button? = null

        init {
            mIdView = mView.findViewById<TextView>(R.id.fragment_quant_item_name) as TextView
            mQauntNumView = mView.findViewById<TextView>(R.id.fragment_quant_num) as TextView
            mMinusBtn = mView.findViewById<Button>(R.id.fragment_quant_minus_btn) as Button
            mPlusBtn = mView.findViewById<Button>(R.id.fragment_quant_plus_btn) as Button


        }

        fun setData(item:DummyItem){
            mItem = item
            mIdView.text = item.id
            mQauntNumView.text = item.details
            mMinusBtn!!.setOnClickListener {
                var i = Integer.parseInt(mQauntNumView.text.toString())
                i--
                mQauntNumView.text = i.toString()
            }

            mPlusBtn!!.setOnClickListener {
                var i = Integer.parseInt(mQauntNumView.text.toString())
                i++
                mQauntNumView.text = i.toString()
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + mQauntNumView.text + "'"
        }
    }
}
