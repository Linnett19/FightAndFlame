package com.linnett.fight_and_flame.items;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class Moditems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, FightAndFlame.MOD_ID);

    public static final Rarity RARITY_SCARY = Rarity.create("fight_and_flame:green", style -> style.withColor(Color.HSBtoRGB(0.33f, 1f, (float)(0.7 + 0.3 * Math.sin(System.currentTimeMillis() / 500.0)))));
    public static final Rarity RARITY_CANDY = Rarity.create("fight_and_flame:candy", style -> style.withColor(0XFDDA86));
    public static final Rarity RARITY_RAINBOW = Rarity.create("fight_and_flame:rainbow", style -> style.withColor(Color.HSBtoRGB((System.currentTimeMillis() % 5000) / 5000F, 1f, 1F)));

    public static final RegistryObject<Item> BLANK_BLUEPRINT = ITEM.register("blank_blueprint",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_TORN = ITEM.register("blank_blueprint_torn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_TWOHANDED_SWORD = ITEM.register("blank_blueprint_twohanded_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_RAPIER = ITEM.register("blank_blueprint_rapier",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_SICKLE = ITEM.register("blank_blueprint_sickle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_BRAID = ITEM.register("blank_blueprint_braid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK_BLUEPRINT_SPEAR = ITEM.register("blank_blueprint_spear",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NEPHRITIS_INGOT = ITEM.register("nephritis_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NEPHRITIS_PIECES = ITEM.register("nephritis_pieces",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_NEPHRITIS = ITEM.register("raw_nephritis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_NETHERITE_INGOT = ITEM.register("awakened_netherite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AWAKENED_NETHERITE_PIECES = ITEM.register("awakened_netherite_pieces",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOOD_STONE_INGOT = ITEM.register("blood_stone_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_BLOOD_STONE = ITEM.register("raw_blood_stone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOOD_STONE_PIECES = ITEM.register("blood_stone_pieces",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> APHATIT_CRYSTAL = ITEM.register("aphatit_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> APHATIT_CRYSTAL_SPLINTER = ITEM.register("aphatit_crystal_splinter",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ELEMENTAL_CRYSTAL = ITEM.register("elemental_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CAULDRON_ITEM = ITEM.register("cauldron_item",
            () -> new ItemNameBlockItem(ModBlocks.CAULDRON.get(), new Item.Properties().rarity(RARITY_SCARY)));

    public static final RegistryObject<Item> CANDICORN = ITEM.register("candicorn",
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
