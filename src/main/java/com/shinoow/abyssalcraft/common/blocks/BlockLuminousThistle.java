/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2016 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.blocks;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.lib.ACTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class BlockLuminousThistle extends BlockBush {

	public BlockLuminousThistle(){
		super();
		setUnlocalizedName("luminousthistle");
		setCreativeTab(ACTabs.tabDecoration);
		setLightLevel(0.5F);
	}

	@Override
	protected boolean canPlaceBlockOn(Block ground)
	{
		return ground == ACBlocks.fused_abyssal_sand || ground == ACBlocks.abyssal_sand ||
				ground.getMaterial() == Material.grass || super.canPlaceBlockOn(ground);
	}
}