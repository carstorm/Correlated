package com.elytradev.correlated.block.item;

import java.util.List;

import com.elytradev.correlated.Correlated;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMemoryBay extends ItemBlock {

	public ItemBlockMemoryBay(Block block) {
		super(block);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("tooltip.correlated.energy_usage", Correlated.inst.memoryBayPUsage, Correlated.inst.preferredUnit.abbreviation));
	}

}
