/**AbyssalCraft
 *Copyright 2012-2014 Shinoow
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */
package com.shinoow.abyssalcraft.common.potion;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.common.util.ACDamageSource;
import com.shinoow.abyssalcraft.core.api.entity.IDreadEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionDplague extends Potion{

	public PotionDplague(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}

	@Override
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2){
		par1EntityLivingBase.attackEntityFrom(ACDamageSource.dread, 1);
		if(par1EntityLivingBase instanceof IDreadEntity){
			par1EntityLivingBase.removePotionEffect(AbyssalCraft.Dplague.id);
			par1EntityLivingBase.heal(1);
		}
		if(par1EntityLivingBase instanceof EntityPlayer)
			((EntityPlayer)par1EntityLivingBase).addExhaustion(0.025F * (par2+2));
	}

	@Override
	public boolean isReady(int par1, int par2)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("abyssalcraft:textures/misc/potionFX.png"));
		return 1;
	}
}