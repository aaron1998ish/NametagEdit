package com.nametagedit.plugin.handlers.versions;

import com.nametagedit.plugin.handlers.*;
import org.bukkit.ChatColor;

@AutoRegisterTabHandler(versions = { "v1_15_R1", "v1_15_R2" })
public class V1_15_R1TabHandler extends TabHandler
{
    public V1_15_R1TabHandler() {
        super("h", "c", "d", "a", "i", "j", "b", "g", "f", "e");
    }
    
    @Override
    public String formatTeamName(final String name) {
        return (name.length() > 128) ? name.substring(0, 128) : name;
    }
    
    @Override
    public String format(final String input, final boolean limitChars) {
        return ChatColor.translateAlternateColorCodes('&', (limitChars && input.length() > 128) ? input.substring(0, 128) : input);
    }
}
