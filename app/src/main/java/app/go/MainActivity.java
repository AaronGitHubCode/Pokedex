package app.go;

import app.go.utils.HappyActivity;

public final class MainActivity extends HappyActivity {
    public MainActivity() {
        super(R.layout.main_activity_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final var transaction = getSupportFragmentManager().beginTransaction(); {
            transaction.replace(R.id.fragment_container, new MainFragment(), "main_menu");
        } transaction.commit();
    }
}
