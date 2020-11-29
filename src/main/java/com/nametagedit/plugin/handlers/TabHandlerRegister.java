package com.nametagedit.plugin.handlers;

import com.google.common.collect.Maps;
import com.nametagedit.plugin.NametagEdit;
import com.nametagedit.plugin.handlers.versions.hybrid.V1_7_CaudronTabHandler;
import com.nametagedit.plugin.utils.BukkitVersion;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TabHandlerRegister {
    private Map<String[], TabHandlerRegister.Creator> registry = Maps.newHashMap();
    private TabHandler currentHandler;

    public TabHandlerRegister() {
        Reflections reflections = new Reflections("com.nametagedit.plugin.handlers");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(AutoRegisterTabHandler.class);

        for (Class<?> annotatedTabClass : annotated) {
            this.register(() -> {
                try {
                    TabHandler handler = (TabHandler) annotatedTabClass.getDeclaredConstructor().newInstance();
                    NametagEdit.getPlugin(NametagEdit.class)
                            .getLogger()
                            .info("Registered handler " + handler.getClass().getName());
                    return handler;
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var2) {
                    var2.printStackTrace();
                    return null;
                }
            }, annotatedTabClass.getAnnotation(AutoRegisterTabHandler.class).versions());
        }

    }

    public TabHandler getCurrentHandler() {
        if (this.currentHandler == null) {
            try {
                Class.forName("cpw.mods.fml.common.Mod");
                this.currentHandler = new V1_7_CaudronTabHandler();
                return this.currentHandler;
            } catch (ClassNotFoundException var8) {
                String bukkitVersion = BukkitVersion.getBukkitVersion();
                Iterator var2 = this.registry.keySet().iterator();

                while (var2.hasNext()) {
                    String[] strings = (String[]) var2.next();
                    String[] var4 = strings;
                    int var5 = strings.length;

                    for (int var6 = 0; var6 < var5; ++var6) {
                        String string = var4[var6];
                        if (string.equalsIgnoreCase(bukkitVersion)) {
                            this.currentHandler = ((TabHandlerRegister.Creator) this.registry.get(strings)).createHandler();
                        }
                    }
                }
            }
        }

        return this.currentHandler;
    }

    public void register(TabHandlerRegister.Creator creator, String... versions) {
        this.registry.put(versions, creator);
    }

    public interface Creator {
        TabHandler createHandler();
    }
}
