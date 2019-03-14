package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.audio.AudioManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CloseWorldScreen;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.WorldGenerationProgressScreen;
import net.minecraft.client.gui.menu.DownloadingTerrainScreen;
import net.minecraft.client.gui.menu.ServerConnectingScreen;
import net.minecraft.client.gui.menu.WorkingScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class GameStartMixin {

    @Inject(method = "openScreen", at = @At("HEAD"))
    private void startStopMusic(Screen screen, CallbackInfo ci) {
        if(screen instanceof WorldGenerationProgressScreen || screen instanceof DownloadingTerrainScreen || screen instanceof CloseWorldScreen || screen instanceof ServerConnectingScreen) {
            AudioManager.startMusic();
        }
        else if(!(screen instanceof WorkingScreen)) {
            AudioManager.stopMusic();
        }
    }
}
