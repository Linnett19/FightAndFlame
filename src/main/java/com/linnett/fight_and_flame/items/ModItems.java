package com.linnett.fight_and_flame.items;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.ModBlocks;
import com.linnett.fight_and_flame.items.custom_items.SwordWeapon;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, FightAndFlame.MOD_ID);

    public static final Rarity RARITY_SCARY = Rarity.create("fight_and_flame:scary", style -> style.withColor(Color.HSBtoRGB(0.33f, 1f, (float) (0.7 + 0.3 * Math.sin(System.currentTimeMillis() / 500.0)))));
    public static final Rarity RARITY_CANDY = Rarity.create("fight_and_flame:candy", style -> style.withColor(0Xff9800));
    public static final Rarity RARITY_RAINBOW = Rarity.create("fight_and_flame:rainbow", style -> style.withColor(Color.HSBtoRGB((System.currentTimeMillis() % 5000) / 5000F, 1f, 1F)));



    public static final RegistryObject<Item> BLANK_BLUEPRINT = ITEM.register("blank_blueprint",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_BROADSWORD = ITEM.register("iron_broadsword_item",
            () -> new SwordWeapon( Tiers.IRON, 6,-3F, new Item.Properties()));





    public static final RegistryObject<Item> HORRIBLE_SIGN = ITEM.register("horrible_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HORRIBLE_SIGN.get(), ModBlocks.HORRIBLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> HORRIBLE_HANGING_SIGN = ITEM.register("horrible_hanging_sign",
            () -> new HangingSignItem(ModBlocks.HORRIBLE_HANGING_SIGN.get(), ModBlocks.HORRIBLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CAULDRON_ITEM = ITEM.register("cauldron_item",
            () -> new ItemNameBlockItem(ModBlocks.CAULDRON.get(), new Item.Properties().rarity(RARITY_SCARY)));

    public static final RegistryObject<Item> CANDI_CORN = ITEM.register("candi_corn",
            () -> new Item(new Item.Properties().rarity(RARITY_CANDY)));

    public static final RegistryObject<Item> SLIME_LOLIPOP = ITEM.register("slime_lolipop",
            () -> new Item(new Item.Properties().rarity(RARITY_CANDY)));

    public static final RegistryObject<Item> SOUR_BONE = ITEM.register("sour_bone",
            () -> new Item(new Item.Properties().rarity(RARITY_CANDY)));

    public static final RegistryObject<Item> JELLY_BALLS = ITEM.register("jelly_balls",
            () -> new Item(new Item.Properties().rarity(RARITY_CANDY)));










    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
