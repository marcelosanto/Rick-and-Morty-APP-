package xyz.spacermarcelo.rickandmorty

import android.os.Bundle
import android.view.View
import xyz.spacermarcelo.rickandmorty.databinding.FragmentDetailBinding

class DetailFragment : androidx.fragment.app.Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
    }
}