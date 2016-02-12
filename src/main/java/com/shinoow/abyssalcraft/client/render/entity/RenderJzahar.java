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
package com.shinoow.abyssalcraft.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.shinoow.abyssalcraft.client.model.entity.ModelJzahar;
import com.shinoow.abyssalcraft.common.entity.EntityJzahar;

@SideOnly(Side.CLIENT)
public class RenderJzahar extends RenderLiving<EntityJzahar> {

	protected ModelJzahar model;

	private static final ResourceLocation mobTexture = new ResourceLocation("abyssalcraft:textures/model/boss/J'zahar.png");

	public RenderJzahar(RenderManager manager, ModelJzahar ModelJzahar, float f)
	{
		super(manager, ModelJzahar, f);
		model = (ModelJzahar)mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityJzahar entity) {

		return mobTexture;
	}

	@Override
	public void doRender(EntityJzahar par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		BossStatus.setBossStatus(par1Entity, false);
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
	}
}