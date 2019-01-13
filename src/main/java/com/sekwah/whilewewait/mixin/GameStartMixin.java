package com.sekwah.whilewewait.mixin;

import com.sekwah.whilewewait.WhileWeWait;
import com.sun.istack.internal.Nullable;
import net.minecraft.class_3928;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CloseWorldGui;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.menu.DownloadingTerrainGui;
import net.minecraft.client.gui.menu.ServerConnectingGui;
import net.minecraft.client.gui.menu.WorkingGui;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(MinecraftClient.class)
public class GameStartMixin {

    @Shadow
    private ReloadableResourceManager resourceManager;

    @Inject(method = "init", at = @At("RETURN"))
    public void startGame(CallbackInfo ci) {
        WhileWeWait.getInstance().audioManager.init();
    }

    @Inject(method = "openGui", at = @At("HEAD"))
    public void openGui(@Nullable Gui gui, CallbackInfo ci){
        //System.out.println(gui);
        if(gui instanceof class_3928 || gui instanceof ServerConnectingGui || gui instanceof WorkingGui
                || gui instanceof DownloadingTerrainGui || gui instanceof CloseWorldGui) {
            WhileWeWait.getInstance().audioManager.startMusic();
        }
        else {
            WhileWeWait.getInstance().audioManager.stopMusic();
        }
    }

}
