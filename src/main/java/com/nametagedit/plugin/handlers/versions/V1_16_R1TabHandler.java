package com.nametagedit.plugin.handlers.versions;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.nametagedit.plugin.handlers.*;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R1.CraftServer;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R1.util.CraftChatMessage;

import java.awt.*;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.regex.Pattern;

@AutoRegisterTabHandler(versions = {"v1_16_R1", "v_16_R2"})
public class V1_16_R1TabHandler extends TabHandler {

    private static int red = 255, green = 0, blue = 0;

    private static final Pattern colorPattern = Pattern.compile("(\\{#[a-fA-F0-9]{3,6}\\})");

    public V1_16_R1TabHandler() {
        super("h", "c", "d", "a", "i", "j", "b", "g", "f", "e");
    }

    @Override
    public String formatTeamName(final String name) {
        return (name.length() > 128) ? name.substring(0, 128) : name;
    }

    @Override
    public String format(final String input, final boolean limitChars) {
        String resized = (limitChars && input.length() > 128) ? input.substring(0, 128) : input;
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', (limitChars && input.length() > 128) ? input.substring(0, 128) : input);
        //return chatFormat(resized);
    }

//    protected String chatFormat(String string) {
//        //        Color rainbowColor = getRainbowColor();
//        String hex = String.format("#%02x%02x%02x%n\n", rainbowColor.getRed(), rainbowColor.getGreen(), rainbowColor.getBlue());
//        System.out.println(hex);
//
//        JsonObject object = new JsonObject();
//        object.add("text", new JsonPrimitive("TEST"));
//        object.add("color", new JsonPrimitive(hex));
//
//        IChatBaseComponent[] iChatBaseComponents = CraftChatMessage.fromString(ChatColor.of(rainbowColor) + "T");
//
//
//        return ChatColor.of(rainbowColor) + string;
//    }

    /**
     * For testing, this was just so I can oscillate between colors.
     *
     * @return
     */
    private static Color getRainbowColor() {

        int jump = 3;

        if (red > 0 && blue == 0) {
            red -= jump;
            green += jump;
        }
        if (green > 0 && red == 0) {
            green -= jump;
            blue += jump;
        }
        if (blue > 0 && green == 0) {
            red += jump;
            blue -= jump;
        }

        if (red > 255) {
            red = 255;
        }

        if (blue > 255) {
            blue = 0;
        }

        if (green > 255) {
            green = 0;
        }

        if (red < 0) {
            red = 0;
        }

        if (blue < 0) {
            blue = 255;
        }

        if (green < 0) {
            green = 255;
        }

        return new Color(red, green, blue);
    }
}
