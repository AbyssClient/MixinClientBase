package dev.lofiz.clientbase.module;

import dev.lofiz.clientbase.module.render.IRender;
import dev.lofiz.clientbase.module.render.Position;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.gui.FontRenderer;

@Getter
@Setter
public abstract class HudModule extends Module implements IRender {

    private Position position;

    protected final FontRenderer fr = mc.fontRendererObj;

    public HudModule() {
        this.position = new Position(5, 5);
    }

    public boolean isHovered(int mouseX, int mouseY) {

        /* Take From GuiButton */
        return mouseX >= position.getX() && mouseY >= position.getY() && mouseX < position.getX() + position.getWidth() && mouseY < position.getY() + position.getHeight();
    }
}
