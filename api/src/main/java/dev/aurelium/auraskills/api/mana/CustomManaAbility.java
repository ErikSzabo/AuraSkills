package dev.aurelium.auraskills.api.mana;

import dev.aurelium.auraskills.api.annotation.Inject;
import dev.aurelium.auraskills.api.registry.NamespacedId;
import dev.aurelium.auraskills.api.registry.NamespacedRegistry;
import dev.aurelium.auraskills.api.skill.Skill;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CustomManaAbility implements ManaAbility {

    @Inject
    private ManaAbilityProvider provider;

    private final NamespacedId id;
    @Nullable
    private final String displayName;
    @Nullable
    private final String description;

    private CustomManaAbility(NamespacedId id, @Nullable String displayName, @Nullable String description) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
    }

    public static CustomManaAbilityBuilder builder(String name, NamespacedRegistry registry) {
        return new CustomManaAbilityBuilder(NamespacedId.from(registry.getNamespace(), name));
    }

    @Override
    public Skill getSkill() {
        return provider.getSkill(this);
    }

    @Override
    public NamespacedId getId() {
        return id;
    }

    @Override
    public int getMaxLevel() {
        return provider.getMaxLevel(this);
    }

    @Override
    public int getUnlock() {
        return provider.getUnlock(this);
    }

    @Override
    public int getLevelUp() {
        return provider.getLevelUp(this);
    }

    @Override
    public String getDisplayName(Locale locale) {
        return displayName != null ? displayName : provider.getDisplayName(this, locale);
    }

    @Override
    public String getDescription(Locale locale) {
        return description != null ? description : provider.getDescription(this, locale);
    }

    @Override
    public String name() {
        return id.getKey().toUpperCase(Locale.ROOT);
    }

    @Override
    public boolean isEnabled() {
        return provider.isEnabled(this);
    }

    @Override
    public double getBaseValue() {
        return provider.getBaseValue(this);
    }

    @Override
    public double getValuePerLevel() {
        return provider.getValuePerLevel(this);
    }

    @Override
    public double getValue(int level) {
        return provider.getValue(this, level);
    }

    @Override
    public double getDisplayValue(int level) {
        return provider.getDisplayValue(this, level);
    }

    @Override
    public double getBaseCooldown() {
        return provider.getBaseCooldown(this);
    }

    @Override
    public double getCooldownPerLevel() {
        return provider.getCooldownPerLevel(this);
    }

    @Override
    public double getCooldown(int level) {
        return provider.getCooldown(this, level);
    }

    @Override
    public double getBaseManaCost() {
        return provider.getBaseManaCost(this);
    }

    @Override
    public double getManaCostPerLevel() {
        return provider.getManaCostPerLevel(this);
    }

    @Override
    public double getManaCost(int level) {
        return provider.getManaCost(this, level);
    }

    @Override
    public boolean optionBoolean(String key) {
        return provider.optionBoolean(this, key);
    }

    @Override
    public boolean optionBoolean(String key, boolean def) {
        return provider.optionBoolean(this, key, def);
    }

    @Override
    public int optionInt(String key) {
        return provider.optionInt(this, key);
    }

    @Override
    public int optionInt(String key, int def) {
        return provider.optionInt(this, key, def);
    }

    @Override
    public double optionDouble(String key) {
        return provider.optionDouble(this, key);
    }

    @Override
    public double optionDouble(String key, double def) {
        return provider.optionDouble(this, key, def);
    }

    @Override
    public String optionString(String key) {
        return provider.optionString(this, key);
    }

    @Override
    public String optionString(String key, String def) {
        return provider.optionString(this, key, def);
    }

    @Override
    public List<String> optionStringList(String key) {
        return provider.optionStringList(this, key);
    }

    @Override
    public Map<String, Object> optionMap(String key) {
        return provider.optionMap(this, key);
    }

    public static class CustomManaAbilityBuilder {

        private final NamespacedId id;
        @Nullable
        private String displayName;
        @Nullable
        private String description;

        public CustomManaAbilityBuilder(NamespacedId id) {
            this.id = id;
        }

        public CustomManaAbilityBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public CustomManaAbilityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CustomManaAbility build() {
            return new CustomManaAbility(id, displayName, description);
        }

    }

}
