package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.WhileWeWait;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Mixin(SoundLoader.class)
public class SoundLoaderMixin {

    @Inject(method = "onResourceReload", at = @At("RETURN"))
    public void resourceReload(ResourceManager manager, CallbackInfo ci) {
        //WhileWeWait.getInstance().audioManager.stopMusic();
    }


}
