package dev.lofiz.clientbase.module;

import dev.lofiz.clientbase.Client;
import dev.lofiz.clientbase.module.annotation.Mod;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

@Getter
@Setter
public class Module {

    private final String name;
    private final String description;
    private final Category category;

    private boolean enabled;

    protected final Minecraft mc = Minecraft.getMinecraft();

    public Module() {

        Client.getInstance().getEventManager().register(this);

        this.name = getClass().getAnnotation(Mod.class).name();
        this.description = getClass().getAnnotation(Mod.class).description();
        this.category = getClass().getAnnotation(Mod.class).category();

        this.enabled = true;
    }

    public void onEnable() {
        Client.getInstance().getEventManager().register(this);
    }

    public void onDisable() {
        Client.getInstance().getEventManager().unregister(this);
    }

    public void toggle() {
        setEnabled(!isEnabled());

        if(enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if(enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
}
