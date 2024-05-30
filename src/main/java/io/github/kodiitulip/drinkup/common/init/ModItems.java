package io.github.kodiitulip.drinkup.common.init;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModItems {
	Map<Item, String> ITEMS = new LinkedHashMap<>();

	Item GRAPE = createItem(
		"grape",
		new Item(new QuiltItemSettings()
			.food(FoodComponents.SWEET_BERRIES))
	);
	Item GRAPE_SEEDS = createItem(
		"grape_seeds",
		new AliasedBlockItem(ModBlocks.GRAPE_CROP, new QuiltItemSettings())
	);
	Item BARLEY = createItem(
		"barley",
		new Item(new QuiltItemSettings())
	);
	Item BARLEY_SEEDS = createItem(
		"barley_seeds",
		new AliasedBlockItem(ModBlocks.BARLEY_CROP, new QuiltItemSettings())
	);

	private static <T extends Item> T createItem(String name, T item) {
		ITEMS.put(item, name);
		return item;
	}

	static void initialize(ModContainer mod) {
		ITEMS.keySet().forEach(item -> Registry.register(
			Registries.ITEM, new Identifier(mod.metadata().id(), ITEMS.get(item)), item));
	}
}
