package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.WhileWeWait;
import net.minecraft.client.audio.SoundLoader;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourceReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ReloadableResourceManagerImpl.class)
public class ReloadableResourceManagerMixin {

    @Inject(method = "addListener", at = @At("RETURN"))
    public void resourceReload(ResourceReloadListener listener, CallbackInfo ci) {
        if(listener instanceof SoundLoader) {
            WhileWeWait.getInstance().audioManager.init();
            WhileWeWait.getInstance().audioManager.startMusic();
        }
        //WhileWeWait.getInstance().audioManager.stopMusic();
    }
}
