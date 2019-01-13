package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.WhileWeWait;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class GameStartMixin {

    @Inject(method = "init", at = @At("RETURN"))
    public void startGame(CallbackInfo ci) {
        WhileWeWait.getInstance().audioManager.stopMusic();
    }

}
