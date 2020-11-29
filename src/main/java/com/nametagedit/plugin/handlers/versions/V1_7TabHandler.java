package com.nametagedit.plugin.handlers.versions;

import com.nametagedit.plugin.handlers.*;
import org.bukkit.ChatColor;

@AutoRegisterTabHandler(versions = { "v1_7_R1", "v1_7_R2", "v1_7_R3", "v1_7_R4" })
public class V1_7TabHandler extends TabHandler
{
    public V1_7TabHandler() {
        super("e", "c", "d", "a", "f", "g", "b", "NA", "NA", "NA");
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
