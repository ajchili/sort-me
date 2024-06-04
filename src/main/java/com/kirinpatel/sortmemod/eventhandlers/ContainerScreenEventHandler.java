package com.kirinpatel.sortmemod.eventhandlers;

import java.util.stream.Collectors;

import com.kirinpatel.sortmemod.SortMeMod;
import com.kirinpatel.sortmemod.network.PacketHandler;
import com.kirinpatel.sortmemod.network.messages.SortMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ContainerScreenEventHandler {

	@SubscribeEvent
	public void onScreenKeyPressedEvent(ScreenEvent.KeyPressed event) {
		Player player = Minecraft.getInstance().player;
		// ClientPacketListener connection = Minecraft.getInstance().getConnection();
		if (player == null) {
			return;
		} else if (!player.hasContainerOpen()) {
			return;
		}

		int pressedKeycode = event.getKeyCode();
		AbstractContainerMenu containerMenu = player.containerMenu;
		String output = player.getInventory().items
				.parallelStream()
				.map(slot -> slot.getItem().toString())
				.collect(Collectors.joining(", "));
		System.out.println(output);

		// connection.send(null);
		PacketHandler.sendPacketToServer(new SortMessage());
	}
}
