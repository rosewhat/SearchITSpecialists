package com.moskovsky.searchitspecialists.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moskovsky.searchitspecialists.R
import com.moskovsky.searchitspecialists.databinding.FragmentRegistrationStackUserBinding


class RegistrationStackUserFragment : Fragment() {
    private var _binding: FragmentRegistrationStackUserBinding? = null
    private val binding: FragmentRegistrationStackUserBinding
        get() = _binding ?: throw RuntimeException(FRAGMENT_ERROR)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationStackUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRegistrationCompetenciesUserFragment()
    }

    // Компетенции
    private fun showRegistrationCompetenciesUserFragment() {
        binding.btNextInRegSpecializationUser.setOnClickListener {
            launchRegistrationCompetenciesUserFragment()
        }
    }

    private fun launchRegistrationCompetenciesUserFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            .replace(R.id.main_container, RegistrationCompetenciesUserFragment.newInstance())
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val FRAGMENT_ERROR = "RegistrationStackUserFragment is null"
        fun newInstance(): Fragment {
            return RegistrationStackUserFragment()
        }
    }
}