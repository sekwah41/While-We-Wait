package com.sekwah.whilewewait.audio;

import com.sekwah.whilewewait.WhileWeWait;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.audio.*;
import net.minecraft.client.options.GameOptions;
import net.minecraft.sound.SoundCategory;
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
        //musicTracker.play(new MusicTracker.MusicType(WAITING_MUSIC, 20, 600) );
        current = new CustomSoundInstance(WAITING_MUSIC);
        soundLoader.play(current);
        soundLoader.tick();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static SoundEvent register(String name) {
        return (SoundEvent) Registry.register(Registry.SOUND_EVENT, name, new SoundEvent(new Identifier("whilewewait", name)));
    }

    public void stopMusic() {
        soundLoader.stop(current);
    }
}
