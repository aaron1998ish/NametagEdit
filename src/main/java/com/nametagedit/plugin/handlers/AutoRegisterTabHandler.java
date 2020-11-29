package com.nametagedit.plugin.handlers;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRegisterTabHandler {
    String[] versions() default {};
}
