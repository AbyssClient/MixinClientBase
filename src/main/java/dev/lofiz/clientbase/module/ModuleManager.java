package dev.lofiz.clientbase.module;

import dev.lofiz.clientbase.Client;
import dev.lofiz.clientbase.eventbus.EventTarget;
import dev.lofiz.clientbase.eventbus.events.RenderEvent;
import dev.lofiz.clientbase.module.impl.hud.FPSModule;
import dev.lofiz.clientbase.module.impl.hud.TestModule;
import dev.lofiz.clientbase.ui.HUDConfigScreen;
import lombok.Getter;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    @Getter
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        init();
    }

    public void init() {
        Client.getInstance().getEventManager().register(this);

        modules.add(new TestModule());
        modules.add(new FPSModule());
    }

    @EventTarget
    public void onRender(RenderEvent event) {

        if(!(Minecraft.getMinecraft().currentScreen instanceof HUDConfigScreen)) {
            modules.stream().filter(Module::isEnabled).filter(m -> m.getCategory().equals(Category.HUD)).forEach(m -> ((HudModule) m).render(((HudModule) m).getPosition()));
        }
    }
}
