package com.kirinpatel.sortmemod.network.messages;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class SortMessage {

	public SortMessage() {

	}

	public SortMessage(FriendlyByteBuf buffer) {
		this();
	}

	public void encode(FriendlyByteBuf buffer) {

	}

	public void handle(CustomPayloadEvent.Context context) {
		ServerPlayer player = context.getSender();
		player.getInventory().setItem(3, player.getInventory().items.get(0).copyAndClear());
	}
}
