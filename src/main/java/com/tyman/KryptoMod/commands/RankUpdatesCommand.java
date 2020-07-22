package com.tyman.KryptoMod.commands;

import java.io.IOException;
import java.net.URI;

import com.tyman.KryptoMod.KryptoMod;
import com.tyman.KryptoMod.utils.FetchRankUpdatesThread;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class RankUpdatesCommand extends CommandBase {

	KryptoMod kryptomod;

    public RankUpdatesCommand(KryptoMod kryptomod) {
        this.kryptomod = kryptomod;
    }

    @Override
    public String getCommandName() {
        return "kranks";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "kranks";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[KryptoMod] Usage is /kranks"));
            return;
        } else {
           //execute user fetching procedure
        	//FetchRankUpdatesThread.main(iCommandSender);
        	// open the web page for now because it is way too long sometimes
        	iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[KryptoMod] Opening webpage..."));
        	URI uri = URI.create("http://kryptoguildapi.azurewebsites.net/ranks");
        	try {
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }


}