package com.example.thecs461guidetothegalaxy.ui.home


import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.thecs461guidetothegalaxy.R

class CustomAdapter(private val context: Fragment, var rideList: ArrayList<String>): BaseAdapter() {

    override fun getCount(): Int {
        return rideList.count()
    }

    override fun getItem(p0: Int): Any {
        return rideList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //populate the views
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = context.layoutInflater

        //the list_ride object
        var rideItemView = inflater.inflate(R.layout.list_ride, null)

        //get the individual components of list_ride (variables: @+id/ride_name, @+id/waiting_time, @+id/join_queue?)
        var rideName = rideItemView.findViewById<TextView>(R.id.ride_name)
        // TODO("var waitingTime = rideItemView.findViewById<TextView>(R.id.waiting_time)")

        //set value of the views
        rideName.setText(rideList[p0])

        return rideItemView
    }

}