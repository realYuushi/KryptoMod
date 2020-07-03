package com.tyman.DetonatorMod;

import com.tyman.DetonatorMod.commands.SetupAPIKeyCommand;
import com.tyman.DetonatorMod.commands.ViewStatsCommand;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Mod(modid = DetonatorMod.MODID, name= DetonatorMod.MOD_NAME, version = DetonatorMod.VERSION)
public class DetonatorMod
{
    public static final String MODID = "skyblockstatistics";
    public static final String MOD_NAME = "SkyblockStatistics";
    public static final String VERSION = "1.1.0";

    public static String SB_API_KEY = "";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        this.loadAPIKey();
        ClientCommandHandler.instance.registerCommand(new ViewStatsCommand(this));
        ClientCommandHandler.instance.registerCommand(new SetupAPIKeyCommand(this));
    }

    private void loadAPIKey() {
        File apiFile = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/sbapikey.config");
        if(apiFile.exists()) {
            try {
                String content = new Scanner(apiFile).useDelimiter("\\Z").next();
                if(! content.isEmpty()) {
                    SB_API_KEY = content;
                }
            } catch(FileNotFoundException e) {

            }
        }

    }

    public String getApiKey() {
        return SB_API_KEY;
    }

    public void setApiKey(String key) {
        SB_API_KEY = key;
    }

}
