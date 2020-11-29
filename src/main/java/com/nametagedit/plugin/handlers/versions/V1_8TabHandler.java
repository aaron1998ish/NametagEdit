package com.nametagedit.plugin.handlers.versions;

import com.nametagedit.plugin.handlers.*;
import org.bukkit.ChatColor;

@AutoRegisterTabHandler(versions = { "v1_8_R1", "v1_8_R2", "v1_8_R3" })
public class V1_8TabHandler extends TabHandler
{
    public V1_8TabHandler() {
        super("g", "c", "d", "a", "h", "i", "b", "NA", "NA", "e");
    }
    
    @Override
    public String formatTeamName(final String name) {
        return (name.length() > 16) ? name.substring(0, 16) : name;
    }
    
    @Override
    public String format(final String input, final boolean limitChars) {
        return ChatColor.translateAlternateColorCodes('&', (limitChars && input.length() > 16) ? input.substring(0, 16) : input);
    }
}
