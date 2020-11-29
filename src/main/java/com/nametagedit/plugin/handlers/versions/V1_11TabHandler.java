package com.nametagedit.plugin.handlers.versions;

import com.nametagedit.plugin.handlers.*;
import org.bukkit.ChatColor;

@AutoRegisterTabHandler(versions = { "v1_11_R1" })
public class V1_11TabHandler extends TabHandler
{
    public V1_11TabHandler() {
        super("h", "c", "d", "a", "i", "j", "b", "NA", "f", "e");
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
