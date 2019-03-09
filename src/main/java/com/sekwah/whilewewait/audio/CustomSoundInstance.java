package com.sekwah.whilewewait.audio;

import net.minecraft.client.audio.AbstractSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CustomSoundInstance extends AbstractSoundInstance {

    private SoundEvent event;

    CustomSoundInstance(SoundEvent event) {
        super(event, SoundCategory.RECORD);
        this.event = event;
    }

    @Override
    public Identifier getId() {
        return this.event.getId();
    }

    @Override
    public SoundCategory getCategory() {
        return SoundCategory.MASTER;
    }

    @Override
    public float getVolume() {
        return 0.75f;
    }

    @Override
    public float getPitch() {
        return 1;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getZ() {
        return 0;
    }

    @Override
    public AttenuationType getAttenuationType() {
        return AttenuationType.NONE;
    }
}
