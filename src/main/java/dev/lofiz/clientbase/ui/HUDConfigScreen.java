package dev.lofiz.clientbase.ui;

import dev.lofiz.clientbase.Client;
import dev.lofiz.clientbase.module.Category;
import dev.lofiz.clientbase.module.HudModule;
import dev.lofiz.clientbase.module.Module;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HUDConfigScreen extends GuiScreen {

    private final List<Module> modules = Client.getInstance().getModuleManager().getModules().stream().filter(Module::isEnabled).filter(m -> m.getCategory().equals(Category.HUD)).collect(Collectors.toList());

    private float lastX, lastY;

    private Module selectedModule;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        this.drawDefaultBackground();

        for(Module m : modules) {

            ((HudModule) m).renderDummy(((HudModule) m).getPosition());

            if(selectedModule != null) {
                ((HudModule) selectedModule).getPosition().setPosition(mouseX - lastX, mouseY - lastY);
            }
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        for(Module m : modules) {
            if(((HudModule) m).isHovered(mouseX, mouseY)) {
                if(mouseButton == 0) {
                    selectedModule = m;
                    lastX = mouseX - ((HudModule) m).getPosition().getX();
                    lastY = mouseY - ((HudModule) m).getPosition().getY();
                    break;
                }
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);

        selectedModule = null;
    }

    @Override
    public void onGuiClosed() {

        selectedModule = null;
    }
}
