/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2018 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.api.energy.structure;

import com.shinoow.abyssalcraft.api.energy.EnergyEnum.AmplifierType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Places of Power are structures capable of harvesting PE through energy manipulators without angering the gods<br>
 * Register an instance of a class implementing this interface to {@link StructureHandler }
 *
 * @author shinoow
 *
 * @since 1.16.0
 *
 */
public interface IPlaceOfPower {

	/**
	 * Returns the identifier (String associated with this Place of Power)
	 */
	public String getIdentifier();

	/**
	 * Returns the Book Type required in order to form this Place of Power
	 */
	public int getBookType();

	/**
	 * If the Place of Power amplifies any stats of statues used in it, handle that here
	 * @param type Amplifier Type to amplify
	 * @return A value to increase the selected stat with, or 0
	 */
	public float getAmplifier(AmplifierType type);

	/**
	 * Constructs the Place of Power
	 * @param world Current world
	 * @param pos Current position (where the Player constructing this right-clicked)
	 */
	public void construct(World world, BlockPos pos);

	/**
	 * Check that the structure is still valid, then take actions accordingly
	 * @param world Current World
	 * @param pos Position of base block
	 */
	public void validate(World world, BlockPos pos);

	/**
	 * Checks whether or not the structure can be constructed (the Book Type is checked prior to this)
	 * @param world Current World
	 * @param pos Current Position (where the Player constructing this right-clicked)
	 * @param player Player attempting to construct this
	 * @return True if the structure can be constructed, otherwise false
	 */
	public boolean canConstruct(World world, BlockPos pos, EntityPlayer player);
}
