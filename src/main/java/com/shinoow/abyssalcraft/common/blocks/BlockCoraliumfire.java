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

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.common.util.EntityUtil;

public class BlockCoraliumfire extends Block {

	public BlockCoraliumfire()
	{
		super(Material.fire);
		setTickRandomly(true);
	}

	@Override
	public boolean isBurning(IBlockAccess world, BlockPos pos)
	{
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		return null;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}

	@Override
	public int tickRate(World worldIn)
	{
		return 30;
	}

	@Override
	public boolean requiresUpdates()
	{
		return false;
	}

	@Override
	public boolean isCollidable()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, BlockPos pos, Entity par5Entity) {
		super.onEntityCollidedWithBlock(par1World, pos, par5Entity);

		if(par5Entity instanceof EntityLivingBase)
			if(EntityUtil.isEntityCoralium((EntityLivingBase)par5Entity)) {}
			else ((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(AbyssalCraft.Cplague.id, 100));
	}

	@Override
	public void onBlockAdded(World par1World, BlockPos pos, IBlockState state)
	{

		if (!BlockAbyssPortal.tryToCreatePortal(par1World, pos))
			if (!World.doesBlockHaveSolidTopSurface(par1World, pos.down()))
				par1World.setBlockToAir(pos);
			else
				par1World.scheduleUpdate(pos, this, tickRate(par1World) + par1World.rand.nextInt(10));
	}
}