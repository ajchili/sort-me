package com.kirinpatel.sortmemod.eventhandlers;

import com.kirinpatel.sortmemod.SortMeMod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid=SortMeMod.MODID, bus=Bus.FORGE, value=Dist.CLIENT)
public class TestHandler {

	@SubscribeEvent
	public static void eventHandler(EntityItemPickupEvent event) {
		System.out.println(event.getEntity().getScoreboardName() + " has picked up " + event.getItem().getName());
	}
}
