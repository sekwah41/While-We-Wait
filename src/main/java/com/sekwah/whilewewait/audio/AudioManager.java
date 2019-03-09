package com.sekwah.whilewewait.audio;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AudioManager {

    private static final SoundEvent WAITING_MUSIC = register("waiting");
    private static final CustomSoundInstance SOUND_INSTANCE = new CustomSoundInstance(WAITING_MUSIC);
    private static SoundLoader soundLoader;
    private static boolean playing = false;

    /**
     * class_1138 is LibraryLWJGLOpenAL (from paulscode)
     */
    public static void startMusic() {
        if(!playing) {
            getSoundLoader().stopAll();
            getSoundLoader().play(SOUND_INSTANCE);
            playing = true;
        }
    }

    private static SoundEvent register(String name) {
        Identifier id = new Identifier("whilewewait", name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void stopMusic() {
        if(playing) {
            getSoundLoader().stop(SOUND_INSTANCE);
            playing = false;
        }
    }

    private static SoundLoader getSoundLoader() {
        if(soundLoader == null) {
            soundLoader = MinecraftClient.getInstance().getSoundLoader();
        }
        return soundLoader;
    }
}
