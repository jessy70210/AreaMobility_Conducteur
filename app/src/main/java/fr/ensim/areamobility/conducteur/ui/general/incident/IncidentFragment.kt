package fr.ensim.areamobility.conducteur.ui.general.incident

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.ensim.areamobility.conducteur.databinding.FragmentIncidentBinding

class IncidentFragment : Fragment() {

    private var _binding: FragmentIncidentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(IncidentViewModel::class.java)

        _binding = FragmentIncidentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textIncident
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}