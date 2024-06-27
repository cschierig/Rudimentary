package com.carlschierig.rudimentary.util;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
    public static final String MODID = "rudimentary";
    public static final Logger LOG = LoggerFactory.getLogger(MODID);

    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(MODID, name);
    }
}
