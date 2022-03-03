package xyz.spacermarcelo.rickandmorty.view.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import xyz.spacermarcelo.rickandmorty.R
import xyz.spacermarcelo.rickandmorty.api.model.Character
import xyz.spacermarcelo.rickandmorty.databinding.ItemListBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var listCharacters = emptyList<Character>()

    class CharacterViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.txtIdCharacter.text = character.id.toString()
            binding.txtNameCharacter.text = character.name
            binding.txtStatusCharacter.text = character.status
            Picasso.get().load(character.image).into(binding.imgCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(R.id.detailFragment)
        }
    }

    override fun getItemCount(): Int = listCharacters.size

    fun setCharacters(characters: List<Character>) {
        listCharacters = characters
        notifyDataSetChanged()
    }
}