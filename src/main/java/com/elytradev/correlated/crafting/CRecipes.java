package com.elytradev.correlated.crafting;

import com.elytradev.correlated.Correlated;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CRecipes {

	public static void register() {
		ItemStack processor = new ItemStack(Correlated.misc, 1, 0);
		ItemStack drivePlatterCeramic = new ItemStack(Correlated.misc, 1, 1);
		ItemStack drivePlatterMetallic = new ItemStack(Correlated.misc, 1, 2);
		ItemStack luminousPearl = new ItemStack(Correlated.misc, 1, 3);
		ItemStack luminousTorch = new ItemStack(Correlated.misc, 1, 4);
		ItemStack dataCore = new ItemStack(Correlated.misc, 1, 8);

		String luminousPearlOrDataCore = "correlated:INTERNAL_luminousPearlOrDataCore";
		
		OreDictionary.registerOre(luminousPearlOrDataCore, luminousPearl);
		OreDictionary.registerOre(luminousPearlOrDataCore, dataCore);
		
		// 1MiB Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 0),
				"III",
				"IOI",
				"IoI",
				'I', "ingotIron",
				'O', luminousPearlOrDataCore,
				'o', drivePlatterCeramic
				));

		// 4MiB Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 1),
				"III",
				"oOo",
				"IoI",
				'I', "ingotIron",
				'O', luminousPearlOrDataCore,
				'o', drivePlatterCeramic
				));

		// 16MiB Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 2),
				"III",
				"dOd",
				"IoI",
				'I', "ingotIron",
				'd', "gemDiamond",
				'O', luminousPearlOrDataCore,
				'o', drivePlatterMetallic
				));
		// 64MiB Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 3),
				"doI",
				"oOo",
				"Iod",
				'd', "gemDiamond",
				'O', luminousPearlOrDataCore,
				'o', drivePlatterMetallic,
				'I', "ingotIron"
				));
		// 128MiB Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 5),
				"doo",
				"oOo",
				"ood",
				'd', "blockDiamond",
				'O', luminousPearlOrDataCore,
				'o', drivePlatterMetallic
				));

		// Void Drive
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.drive, 1, 4),
				"###",
				"#O#",
				"###",
				'O', luminousPearl,
				'#', Blocks.OBSIDIAN
				));

		
		// 1KiB Memory
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.memory, 1, 0),
				"iii",
				"gOg",
				'O', luminousPearl,
				'i', "ingotIron",
				'g', "ingotGold"
				));
		
		// 4KiB Memory
		GameRegistry.addRecipe(new DriveRecipe(new ItemStack(Correlated.memory, 1, 1),
				"iii",
				"dOd",
				'O', luminousPearl,
				'i', "ingotIron",
				'd', "gemDiamond"
				));
		
		

		// Enderic Processor
		if (Correlated.inst.easyProcessors) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.misc, 1, 0),
					"qdq",
					"gog",
					"qdq",
					'q', "gemQuartz",
					'g', "ingotGold",
					'd', "gemDiamond",
					'o', Items.ENDER_PEARL
					));
		} else {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.misc, 2, 0),
					"qoq",
					"gpg",
					"qdq",
					'q', "gemQuartz",
					'g', "ingotGold",
					'd', "gemDiamond",
					'p', processor,
					'o', Items.ENDER_PEARL
					));
		}

		// Luminous Pearl
		GameRegistry.addRecipe(new ShapelessOreRecipe(luminousPearl,
				Items.ENDER_PEARL, "dustGlowstone"));

		// Ceramic Drive Platter
		GameRegistry.addRecipe(new ShapedOreRecipe(drivePlatterCeramic,
				" B ",
				"BiB",
				" B ",
				'B', "ingotBrick",
				'i', "ingotIron"
				));

		// Metallic Drive Platter
		GameRegistry.addRecipe(new ShapedOreRecipe(drivePlatterMetallic,
				"ioi",
				"oIo",
				"ioi",
				'o', drivePlatterCeramic,
				'i', "ingotIron",
				'I', "blockIron"
				));

		// Drive Bay
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.drive_bay,
				"iii",
				" p ",
				"iii",
				'i', "ingotIron",
				'p', processor
				));
		
		// Memory Bay
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.memory_bay,
				"iii",
				"gpg",
				"iii",
				'i', "ingotIron",
				'p', processor,
				'g', "nuggetGold"
				));

		// Controller
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.controller,
				"ioi",
				"opo",
				"ioi",
				'i', "ingotIron",
				'p', processor,
				'o', luminousPearl
				));

		// Terminal
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.terminal,
				"iii",
				"ooo",
				"ipi",
				'i', "ingotIron",
				'p', processor,
				'o', luminousPearl
				));

		// Interface
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.iface,
				"igi",
				"gog",
				"igi",
				'i', "ingotIron",
				'g', "ingotGold",
				'o', luminousPearl
				));
		
		// Luminous Torch
		GameRegistry.addRecipe(new ShapedOreRecipe(luminousTorch,
				"o",
				"i",
				"i",
				'i', "ingotIron",
				'o', luminousPearl
				));
		
		// Microwave Beam
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.wireless, 1, 0),
				" | ",
				"___",
				"idi",
				'i', "ingotIron",
				'd', "gemDiamond",
				'|', luminousTorch,
				'_', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE
				));
		
		// Optical Receiver
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.wireless, 1, 1),
				"igi",
				"gpg",
				"igi",
				'i', "ingotIron",
				'p', luminousPearl,
				'g', "blockGlass"
				));
		
		// Beacon Lens
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.wireless, 1, 2),
				"ipi",
				"pgp",
				"ipi",
				'i', "ingotIron",
				'p', luminousPearl,
				'g', "paneGlass"
				));
		
		// Decorative Blocks
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.decor_block, 64, 7),
				"III",
				"IoI",
				"III",
				
				'I', "ingotIron",
				'o', luminousPearl));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.glowing_decor_block, 16, 4),
				"oo",
				"oo",
				
				'o', new ItemStack(Correlated.misc, 1, 5)));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.plating_stairs, 4),
				"#  ",
				"## ",
				"###",
				'#', new ItemStack(Correlated.decor_block, 1, 7)));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.plating_stairs, 4),
				"  #",
				" ##",
				"###",
				'#', new ItemStack(Correlated.decor_block, 1, 7)));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.decor_slab, 6, 7),
				"###",
				'#', new ItemStack(Correlated.decor_block, 1, 7)));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Correlated.glowing_decor_slab, 6, 4),
				"###",
				'#', new ItemStack(Correlated.glowing_decor_block, 1, 4)));
		
		// Wireless Terminal
		GameRegistry.addRecipe(new ShapelessOreRecipe(Correlated.wireless_terminal,
				Correlated.terminal
				));
		
		// Wireless Terminal back to Terminal
		GameRegistry.addRecipe(new ShapelessOreRecipe(Correlated.terminal,
				Correlated.wireless_terminal
				));
		
		// Reset Microwave Beam
		GameRegistry.addRecipe(new ShapelessOreRecipe(Correlated.wireless,
				Correlated.wireless
				));
		
		// Weldthrower Fuel
		GameRegistry.addShapelessRecipe(new ItemStack(Correlated.misc, 4, 5), luminousPearl);
		
		// Weldthrower
		GameRegistry.addRecipe(new ShapedOreRecipe(Correlated.weldthrower,
				"i  ",
				"ti_",
				"  i",
				'i', "ingotIron",
				'_', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE,
				't', luminousTorch
				));
		
	}

}
