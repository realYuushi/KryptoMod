package com.tyman.DetonatorMod.utils;

import io.github.reflxction.hypixelapi.HypixelAPI;
import io.github.reflxction.hypixelapi.guild.Guild;
import io.github.reflxction.hypixelapi.guild.GuildMember;
import io.github.reflxction.hypixelapi.player.HypixelPlayer;

import java.io.IOException;

import com.tyman.DetonatorMod.utils.DetonatorInfo;
import com.tyman.DetonatorMod.utils.FindMember;

public class PlayerGexpFetcher {
	
	public String getWeeklyGexp(String playerName) throws IOException {
		DetonatorInfo[] detonatorinfo;
		final HypixelAPI API = HypixelAPI.create("0263b520-7895-4f37-84c1-033d04bde642");
        String guildID = API.getGuildId("Detonator"); // The ID of the guild. This can be inputted in:
        Guild guild = API.getGuild(guildID); // Fetch the guild from the ID
        HypixelPlayer player = API.getPlayer(playerName);
        String memberUUID = player.getUUID().toString();
        GuildMember guildMember = FindMember.findMember(memberUUID, guild.getMembers());
        guildMember.
	}

}
