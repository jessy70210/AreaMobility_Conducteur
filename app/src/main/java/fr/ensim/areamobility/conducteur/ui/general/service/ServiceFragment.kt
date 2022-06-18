package fr.ensim.areamobility.conducteur.ui.general.service

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.ensim.areamobility.conducteur.databinding.FragmentServiceBinding
import fr.ensim.areamobility.conducteur.service.ServiceService
import java.util.*


class ServiceFragment : Fragment() {


    private var _binding: FragmentServiceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(ServiceViewModel::class.java)

        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textGallery
//        galleryViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        for(service in ServiceService.services){
//            if (Calendar.MONDAY == service.StartDate.get(Calendar.DAY_OF_WEEK))
            when (service.StartDate.get(Calendar.DAY_OF_WEEK)) {
                Calendar.MONDAY -> {


                    binding.relativeLayoutMonday
                }
                Calendar.TUESDAY -> {}
                Calendar.WEDNESDAY -> {}
                Calendar.THURSDAY -> {}
                Calendar.FRIDAY -> {}
                Calendar.SATURDAY -> {}
                Calendar.SUNDAY -> {}
            }
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun makeBtn(start: Calendar, end: Calendar) {
        val btn = Button(this.requireContext())
        btn.layoutParams = RelativeLayout.LayoutParams(
            100, RelativeLayout.LayoutParams.MATCH_PARENT
        )


//        val layout = findViewById(R.id.slidingDrawerContent) as RelativeLayout
//        val lp = RelativeLayout.LayoutParams(
//            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT
//        )


    }
}