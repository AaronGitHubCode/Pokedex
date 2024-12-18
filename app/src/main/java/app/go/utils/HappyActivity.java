package app.go.utils;

import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public abstract class HappyActivity extends AppCompatActivity implements IAudioService {
    private MediaPlayer mediaPlayer = new MediaPlayer();

    protected HappyActivity(final int layout) {
        super(layout);
    }

    @Override
    public void onPauseAudio() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    @Override
    public void onPlayAudio() {
        if (!mediaPlayer.isPlaying())
            mediaPlayer.start();
    }

    @Override
    public void onChangeAudioResource(int resource) {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
        mediaPlayer = MediaPlayer.create(this, resource);
        mediaPlayer.start();
    }
}
