package com.kirinpatel.sortmemod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SortMeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

	private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
			.comment("Whether to log the dirt block on common setup")
			.define("logDirtBlock", true);

	static final ForgeConfigSpec SPEC = BUILDER.build();

	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		LOG_DIRT_BLOCK.get();
	}
}
