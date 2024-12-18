package com.linnett.fight_and_flame.networking;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.networking.packets.ParticlesS2Cpacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }
    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(FightAndFlame.MOD_ID,"messages")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();
        INSTANCE = net;
        net.messageBuilder(ParticlesS2Cpacket.class,id(), NetworkDirection.PLAY_TO_CLIENT).decoder(ParticlesS2Cpacket::new).encoder(ParticlesS2Cpacket::write).consumerMainThread(ParticlesS2Cpacket::handle).add();

    }
    public static <MSG> void sendToServer(MSG message)
    {
        INSTANCE.sendToServer(message);
    }
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(()->player), message);
    }
}