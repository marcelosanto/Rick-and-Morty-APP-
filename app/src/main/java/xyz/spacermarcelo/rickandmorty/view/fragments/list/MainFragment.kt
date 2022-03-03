package xyz.spacermarcelo.rickandmorty.view.fragments.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import xyz.spacermarcelo.rickandmorty.R
import xyz.spacermarcelo.rickandmorty.api.repository.Repository
import xyz.spacermarcelo.rickandmorty.databinding.FragmentMainBinding
import xyz.spacermarcelo.rickandmorty.utils.navTo
import xyz.spacermarcelo.rickandmorty.viewmodel.SharedViewModel
import xyz.spacermarcelo.rickandmorty.viewmodel.SharedViewModelFactory


class MainFragment : androidx.fragment.app.Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(Repository())
    }

    private var adapter = CharacterAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacters(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.apply {

            sharedViewModel.listCharacters.observe(viewLifecycleOwner) { response ->
                if (response.isSuccessful) {
                    adapter.setCharacters(response.body()!!.results)
                    txtApiError.visibility = View.GONE
                    recyclerview.visibility = View.VISIBLE
                } else {
                    txtApiError.text = getString(R.string.text_error, response.code())
                    txtApiError.visibility = View.VISIBLE
                    recyclerview.visibility = View.INVISIBLE
                }
            }


            recyclerview.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            recyclerview.adapter = adapter

            btnFilter.setOnClickListener {
                navTo(R.id.filterFragment)
            }

        }


    }
}