package com.tyman.KryptoMod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FetchRankUpdatesThread implements Runnable {
	static ICommandSender iCommandSender = null;
	public void run(){  
		iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[KryptoMod] Fetching data for all guild members..."));
        String response = HttpRequest.get("https://detonatorapi.glitch.me/ranks").body();
        iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[KryptoMod] " + response));
	}
	public static void main(ICommandSender iiCommandSender){
		iCommandSender = iiCommandSender;
	    FetchRankUpdatesThread obj=new FetchRankUpdatesThread();  
	    Thread tobj =new Thread(obj);  
	    tobj.start();
	} 
}
