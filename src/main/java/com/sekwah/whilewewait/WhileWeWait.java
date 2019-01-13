package com.sekwah.whilewewait;

import com.sekwah.whilewewait.audio.AudioManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        this.audioManager = new AudioManager();

    }

}
