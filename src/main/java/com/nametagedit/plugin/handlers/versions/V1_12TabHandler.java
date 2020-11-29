package com.nametagedit.plugin.handlers.versions;

import com.nametagedit.plugin.handlers.*;
import org.bukkit.ChatColor;

@AutoRegisterTabHandler(versions = { "v1_12_R1" })
public class V1_12TabHandler extends TabHandler
{
    public V1_12TabHandler() {
        super("h", "c", "d", "a", "i", "j", "b", "NA", "f", "e");
    }
    
    @Override
    public String formatTeamName(final String name) {
        return (name.length() > 16) ? name.substring(0, 16) : name;
    }
    
    @Override
    public String format(final String input, final boolean limitChars) {
        return ChatColor.translateAlternateColorCodes('&', (limitChars && input.length() > 128) ? input.substring(0, 128) : input);
    }
}
