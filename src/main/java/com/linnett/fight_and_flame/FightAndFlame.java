package com.linnett.fight_and_flame;

import com.linnett.fight_and_flame.block.FaFBlocks;
import com.linnett.fight_and_flame.block.entity.BlockEntities;
import com.linnett.fight_and_flame.entity.FaFEntityRegistry;
import com.linnett.fight_and_flame.events.FaFClientEvents;
import com.linnett.fight_and_flame.events.FaFEvents;
import com.linnett.fight_and_flame.items.FaFCreativeTabs;
import com.linnett.fight_and_flame.items.FaFItems;
import com.linnett.fight_and_flame.particles.FaFParticlesRegistry;
import com.linnett.fight_and_flame.sounds.FaFSounds;
import com.linnett.fight_and_flame.worldgen.wood.FaFWoodTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FightAndFlame.MOD_ID)
public class FightAndFlame {

     public static final String MOD_ID = "fight_and_flame";
     private static final Logger LOGGER = LogUtils.getLogger();
    public FightAndFlame() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        
        
        FaFCreativeTabs.register(modEventBus);
        FaFItems.register(modEventBus);
        FaFBlocks.register(modEventBus);
        FaFParticlesRegistry.register(modEventBus);
        FaFSounds.SOUND_EVENT.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        BlockEntities.BLOCK_ENTITIES.register(modEventBus);

        FaFEntityRegistry.DEF_REG.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new FaFClientEvents());

        modEventBus.addListener(this::addCreative);
        FaFEvents.register();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

        LOGGER.info("HELLO from server starting");
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(FaFWoodTypes.HORRIBLE);

            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
