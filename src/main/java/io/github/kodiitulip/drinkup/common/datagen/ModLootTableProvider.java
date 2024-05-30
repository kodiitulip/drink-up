package io.github.kodiitulip.drinkup.common.datagen;

import io.github.kodiitulip.drinkup.common.block.BarleyCropBlock;
import io.github.kodiitulip.drinkup.common.block.GrapeCropBlock;
import io.github.kodiitulip.drinkup.common.init.ModBlocks;
import io.github.kodiitulip.drinkup.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

	public ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {

		BlockStatePropertyLootCondition.Builder barley_builder = BlockStatePropertyLootCondition.builder(
			ModBlocks.BARLEY_CROP).properties(StatePredicate.Builder.create()
				.exactMatch(BarleyCropBlock.AGE, 7));
		add(ModBlocks.BARLEY_CROP, cropDrops(ModBlocks.BARLEY_CROP,
			ModItems.BARLEY, ModItems.BARLEY_SEEDS, barley_builder));

		BlockStatePropertyLootCondition.Builder grape_builder = BlockStatePropertyLootCondition.builder(
			ModBlocks.GRAPE_CROP).properties(StatePredicate.Builder.create()
				.exactMatch(GrapeCropBlock.AGE, 3));
		add(ModBlocks.GRAPE_CROP, cropDrops(ModBlocks.GRAPE_CROP,
			ModItems.GRAPE, ModItems.GRAPE_SEEDS, grape_builder));
	}
}
