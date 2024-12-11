package com.linnett.fight_and_flame.mixin.entity;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin {

    @Unique
    private static final List<String> CAPE_LEGENDARY = Arrays.asList("Linnett", "Dev");
    @Unique
    private static final List<String> CAPE_DEV = Arrays.asList("SpaceWalrus5000", "LoonLord32");
    @Unique
    private static final List<String> CAPE_MEMBER = Arrays.asList("_Brunaxx_13", "MelNet135", "BigNosey", "P1R0G0K", "Samusquinha", "GingleGorf", "Tim_s_keks", "Profitious", " ProfitiousXD", "Ecli_", "TheTrueZeraora8", "Natsirt10", "Shrumpdugs_hero", "Anime6374" ,"VeryWrong182", "uertyk_", "svk0qq");
    @Unique
    private static final List<String> CAPE_MEDNIK = Arrays.asList("MedNik0_0");
    @Unique
    private static final List<String> CAPE_DETOUR = Arrays.asList("lixir_guy");
    @Unique
    private static final List<String> CAPE_PAKETOV = Arrays.asList("Paketov");
    @Unique
    private static final List<String> CAPE_ORANGE = Arrays.asList("Orange");

    @Shadow
    @Nullable
    protected abstract PlayerInfo getPlayerInfo();

    @Inject(
            method = "getCloakTextureLocation",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void faf$getCustomCapeTexture(CallbackInfoReturnable<ResourceLocation> cir) {
        PlayerInfo playerInfo = this.getPlayerInfo();

        if (playerInfo == null || playerInfo.getProfile() == null || playerInfo.getProfile().getName() == null) {
            return;
        }

        String playerName = playerInfo.getProfile().getName();

        if (CAPE_LEGENDARY.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/legendary_cape.png"));
        } else if (CAPE_MEDNIK.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/mednik_cape.png"));
        } else if (CAPE_MEMBER.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/member_cape.png"));
        } else if (CAPE_DEV.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/dev_cape.png"));
        } else if (CAPE_DETOUR.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/detour_cape.png"));
        } else if (CAPE_PAKETOV.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/paketov_cape.png"));
        } else if (CAPE_ORANGE.contains(playerName)) {
            cir.setReturnValue(new ResourceLocation(FightAndFlame.MOD_ID, "textures/entity/cape/orange_cape.png"));
        }
    }
}


