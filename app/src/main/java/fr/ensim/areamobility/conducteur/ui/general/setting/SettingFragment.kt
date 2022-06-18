package fr.ensim.areamobility.conducteur.ui.general.setting

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.ensim.areamobility.conducteur.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    companion object {
        private const val TAG = "SettingFragment"
        private fun isPackageInstalled(
            packageName: String,
            packageManager: PackageManager
        ): Boolean {
            return try {
                packageManager.getPackageInfo(packageName, 0)
                true
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        }
    }

    private var _binding: FragmentSettingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SettingViewModel::class.java)

        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSlideshow
//        slideshowViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        binding.sGoogleMaps.isChecked = true
        val pm = requireContext().packageManager
        val AppsPackages = HashMap<String, Boolean>();
        AppsPackages.put("Google Maps", isPackageInstalled("com.google.android.apps.maps", pm))
        AppsPackages.put("Android Auto", isPackageInstalled("com.google.android.projection.gearhead", pm))
        AppsPackages.put("Waze", isPackageInstalled("com.waze", pm))
        AppsPackages.put("Sygic", isPackageInstalled("com.sygic.aura", pm))
        AppsPackages.put("Plan", false)

//        for ((key, value) in AppsPackages) {
//            Log.d(TAG, "$key : $value")
//        }


        binding.sGoogleMaps.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && (AppsPackages.get("Google Maps") == true || AppsPackages.get("Android Auto") == true)) {
                binding.sAppleCar.isChecked = false
                binding.sSygic.isChecked = false
                binding.sWaze.isChecked = false
                Toast.makeText(this.requireContext(), "Maps/Android Auto : Activé", Toast.LENGTH_LONG).show()
            } else if (isChecked && !(AppsPackages.get("Google Maps") == true || AppsPackages.get("Android Auto") == true)){
                binding.sGoogleMaps.isChecked = false
                Toast.makeText(this.requireContext(), "L'application est manquante sur votre système", Toast.LENGTH_LONG).show()
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.projection.gearhead"))
                startActivity(myIntent)
            }
        }

        binding.sAppleCar.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && AppsPackages.get("Plan") == true) {
                binding.sGoogleMaps.isChecked = false
                binding.sSygic.isChecked = false
                binding.sWaze.isChecked = false
                Toast.makeText(this.requireContext(), "Plan/Apple Car : Activé", Toast.LENGTH_LONG).show()
            } else if (isChecked) {
                binding.sAppleCar.isChecked = false
                Toast.makeText(this.requireContext(), "Votre systeme n'est pas compatible", Toast.LENGTH_LONG).show()
            }
        }



        binding.sWaze.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && AppsPackages.get("Wase") == true) {
                binding.sGoogleMaps.isChecked = false
                binding.sSygic.isChecked = false
                binding.sAppleCar.isChecked = false
                Toast.makeText(this.requireContext(), "Waze : Activé", Toast.LENGTH_LONG).show()
            } else if (isChecked) {
                Toast.makeText(this.requireContext(), "L'application est manquante sur votre système", Toast.LENGTH_LONG).show()
                binding.sWaze.isChecked = false
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.waze"))
                startActivity(myIntent)
            }
        }

        binding.sSygic.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && AppsPackages.get("Sygic") == true) {
                binding.sGoogleMaps.isChecked = false
                binding.sWaze.isChecked = false
                binding.sAppleCar.isChecked = false
                Toast.makeText(this.requireContext(), "Sygic : Activé", Toast.LENGTH_LONG).show()
            } else if (isChecked){
                Toast.makeText(this.requireContext(), "L'application est manquante sur votre système", Toast.LENGTH_LONG).show()
                binding.sSygic.isChecked = false
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.sygic.aura"))
                startActivity(myIntent)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}