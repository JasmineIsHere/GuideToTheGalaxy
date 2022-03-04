package com.example.thecs461guidetothegalaxy.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thecs461guidetothegalaxy.R
import com.example.thecs461guidetothegalaxy.databinding.FragmentMapBinding

class MapFragment : Fragment() {

  private lateinit var dashboardViewModel: MapViewModel
  private var _binding: FragmentMapBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  override fun onResume() {
    super.onResume()
    val modes = resources.getStringArray(R.array.modes)
    val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, modes)
    binding.modes.setAdapter(arrayAdapter)
  }
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
//    dashboardViewModel =
//            ViewModelProvider(this).get(MapViewModel::class.java)

    _binding = FragmentMapBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textMap
//    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//      textView.text = it
//    })

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}