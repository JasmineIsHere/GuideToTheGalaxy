package com.example.thecs461guidetothegalaxy.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thecs461guidetothegalaxy.databinding.FragmentNotificationsBinding
import com.example.thecs461guidetothegalaxy.ui.home.CustomAdapter

class NotificationsFragment : Fragment() {

  private lateinit var notificationsViewModel: NotificationsViewModel
  private var _binding: FragmentNotificationsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  private lateinit var myAdapter: CustomAdapter
  private var queuedRidesList = ArrayList<String>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
//    notificationsViewModel =
//            ViewModelProvider(this).get(NotificationsViewModel::class.java)

    _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    val root: View = binding.root
//
//    val textView: TextView = binding.textNotifications
//    notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//      textView.text = it
//    })

    setUpList()
    //hide "no rides queued yet" textview if listview is populated
    if (queuedRidesList.size == 0){
      binding.noRides.visibility = View.VISIBLE
    } else {
      binding.noRides.visibility = View.GONE
    }

    return root
  }

  private fun setUpList(){
    //TODO("list of queued rides not added yet; need to save rides to somewhere")
    //queuedRidesList.add()

    //defining the Custom Adapter to bring the layout of the list and the list of rides
    myAdapter = CustomAdapter(this, queuedRidesList)
    binding.queuedRides.adapter = myAdapter
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}