package com.tyman.KryptoMod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FetchPlayerDataThread implements Runnable {
	static ICommandSender iCommandSender = null;
	static String[] strings;
	public void run(){  
		iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[KryptoMod] Fetching data for user " + strings[0] + "..."));
        String response = HttpRequest.get("http://kryptoguildapi.azurewebsites.net/?name="+strings[0]).body();
        if (response.contains("Error")) {
        	iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[KryptoMod]" + response));
        }
        else {
        	iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[KryptoMod]" + response));
        }
	}
	public static void main(ICommandSender iiCommandSender, String[] stringss){
		iCommandSender = iiCommandSender;
		strings = stringss;
	    FetchPlayerDataThread obj=new FetchPlayerDataThread();  
	    Thread tobj =new Thread(obj);  
	    tobj.start();
	} 
}
