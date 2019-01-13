package com.sekwah.whilewewait.audio;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.audio.MusicTracker;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class AudioManager {

    private boolean isPlaying = false;
    private SoundLoader soundLoader;
    private MusicTracker musicTracker;
    private SoundEvent WAITING_MUSIC = register("waiting");
    private CustomSoundInstance current;

    public void init() {
        if(soundLoader != null) {
            return;
        }
        soundLoader = MinecraftClient.getInstance().getSoundLoader();
        musicTracker = MinecraftClient.getInstance().getMusicTracker();

    }

    /**
     * class_1138 is LibraryLWJGLOpenAL (from paulscode)
     */
    public void startMusic() {
        if(current != null) {
            return;
        }
        soundLoader.stopAll();
        current = new CustomSoundInstance(WAITING_MUSIC);
        soundLoader.play(current);
    }

    private static SoundEvent register(String name) {
        return (SoundEvent) Registry.register(Registry.SOUND_EVENT, name, new SoundEvent(new Identifier("whilewewait", name)));
    }

    public void stopMusic() {
        if(current != null) {
            soundLoader.stop(current);
            current = null;
        }
    }
}
