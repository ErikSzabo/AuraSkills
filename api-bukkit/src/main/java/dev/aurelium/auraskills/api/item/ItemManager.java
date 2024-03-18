package dev.aurelium.auraskills.api.item;

import dev.aurelium.auraskills.api.skill.Multiplier;
import dev.aurelium.auraskills.api.skill.Skill;
import dev.aurelium.auraskills.api.skill.Skills;
import dev.aurelium.auraskills.api.stat.Stat;
import dev.aurelium.auraskills.api.stat.StatModifier;
import dev.aurelium.auraskills.api.stat.Stats;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public interface ItemManager {

    /**
     * Adds a modifier to an item, with optional lore. This does not change the item passed in directly,
     * you must use the returned ItemStack. This means the original ItemStack passed in is not changed at all, a new
     * one is created.
     *
     * @param item the original item, will not be changed by the method
     * @param type the {@link ModifierType} to add
     * @param stat the stat to add (Use {@link Stats} enum for default stats)
     * @param value the value of the stat to add
     * @param lore whether to add lore
     * @return a new ItemStack with the modifier
     */
    ItemStack addModifier(ItemStack item, ModifierType type, Stat stat, double value, boolean lore);

    /**
     * Gets a list of stat modifiers on an item for a given modifier type.
     *
     * @param item the item to get the modifiers of
     * @param type the modifier type
     * @return a list of modifiers
     */
    List<StatModifier> getModifiers(ItemStack item, ModifierType type);

    /**
     * Removes a modifier from an item for a given modifier type and stat.
     * Does not modify the ItemStack passed in, instead returns a copy of the item with the
     * modifier removed. Will not remove any lore.
     *
     * @param item The item to remove the modifier from. Does not get modified.
     * @param type the modifier type
     * @param stat the stat of the modifier to remove
     * @return the item with the modifier removed
     */
    ItemStack removeModifier(ItemStack item, ModifierType type, Stat stat);

    /**
     * Adds a multiplier to an item, with optional lore. This does not change the item passed in directly,
     * you must use the returned ItemStack. This means the original ItemStack passed in is not changed at all, a new
     * one is created.
     *
     * @param item the original item, will not be changed by the method
     * @param type the {@link ModifierType} to add
     * @param skill the skill to add (Use {@link Skills} enum for default skills)
     * @param value the value of the multiplier (in percentage points) to add
     * @param lore whether to add lore
     * @return a new ItemStack with the multiplier
     */
    ItemStack addMultiplier(ItemStack item, ModifierType type, Skill skill, double value, boolean lore);

    /**
     * Gets a list of skill multipliers on an item for a given modifier type.
     *
     * @param item the item to get the multipliers of
     * @param type the modifier type
     * @return a list of multipliers
     */
    List<Multiplier> getMultipliers(ItemStack item, ModifierType type);

    /**
     * Removes a multiplier from an item for the given skill. Does not modify the item, instead returns
     * a copy with the multiplier removed. Will not remove any lore.
     *
     * @param item item to remove the multiplier from
     * @param type the type of modifier
     * @param skill the skill of the multiplier to remove, or null for global multipliers
     * @return the modified item with the multiplier removed
     */
    ItemStack removeMultiplier(ItemStack item, ModifierType type, Skill skill);

    /**
     * Adds a skill requirement to use an item, with optional lore. This does not change the item passed in
     * directly, you must use the returned ItemStack. This means the original ItemStack passed in is not changed at all, a new
     * one is created.
     *
     * @param item the original item, will not be changed by the method
     * @param type the {@link ModifierType} to add
     * @param skill the skill the requirement is for (Use {@link Skills} enum for default skills)
     * @param level the skill level required to use the item
     * @param lore whether to add lore
     * @return a new ItemStack with the requirement
     */
    ItemStack addRequirement(ItemStack item, ModifierType type, Skill skill, int level, boolean lore);

    /**
     * Gets the skill requirements for an item.
     *
     * @param item the item to get the requirements of
     * @param type the modifier type
     * @return a map of skill requirements, where the key is the skill and the level requirements is the value
     */
    Map<Skill, Integer> getRequirements(ItemStack item, ModifierType type);

    /**
     * Removes a skill requirement from an item. Does not modify the item, instead returns a copy of the
     * item with the requirement removed. Does not modify lore.
     *
     * @param item the item to remove the requirement from
     * @param type the modifier type
     * @param skill the skill of the requirement to remove
     * @return the modified item with the requirement removed
     */
    ItemStack removeRequirement(ItemStack item, ModifierType type, Skill skill);

}
