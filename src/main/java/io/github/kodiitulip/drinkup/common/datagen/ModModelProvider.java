package io.github.kodiitulip.drinkup.common.datagen;

import io.github.kodiitulip.drinkup.common.block.BarleyCropBlock;
import io.github.kodiitulip.drinkup.common.block.GrapeCropBlock;
import io.github.kodiitulip.drinkup.common.init.ModBlocks;
import io.github.kodiitulip.drinkup.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Models;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerCrop(
			ModBlocks.GRAPE_CROP, GrapeCropBlock.AGE, 0, 1, 2, 3);
		blockStateModelGenerator.registerCrop(
			ModBlocks.BARLEY_CROP, BarleyCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {

		itemModelGenerator.register(ModItems.GRAPE, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ModItems.BARLEY, Models.SINGLE_LAYER_ITEM);

	}
}
