package app.go;

import app.go.R;

import app.go.utils.IAudioService;
import app.go.utils.PokeStateAdapter;

import android.content.Context;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayout;

public final class MainFragment extends Fragment {
    private IAudioService audioService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        audioService = (IAudioService) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        audioService.onChangeAudioResource(R.raw.main);

        final var stateAdapter = new PokeStateAdapter(this);

        final var viewPager = (ViewPager2) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(stateAdapter);

        final var tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: { tab.setText("Pokedex"); } break;
            }
        }).attach();
    }
}
