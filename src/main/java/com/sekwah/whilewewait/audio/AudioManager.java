package com.sekwah.whilewewait.audio;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class AudioManager {

    private static SoundLoader soundLoader;
    private static final SoundEvent WAITING_MUSIC = register("waiting");
    private static CustomSoundInstance current;

    public static void init() {
        soundLoader = MinecraftClient.getInstance().getSoundLoader();
    }

    /**
     * class_1138 is LibraryLWJGLOpenAL (from paulscode)
     */
    public static void startMusic() {
        if(current != null) {
            return;
        }
        soundLoader.stopAll();
        current = new CustomSoundInstance(WAITING_MUSIC);
        soundLoader.play(current);
    }

    private static SoundEvent register(String name) {
        return Registry.register(Registry.SOUND_EVENT, name, new SoundEvent(new Identifier("whilewewait", name)));
    }

    public static void stopMusic() {
        if(current != null) {
            soundLoader.stop(current);
            current = null;
        }
    }
}
