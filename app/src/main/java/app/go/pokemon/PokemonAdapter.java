package app.go.pokemon;

import app.go.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.ImageView;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public final class PokemonAdapter extends Adapter<PokemonAdapter.PokemonViewHolder> {
    @FunctionalInterface
    interface OnPokemonSelectListener {
        void onSelect(final Pokemon pokemon);
    }

    public static final class PokemonViewHolder extends ViewHolder {
        private final View root;

        PokemonViewHolder(final View root) {
            super(root);
            this.root = root;
        }

        View getRoot() {
            return root;
        }
    }

    private final List<Pokemon> pokemons;
    private OnPokemonSelectListener onPokemonSelectListener;
    private OnPokemonSelectListener onPokemonImageSelectListener;

    PokemonAdapter(final List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    void setOnPokemonSelectListener(final OnPokemonSelectListener onPokemonSelectListener) {
        this.onPokemonSelectListener = onPokemonSelectListener;
    }

    void setOnPokemonImageSelectListener(final OnPokemonSelectListener onPokemonImageSelectListener) {
        this.onPokemonImageSelectListener = onPokemonImageSelectListener;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_recycler_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        final var root = holder.getRoot();
        final var pokemon = pokemons.get(position);
        final var pokemonName = (TextView) root.findViewById(R.id.pokemon_name);
        final var pokemonImage = (ImageView) root.findViewById(R.id.pokemon_image);

        assert pokemon.getSprites() != null;

        pokemonName.setText(pokemon.getName());

        final var frontalImage = pokemon.getSprites().getFrontDefault();
        Picasso.get().load(frontalImage).into(pokemonImage);

        pokemonImage.setOnClickListener(view -> onPokemonImageSelectListener.onSelect(pokemon));
        root.setOnClickListener(view -> onPokemonSelectListener.onSelect(pokemon));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}