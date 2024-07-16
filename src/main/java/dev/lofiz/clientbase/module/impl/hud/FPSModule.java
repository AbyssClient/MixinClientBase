package dev.lofiz.clientbase.module.impl.hud;

import dev.lofiz.clientbase.module.Category;
import dev.lofiz.clientbase.module.HudModule;
import dev.lofiz.clientbase.module.annotation.Mod;
import dev.lofiz.clientbase.module.render.Position;
import dev.lofiz.clientbase.util.render.RenderUtils;
import net.minecraft.client.Minecraft;

import java.awt.*;

@Mod(name = "FPS", description = "Display your FPS", category = Category.HUD)
public class FPSModule extends HudModule {

    public FPSModule() {
        getPosition().setWidth(64);
        getPosition().setHeight(20);
    }

    @Override
    public void render(Position position) {
        RenderUtils.drawRect(position.getX(), position.getY(), position.getX() + position.getWidth(), position.getY() + position.getHeight(), new Color(0, 0, 0, 100).getRGB());
        fr.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), position.getX() + position.getWidth() / 2f - fr.getStringWidth("FPS: " + Minecraft.getDebugFPS()) / 2f, position.getY() + 6, -1);
    }
}
