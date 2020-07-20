package com.tyman.KryptoMod.commands;

import com.tyman.KryptoMod.KryptoMod;
import com.tyman.KryptoMod.utils.FetchPlayerDataThread;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ViewStatsCommand extends CommandBase {

	KryptoMod kryptomod;

    public ViewStatsCommand(KryptoMod kryptomod) {
        this.kryptomod = kryptomod;
    }

    @Override
    public String getCommandName() {
        return "kstats";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "kstats <username>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(strings.length < 1 || strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[KryptoMod] Usage is /kstats <username>"));
            return;
        } else {
           //execute user fetching procedure
        	FetchPlayerDataThread.main(iCommandSender, strings);
        }
    }


}
