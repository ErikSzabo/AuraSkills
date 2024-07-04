package dev.aurelium.auraskills.bukkit.loot.entity;

import dev.aurelium.auraskills.bukkit.loot.parser.CustomEntityParser;
import org.spongepowered.configurate.ConfigurationNode;

public class VanillaEntityParser implements CustomEntityParser {
    @Override
    public EntitySupplier getEntitySupplier(ConfigurationNode config) {
        return new VanillaEntitySupplier(EntityProperties.fromConfig(config));
    }

    @Override
    public boolean shouldUseParser(ConfigurationNode config) {
        String entity = config.node("entity").getString();

        // If it has a colon, it's a custom entity
        // But if it starts with minecraft:, it's a vanilla entity stated explicitly
        return !entity.contains(":") || config.node("entity").getString().startsWith("minecraft:");
    }
}
