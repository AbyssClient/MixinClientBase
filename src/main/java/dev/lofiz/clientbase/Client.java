package dev.lofiz.clientbase;

import dev.lofiz.clientbase.eventbus.EventManager;
import dev.lofiz.clientbase.eventbus.EventTarget;
import dev.lofiz.clientbase.eventbus.events.ClientTickEvent;
import dev.lofiz.clientbase.module.ModuleManager;
import dev.lofiz.clientbase.ui.HUDConfigScreen;
import dev.lofiz.clientbase.util.Logger;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * @author iLofiz
 * @version 1.0.0
 */
public final class Client {

    private static Client instance;

    public static Client getInstance() {
        if(instance == null) instance = new Client();

        return instance;
    }

    private final Minecraft mc = Minecraft.getMinecraft();

    @Getter
    private EventManager eventManager;

    @Getter
    private ModuleManager moduleManager;

    public void init() {
        Logger.INFO("Client is Starting");

        eventManager = new EventManager();

        eventManager.register(this);
    }

    public void postInit() {
        Logger.INFO("Client has Started");

        moduleManager = new ModuleManager();
    }

    public void shutdown() {
        Logger.INFO("Client is Shutting Down");
    }

    @EventTarget
    public void onTick(ClientTickEvent event) {

        if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            mc.displayGuiScreen(new HUDConfigScreen());
        }
    }
}
