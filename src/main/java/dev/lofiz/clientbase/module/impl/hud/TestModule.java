package dev.lofiz.clientbase.module.impl.hud;

import dev.lofiz.clientbase.module.Category;
import dev.lofiz.clientbase.module.HudModule;
import dev.lofiz.clientbase.module.annotation.Mod;
import dev.lofiz.clientbase.module.render.Position;
import dev.lofiz.clientbase.util.render.RenderUtils;

import java.awt.*;

@Mod(name = "Test Module", description = "Cool Test Module!", category = Category.HUD)
public class TestModule extends HudModule {

    public TestModule() {
        getPosition().setWidth(64);
        getPosition().setHeight(20);
    }

    @Override
    public void render(Position position) {
        RenderUtils.drawRect(position.getX(), position.getY(), position.getX() + position.getWidth(), position.getY() + position.getHeight(), new Color(0, 0, 0, 100).getRGB());
        fr.drawStringWithShadow(this.getName(), position.getX() + position.getWidth() / 2f - fr.getStringWidth(this.getName()) / 2f, position.getY() + 6, -1);
    }
}
