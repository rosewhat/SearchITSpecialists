package com.moskovsky.searchitspecialists.ui.hr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moskovsky.searchitspecialists.R
import com.moskovsky.searchitspecialists.databinding.FragmentRegistrationAccountHRBinding
import com.moskovsky.searchitspecialists.ui.app.ListITSpecialistsFragment

class RegistrationAccountHRFragment : Fragment() {
    private var _binding: FragmentRegistrationAccountHRBinding? = null
    private val binding: FragmentRegistrationAccountHRBinding
        get() = _binding ?: throw RuntimeException(FRAGMENT_ERROR)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationAccountHRBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showListITSpecialistsFragment()
    }

    // Лист специалстов
    private fun showListITSpecialistsFragment() {
        binding.btNextInListItSpec.setOnClickListener {
            launchListITSpecialistsFragment()
        }
    }

    private fun launchListITSpecialistsFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            .replace(R.id.main_container, ListITSpecialistsFragment.newInstance())
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val FRAGMENT_ERROR = "RegistrationAccountHRFragment is null"
        fun newInstance(): Fragment {
            return RegistrationAccountHRFragment()
        }
    }
}