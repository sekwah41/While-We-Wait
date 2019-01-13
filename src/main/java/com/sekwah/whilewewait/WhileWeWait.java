package com.sekwah.whilewewait;

import com.sekwah.whilewewait.audio.AudioManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.GameOptions;
import net.minecraft.sound.SoundCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class WhileWeWait implements ModInitializer {

    public static final Logger logger = LogManager.getLogger("While We Wait");

    private static WhileWeWait instance;

    public AudioManager audioManager;

    public WhileWeWait() {
        instance = this;
    }

    public static WhileWeWait getInstance() {
        return instance;
    }

    @Override
    public void onInitialize() {
        logger.info("Starting wait music");

        GameOptions options = new GameOptions(MinecraftClient.getInstance(), MinecraftClient.getInstance().runDirectory);

        this.audioManager = new AudioManager();

        this.audioManager.startMusic(WhileWeWait.class.getResourceAsStream("/assets/whilewewait/sounds/waiting.mp3"));

        float volume = options.getSoundVolume(SoundCategory.MASTER);

    }

}
