package dev.aurelium.auraskills.common.source.parser.util;

import dev.aurelium.auraskills.api.item.ItemCategory;
import dev.aurelium.auraskills.api.item.ItemFilterMeta;
import dev.aurelium.auraskills.api.item.LootItemFilter;
import dev.aurelium.auraskills.api.source.BaseContext;
import dev.aurelium.auraskills.api.source.UtilityParser;
import dev.aurelium.auraskills.common.item.LootSourceItem;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

public class LootItemFilterParser implements UtilityParser<LootItemFilter> {

    @Override
    public LootItemFilter parse(ConfigurationNode source, BaseContext context) throws SerializationException {
        String[] materials = context.pluralizedArray("material", source, String.class);
        String[] excludedMaterials = context.pluralizedArray("excluded_material", source, String.class);
        ItemCategory category = source.node("category").get(ItemCategory.class);
        String lootPool = source.node("loot_pool").getString();
        ItemFilterMeta meta = new ItemFilterMetaParser().parse(source, context);

        return new LootSourceItem(materials, excludedMaterials, category, meta, lootPool);
    }
}
