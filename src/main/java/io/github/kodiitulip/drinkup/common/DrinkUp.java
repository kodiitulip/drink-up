package io.github.kodiitulip.drinkup.common;

import io.github.kodiitulip.drinkup.common.init.ModBlocks;
import io.github.kodiitulip.drinkup.common.init.ModItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrinkUp implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Drink Up");

    @Override
    public void onInitialize(ModContainer mod) {

		ModBlocks.initialize(mod);
		ModItems.initialize(mod);

        LOGGER.info("Its time to {}! Stay Hydrated!", mod.metadata().name());
    }
}
