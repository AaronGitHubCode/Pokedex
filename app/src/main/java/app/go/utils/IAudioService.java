package app.go.utils;

public interface IAudioService {
    void onChangeAudioResource(int resource);
    void onPauseAudio();
    void onPlayAudio();
}
