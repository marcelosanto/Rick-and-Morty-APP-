package xyz.spacermarcelo.rickandmorty

import android.os.Bundle
import android.view.View
import xyz.spacermarcelo.rickandmorty.databinding.FragmentMainBinding
import xyz.spacermarcelo.rickandmorty.utils.navTo


class MainFragment : androidx.fragment.app.Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.btnFilter.setOnClickListener {
            navTo(R.id.filterFragment)
        }

        binding.txtCharactersTitle.setOnClickListener {
            navTo(R.id.detailFragment)
        }
    }
}