package dev.lofiz.clientbase.mixins.client;

import dev.lofiz.clientbase.Client;
import dev.lofiz.clientbase.eventbus.events.ClientTickEvent;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "startGame", at = @At("HEAD"))
    private void startGamePre(CallbackInfo ci) {
        Client.getInstance().init();
    }

    @Inject(method = "startGame", at = @At("RETURN"))
    private void startGamePost(CallbackInfo ci) {
        Client.getInstance().postInit();
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    private void shutdownMinecraftApplet(CallbackInfo ci) {
        Client.getInstance().shutdown();
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    private void runTick(CallbackInfo ci) {
        final ClientTickEvent event = new ClientTickEvent();
        event.call();
    }
}
