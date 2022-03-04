package com.example.thecs461guidetothegalaxy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import com.example.thecs461guidetothegalaxy.R
import com.example.thecs461guidetothegalaxy.databinding.FragmentHomeBinding
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
  private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  private lateinit var myAdapter: CustomAdapter
  private var ridesList = ArrayList<String>()


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
//    homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textHome
//    homeViewModel.text.observe(viewLifecycleOwner, Observer {
//      textView.text = it
//    })

    val scanner = Scanner(resources.openRawResource(R.raw.rides))
    readFile(scanner)
    setUpList()

    return root
  }

  override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
  }

  private fun readFile(scanner: Scanner){

    while(scanner.hasNextLine()) {
      val line = scanner.nextLine()
      val pieces = line.split("\t")
      ridesList.add(pieces[0])
    }
  }

  private fun setUpList(){
    //defining the Custom Adapter to bring the layout of the list and the list of rides
    myAdapter = CustomAdapter(this, ridesList)
    binding.ridesList.adapter = myAdapter
  }


}



