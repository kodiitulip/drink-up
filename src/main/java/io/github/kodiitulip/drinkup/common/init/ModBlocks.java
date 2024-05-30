package io.github.kodiitulip.drinkup.common.init;

import io.github.kodiitulip.drinkup.common.block.BarleyCropBlock;
import io.github.kodiitulip.drinkup.common.block.GrapeCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlocks {

	Map<Block, String> BLOCKS = new LinkedHashMap<>();

	Block GRAPE_CROP = createBlock(
		"grape_crop",
		new GrapeCropBlock(
			QuiltBlockSettings.copyOf(Blocks.WHEAT)
		)
	);
	Block BARLEY_CROP = createBlock(
		"barley_crop",
		new BarleyCropBlock(
			QuiltBlockSettings.copyOf(Blocks.WHEAT)
		)
	);

	private static <T extends Block> T createBlock(String name, T block) {
		return createBlock(name, block, false);
	}

	private static <T extends Block> T createBlock(String name, T block, boolean createItem) {
		BLOCKS.put(block, name);
		if (createItem) {
			ModItems.ITEMS.put(new BlockItem(block, new QuiltItemSettings()), BLOCKS.get(block));
		}
		return block;
	}

	static void initialize(ModContainer mod) {
		BLOCKS.keySet().forEach(block -> Registry.register(
			Registries.BLOCK, new Identifier(mod.metadata().id(), BLOCKS.get(block)),block));
	}
}
