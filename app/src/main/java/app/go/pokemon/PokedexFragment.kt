package app.go.pokemon

import app.go.R

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.lifecycle.lifecycleScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.create

class PokedexFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.pokedex_fragment_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.run {
            lifecycleScope.launch {
                val pageZero = async {
                    withContext(Dispatchers.IO) {
                        val pokemons = arrayListOf<Pokemon>()
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://pokeapi.co/api/v2/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create<PokemonService>()
                        for (i in 0 until 20) {
                            val response = retrofit.getPokemonById(i).execute()
                            if (response.isSuccessful) {
                                val pokemon = response.body()
                                pokemons.add(pokemon!!)
                            }
                        }
                        pokemons
                    }
                }

                launch {
                    withContext(Dispatchers.Main) {
                        pageZero.await().run {
                            val recyclerView = findViewById<RecyclerView>(R.id.pokemons_list)
                            val adapter = PokemonAdapter(this).apply {
                                setOnPokemonImageSelectListener { pokemon: Pokemon ->
                                    parentFragmentManager.commit {
                                        replace(R.id.fragment_container, PokemonDetailedInfoFragment(pokemon))
                                    }
                                }
                                setOnPokemonSelectListener { pokemon: Pokemon ->
                                    parentFragmentManager.commit {
                                        replace(R.id.fragment_container, PokemonDetailedInfoFragment(pokemon))
                                    }
                                }
                            }
                            recyclerView.layoutManager = GridLayoutManager(context, 1)
                            recyclerView.adapter = adapter
                        }
                    }
                }
            }
        }
    }
}