package com.nametagedit.plugin.utils;

import org.bukkit.*;

public class BukkitVersion
{
    private static String BUKKIT_VERSION;

    private BukkitVersion() {
    }

    public static String getBukkitVersion() {
        if (BukkitVersion.BUKKIT_VERSION == null) {
            BukkitVersion.BUKKIT_VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        }
        return BukkitVersion.BUKKIT_VERSION;
    }
}
