package com.tyman.DetonatorMod;

import com.tyman.DetonatorMod.commands.ViewStatsCommand;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = DetonatorMod.MODID, name= DetonatorMod.MOD_NAME, version = DetonatorMod.VERSION)
public class DetonatorMod
{
    public static final String MODID = "detonatormod";
    public static final String MOD_NAME = "DetonatorMod";
    public static final String VERSION = "BETA-0.0.2";

    public static String API_KEY = "";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new ViewStatsCommand(this));
    }

}
