package dev.lofiz.clientbase.mixins;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClientTweaker implements ITweaker {

    private final List<String> launchArgs = new ArrayList<>();

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {

        this.launchArgs.addAll(args);

        addArgs("gameDir", gameDir);
        addArgs("assetsDir", assetsDir);
        addArgs("version", profile);

    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {

        MixinBootstrap.init();

        MixinEnvironment env = MixinEnvironment.getDefaultEnvironment();

        env.addConfiguration("mixins.clientbase.json");

        if(env.getObfuscationContext() == null) {
            env.setObfuscationContext("notch");
        }

        env.setSide(MixinEnvironment.Side.CLIENT);

    }

    @Override
    public String getLaunchTarget() {
        return MixinBootstrap.getPlatform().getLaunchTarget();
    }

    @Override
    public String[] getLaunchArguments() {
        return this.launchArgs.toArray(new String[0]);
    }

    private void addArgs(String label, Object value) {
        launchArgs.add("--" + label);
        launchArgs.add(value instanceof String ? (String) value : value instanceof File ? ((File) value).getAbsolutePath() : ".");
    }
}