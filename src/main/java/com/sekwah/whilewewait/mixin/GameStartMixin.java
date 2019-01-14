package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.WhileWeWait;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CloseWorldGui;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.WorldGenerationProgressGui;
import net.minecraft.client.gui.menu.DownloadingTerrainGui;
import net.minecraft.client.gui.menu.ServerConnectingGui;
import net.minecraft.client.gui.menu.WorkingGui;
import net.minecraft.resource.ReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class GameStartMixin {

    @Shadow
    private ReloadableResourceManager resourceManager;

    @Inject(method = "init", at = @At("RETURN"))
    public void startGame(CallbackInfo ci) {
        WhileWeWait.getInstance().audioManager.init();
    }

    @Inject(method = "openGui", at = @At("HEAD"))
    public void openGui(Gui gui, CallbackInfo ci){
        //System.out.println(gui);
        if(gui instanceof WorldGenerationProgressGui ||gui instanceof ServerConnectingGui || gui instanceof WorkingGui
                || gui instanceof DownloadingTerrainGui || gui instanceof CloseWorldGui) {
            WhileWeWait.getInstance().audioManager.startMusic();
        }
        else {
            WhileWeWait.getInstance().audioManager.stopMusic();
        }
    }

}
