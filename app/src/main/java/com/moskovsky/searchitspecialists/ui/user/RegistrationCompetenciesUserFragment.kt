package com.moskovsky.searchitspecialists.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moskovsky.searchitspecialists.R
import com.moskovsky.searchitspecialists.databinding.FragmentRegistrationCompetenciesUserBinding


class RegistrationCompetenciesUserFragment : Fragment() {
    private var _binding: FragmentRegistrationCompetenciesUserBinding? = null
    private val binding: FragmentRegistrationCompetenciesUserBinding
        get() = _binding ?: throw RuntimeException(FRAGMENT_ERROR)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationCompetenciesUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBeforeTestUserFragment()
    }

    // Экран перед главным экраном
    private fun showBeforeTestUserFragment() {
        binding.btNextBeforeTest.setOnClickListener {
            launchBeforeTestUserFragment()
        }
    }

    private fun launchBeforeTestUserFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            .replace(R.id.main_container, FinalScreenTestUserFragment.newInstance())
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val FRAGMENT_ERROR = "RegistrationAccountUserFragment is null"
        fun newInstance(): Fragment {
            return RegistrationCompetenciesUserFragment()
        }
    }
}