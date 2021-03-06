package com.elytradev.correlated.network;

import com.elytradev.correlated.Correlated;
import com.elytradev.correlated.inventory.ContainerAutomaton;

import com.elytradev.concrete.Message;
import com.elytradev.concrete.NetworkContext;
import com.elytradev.concrete.annotation.field.MarshalledAs;
import com.elytradev.concrete.annotation.type.ReceivedOn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.relauncher.Side;

@ReceivedOn(Side.SERVER)
public class SetAutomatonNameMessage extends Message {
	@MarshalledAs("i32")
	public int windowId;
	public String name;

	public SetAutomatonNameMessage(NetworkContext ctx) {
		super(ctx);
	}
	public SetAutomatonNameMessage(int windowId, String name) {
		super(Correlated.inst.network);
		this.windowId = windowId;
		this.name = name;
	}

	@Override
	protected void handle(EntityPlayer sender) {
		Container c = ((EntityPlayerMP)sender).openContainer;
		if (c instanceof ContainerAutomaton && c.windowId == windowId) {
			((ContainerAutomaton)c).automaton.setCustomNameTag(name);
		}
	}

}
