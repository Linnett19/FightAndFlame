package com.linnett.fight_and_flame.items;

import com.linnett.fight_and_flame.FightAndFlame;
import com.linnett.fight_and_flame.block.FaFBlocks;
import com.linnett.fight_and_flame.items.custom_items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class FaFItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, FightAndFlame.MOD_ID);


    public static final Rarity RARITY_SCARY = Rarity.create("fight_and_flame:scary",
            style -> style.withColor(Color.HSBtoRGB(0.33f, 1f, (float) (0.7 + 0.3 * Math.sin(System.currentTimeMillis() / 500.0)))));


    public static final Rarity RARITY_RAINBOW = Rarity.create("fight_and_flame:rainbow",
            style -> style.withColor(Color.HSBtoRGB((System.currentTimeMillis() % 10000) / 10000F, 0.8f, 1f)));


    public static final Rarity RARITY_FIRE = Rarity.create("fight_and_flame:fire",
            style -> {
                float hue = 0.05f + (float)(0.05 * Math.sin(System.currentTimeMillis() / 300.0));
                return style.withColor(Color.HSBtoRGB(hue, 1f, 1f));
            });


    public static final Rarity RARITY_PLANT = Rarity.create("fight_and_flame:plant",
            style -> {
                float hue = 0.33f;
                float brightness = 0.4f + 0.6f * (float)(Math.sin(System.currentTimeMillis() / 300.0) * 0.5 + 0.5);
                return style.withColor(Color.HSBtoRGB(hue, 1f, brightness));
            });



    public static final Rarity RARITY_WATER = Rarity.create("fight_and_flame:water",
            style -> {
                float hue = 0.60f + (float)(0.02 * Math.sin(System.currentTimeMillis() / 300.0));
                return style.withColor(Color.HSBtoRGB(hue, 1f, 1f));
            });


    public static final Rarity RARITY_BLOOD = Rarity.create("fight_and_flame:blood",
            style -> {
                float brightness = (float) (0.8 + 0.2 * Math.sin(System.currentTimeMillis() / 500.0));
                return style.withColor(Color.HSBtoRGB(0f, 1f, brightness));
            });


    public static final Rarity RARITY_ELECTRIC = Rarity.create("fight_and_flame:electric",
            style -> {
                float saturation = (float)(0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 100.0));
                return style.withColor(Color.HSBtoRGB(0.75f, saturation, 1f));
            });


    public static final Rarity RARITY_ABYSSAL = Rarity.create("fight_and_flame:abyssal",
            style -> {
                float progress = (System.currentTimeMillis() % 5000) / 5000f;
                float hue = 0.8f + (float)Math.sin(progress * Math.PI * 2) * 0.05f;
                float saturation = 0.7f + Math.abs((float)Math.sin(progress * Math.PI * 2)) * 0.3f;
                float brightness = 0.2f + Math.abs((float)Math.sin(progress * Math.PI * 2)) * 0.8f;
                return style.withColor(Color.HSBtoRGB(hue, saturation, brightness));
            });


    public static final Rarity RARITY_AIR = Rarity.create("fight_and_flame:air",
            style -> {
                float progress = (System.currentTimeMillis() % 7000) / 7000f;
                float hue = 0.55f;
                float saturation = 0.05f + Math.abs((float)Math.sin(progress * Math.PI * 2)) * 0.2f;
                float brightness = 1f - Math.abs((float)Math.sin(progress * Math.PI * 2)) * 0.5f;
                return style.withColor(Color.HSBtoRGB(hue, saturation, brightness));
            });

    public static final Rarity RARITY_STAR = Rarity.create("fight_and_flame:star",
            style -> {
                float progress = (float) (Math.sin(System.currentTimeMillis() / 500.0) * 0.5 + 0.5);
                float hue = 0.167f * progress;
                float saturation = progress;
                return style.withColor(Color.HSBtoRGB(hue, saturation, 1f));
            });






    public static final RegistryObject<Item> BLANK_BLUEPRINT = ITEM.register("blank_blueprint",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PYROCLASTITE = ITEM.register("pyroclastite",
            () -> new Item(new Item.Properties().rarity(RARITY_FIRE)));

    public static final RegistryObject<Item> HARMONITE = ITEM.register("harmonite",
            () -> new Item(new Item.Properties().rarity(RARITY_WATER)));

    public static final RegistryObject<Item> FLORAMBER = ITEM.register("floramber",
            () -> new Item(new Item.Properties().rarity(RARITY_PLANT)));

    public static final RegistryObject<Item> VOLTINITE = ITEM.register("voltinite",
            () -> new Item(new Item.Properties().rarity(RARITY_ELECTRIC)));

    public static final RegistryObject<Item> AEROGEL = ITEM.register("aerogel",
            () -> new Item(new Item.Properties().rarity(RARITY_AIR)));

    public static final RegistryObject<Item> SANGUINITE = ITEM.register("sanguinite",
            () -> new Item(new Item.Properties().rarity(RARITY_BLOOD)));

    public static final RegistryObject<Item> ABYSSNESS = ITEM.register("abyssness",
            () -> new Item(new Item.Properties().rarity(RARITY_ABYSSAL)));

    public static final RegistryObject<Item> OMNIGEM = ITEM.register("omnigem",
            () -> new Item(new Item.Properties().rarity(RARITY_RAINBOW)));

    public static final RegistryObject<Item> STELLARITE = ITEM.register("stellarite",
            () -> new Item(new Item.Properties().rarity(RARITY_STAR)));

    public static final RegistryObject<Item> MAGIC_STICK = ITEM.register("magic_stick",
            () -> new MagicStick(new Item.Properties().rarity(RARITY_RAINBOW)));

    public static final RegistryObject<Item> FORCE_MOKTEL = ITEM.register("force_moktel",
            () -> new ForceInfusion(new Item.Properties()));

    public static final RegistryObject<Item> JUMP_MOKTEL = ITEM.register("jump_moktel",
            () -> new JumpInfusion(new Item.Properties()));

    public static final RegistryObject<Item> SPEED_MOKTEL = ITEM.register("speed_moktel",
            () -> new SpeedInfusion(new Item.Properties()));

    public static final RegistryObject<Item> BURST_MOKTEL = ITEM.register("burst_moktel",
            () -> new BurstInfusion(new Item.Properties().rarity(RARITY_PLANT)));


    public static final RegistryObject<Item> BOTTLE = ITEM.register("bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CYLINDRICAL_GLASS = ITEM.register("cylindrical_glass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DISTORTED_GLASS = ITEM.register("distorted_glass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRIANGULAR_GLASS = ITEM.register("triangular_glass",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> IRON_BROADSWORD = ITEM.register("iron_broadsword",
            () -> new Broadsword(Tiers.IRON, 6, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SPEAR = ITEM.register("iron_spear",
            () -> new SwordWeapon(Tiers.IRON, 3, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SCYTHE = ITEM.register("iron_scythe",
            () -> new SwordWeapon(Tiers.IRON, 4, -2.5F, new Item.Properties()));

    public static final RegistryObject<Item> IRON_RAPIER = ITEM.register("iron_rapier",
            () -> new SwordWeapon(Tiers.IRON, 1, -1.5F, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SICKLE = ITEM.register("iron_sickle",
            () -> new SwordWeapon(Tiers.IRON, 1, -1.8F, new Item.Properties()));



    public static final RegistryObject<Item> GOLDEN_BROADSWORD = ITEM.register("golden_broadsword",
            () -> new Broadsword(Tiers.GOLD, 4, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_SPEAR = ITEM.register("golden_spear",
            () -> new SwordWeapon(Tiers.GOLD, 2, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_SCYTHE = ITEM.register("golden_scythe",
            () -> new SwordWeapon(Tiers.GOLD, 3, -2.5F, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_RAPIER = ITEM.register("golden_rapier",
            () -> new SwordWeapon(Tiers.GOLD, 1, -1.5F, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_SICKLE = ITEM.register("golden_sickle",
            () -> new SwordWeapon(Tiers.GOLD, 1, -1.8F, new Item.Properties()));



    public static final RegistryObject<Item> DIAMOND_BROADSWORD = ITEM.register("diamond_broadsword",
            () -> new Broadsword(Tiers.DIAMOND, 7, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SPEAR = ITEM.register("diamond_spear",
            () -> new SwordWeapon(Tiers.DIAMOND, 4, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SCYTHE = ITEM.register("diamond_scythe",
            () -> new SwordWeapon(Tiers.DIAMOND, 5, -2.5F, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_RAPIER = ITEM.register("diamond_rapier",
            () -> new SwordWeapon(Tiers.DIAMOND, 1, -1.5F, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SICKLE = ITEM.register("diamond_sickle",
            () -> new SwordWeapon(Tiers.DIAMOND, 1, -1.8F, new Item.Properties()));



    public static final RegistryObject<Item> NETHERITE_BROADSWORD = ITEM.register("netherite_broadsword",
            () -> new Broadsword(Tiers.NETHERITE, 8, -3.5F, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SPEAR = ITEM.register("netherite_spear",
            () -> new SwordWeapon(Tiers.NETHERITE, 5, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SCYTHE = ITEM.register("netherite_scythe",
            () -> new SwordWeapon(Tiers.NETHERITE, 6, -2.5F, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_RAPIER = ITEM.register("netherite_rapier",
            () -> new SwordWeapon(Tiers.NETHERITE, 2, -1.5F, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SICKLE = ITEM.register("netherite_sickle",
            () -> new SwordWeapon(Tiers.NETHERITE, 1, -1.8F, new Item.Properties()));


    public static final RegistryObject<Item> HORRIBLE_SIGN = ITEM.register("horrible_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), FaFBlocks.HORRIBLE_SIGN.get(), FaFBlocks.HORRIBLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> HORRIBLE_HANGING_SIGN = ITEM.register("horrible_hanging_sign",
            () -> new HangingSignItem(FaFBlocks.HORRIBLE_HANGING_SIGN.get(), FaFBlocks.HORRIBLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CAULDRON_ITEM = ITEM.register("cauldron_item",
            () -> new ItemNameBlockItem(FaFBlocks.CAULDRON.get(), new Item.Properties().rarity(RARITY_SCARY)));

    public static final RegistryObject<Item> CANDI_CORN = ITEM.register("candi_corn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLIME_LOLIPOP = ITEM.register("slime_lolipop",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUR_BONE = ITEM.register("sour_bone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JELLY_BALLS = ITEM.register("jelly_balls",
            () -> new Item(new Item.Properties()));










    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
