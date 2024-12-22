package com.linnett.fight_and_flame.sounds;

import com.linnett.fight_and_flame.FightAndFlame;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FaFSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, FightAndFlame.MOD_ID);


    public static final RegistryObject<SoundEvent> MAGIC = createSoundEvent("magic");

    
    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return SOUND_EVENT.register(soundName, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FightAndFlame.MOD_ID, soundName)));
    }
}

