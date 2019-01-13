package com.sekwah.whilewewait.audio;

import com.sekwah.whilewewait.WhileWeWait;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class AudioManager {

    private boolean isPlaying = false;

    public void startMusic(InputStream resourceAsStream) {
        new Thread(() -> {
            try {
                AudioInputStream ais =
                        AudioSystem.getAudioInputStream(resourceAsStream);
                AudioFormat baseFormat = ais.getFormat();
                AudioFormat decodeFormat = new AudioFormat(
                        AudioFormat.Encoding.PCM_SIGNED,
                        baseFormat.getSampleRate(),
                        16,
                        baseFormat.getChannels(),
                        baseFormat.getChannels() * 2,
                        baseFormat.getSampleRate(),
                        false);
                AudioInputStream dais =
                        AudioSystem.getAudioInputStream(
                                decodeFormat, ais);
                Clip clip = AudioSystem.getClip();
                clip.open(dais);
                clip.start();
            } catch (Exception e) {
                WhileWeWait.logger.error(e.getMessage());
            }
        }).start();
    }

    public void stopMusic() {
    }
}
