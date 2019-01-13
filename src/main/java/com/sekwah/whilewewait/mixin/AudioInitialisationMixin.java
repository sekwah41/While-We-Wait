package com.sekwah.whilewewait.mixin;

import net.minecraft.class_1138;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.util.Arrays;

@Mixin(class_1138.class)
public class AudioInitialisationMixin {

    @Inject(method = "init", at = @At("RETURN"))
    public void startGame(CallbackInfo ci) {

    }
}
