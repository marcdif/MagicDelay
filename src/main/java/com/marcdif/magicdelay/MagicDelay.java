package com.marcdif.magicdelay;

import com.marcdif.magicdelay.commands.DelayCommand;
import com.marcdif.magicdelay.utils.DelayUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MagicDelay extends JavaPlugin {
    @Getter private static MagicDelay instance;

    @Getter private static DelayUtil delayUtil;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("MagicDelay plugin enabled!");

        delayUtil = new DelayUtil();

        registerCommands();
    }

    private void registerCommands() {
        Objects.requireNonNull(this.getCommand("delay")).setExecutor(new DelayCommand());
    }
}
