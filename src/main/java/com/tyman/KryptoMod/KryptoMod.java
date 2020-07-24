package com.tyman.KryptoMod;

import com.tyman.KryptoMod.commands.RankUpdatesCommand;
import com.tyman.KryptoMod.commands.ViewStatsCommand;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = KryptoMod.MODID, name= KryptoMod.MOD_NAME, version = KryptoMod.VERSION, updateJSON = "https://raw.githubusercontent.com/Tymanyay/KryptoMod/master/update.json")
public class KryptoMod
{
    public static final String MODID = "kryptomod";
    public static final String MOD_NAME = "KryptoMod";
    public static final String VERSION = "0.0.7-beta";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ClientCommandHandler.instance.registerCommand(new ViewStatsCommand(this));
    	ClientCommandHandler.instance.registerCommand(new RankUpdatesCommand(this));
    }

}
