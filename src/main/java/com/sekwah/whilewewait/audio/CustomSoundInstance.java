package com.sekwah.whilewewait.audio;

import net.minecraft.client.audio.AbstractSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class CustomSoundInstance extends AbstractSoundInstance {

    CustomSoundInstance(SoundEvent event) {
        super(event, SoundCategory.MASTER);
        this.attenuationType = AttenuationType.NONE;
    }

    @Override
    public float getVolume() {
        return 0.35f;
    }

    @Override
    public float getPitch() {
        return 1.0F;
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }
}
