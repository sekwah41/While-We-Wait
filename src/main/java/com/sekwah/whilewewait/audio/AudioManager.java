package com.sekwah.whilewewait.audio;

import com.sekwah.whilewewait.WhileWeWait;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class AudioManager {

    private boolean isPlaying = false;

    public void startMusic() {
        new Thread(() -> {
            try {
                AudioInputStream ais =
                        AudioSystem.getAudioInputStream(WhileWeWait.class.getResourceAsStream("/assets/whilewewait/sounds/waiting.wav"));
                AudioFormat baseFormat = ais.getFormat();
                AudioFormat decodeFormat = new AudioFormat(
                        baseFormat.getEncoding(),
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
                e.printStackTrace();
            }
        }).start();
    }

    public void stopMusic() {
    }
}
