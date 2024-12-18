package app.go.utils;

import app.go.pokemon.PokedexFragment;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

public final class PokeStateAdapter extends FragmentStateAdapter {
    private final Fragment[] fragments = new Fragment[] {
        new PokedexFragment()
    };

    public PokeStateAdapter(final Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
