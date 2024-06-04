package com.kirinpatel.sortmemod.network;

import com.kirinpatel.sortmemod.SortMeMod;
import com.kirinpatel.sortmemod.network.messages.SortMessage;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class PacketHandler {

	private static final SimpleChannel INSTANCE = ChannelBuilder
			.named(new ResourceLocation(SortMeMod.MODID, "main"))
			.serverAcceptedVersions((status, version) -> true)
			.clientAcceptedVersions((status, version) -> true)
			.networkProtocolVersion(1)
			.simpleChannel();

	public static void register() {
		INSTANCE.messageBuilder(SortMessage.class, NetworkDirection.PLAY_TO_SERVER)
			.encoder(SortMessage::encode)
			.decoder(SortMessage::new)
			.consumerMainThread(SortMessage::handle)
			.add();
	}

	public static void sendPacketToServer(Object packet) {
		INSTANCE.send(packet, PacketDistributor.SERVER.noArg());
	}
}
