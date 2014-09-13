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
import com.shinoow.abyssalcraft.common.entity.*;
import com.shinoow.abyssalcraft.common.util.ACDamageSource;
import com.shinoow.abyssalcraft.core.api.entity.CoraliumMob;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import cpw.mods.fml.relauncher.*;

public class PotionCplague extends Potion{

	public PotionCplague(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}

	@Override
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2){
		par1EntityLivingBase.attackEntityFrom(ACDamageSource.coralium, 2);
		if(par1EntityLivingBase instanceof CoraliumMob){
			par1EntityLivingBase.removePotionEffect(AbyssalCraft.Cplague.id);
			par1EntityLivingBase.heal(2);
		}
		if(par1EntityLivingBase instanceof EntityPlayer && ((EntityPlayer)par1EntityLivingBase).getCommandSenderName().equals("shinoow") ||
				par1EntityLivingBase instanceof EntityPlayer && ((EntityPlayer)par1EntityLivingBase).getCommandSenderName().equals("Oblivionaire")){
			par1EntityLivingBase.removePotionEffect(AbyssalCraft.Cplague.id);
			par1EntityLivingBase.heal(2);
		}
		if(par1EntityLivingBase instanceof EntityZombie) {
			if(!par1EntityLivingBase.isEntityAlive())
			{
				EntityAbyssalZombie entityzombie = new EntityAbyssalZombie(par1EntityLivingBase.worldObj);
				if(par1EntityLivingBase.worldObj.difficultySetting == EnumDifficulty.HARD && par1EntityLivingBase.worldObj.rand.nextBoolean()) {
					entityzombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
					entityzombie.onSpawnWithEgg((IEntityLivingData)null);
					entityzombie.setIsZombie(true);
				}
				else if(par1EntityLivingBase.worldObj.rand.nextInt(8) == 0) {
					entityzombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
					entityzombie.onSpawnWithEgg((IEntityLivingData)null);
					entityzombie.setIsZombie(true);
				}

				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(entityzombie);
			}
			if(par1EntityLivingBase.worldObj.getWorldInfo().isHardcoreModeEnabled())
				if(!par1EntityLivingBase.isEntityAlive() && par1EntityLivingBase.worldObj.rand.nextInt(10) == 0) {
					EntityDepthsghoul ghoul = new EntityDepthsghoul(par1EntityLivingBase.worldObj);
					ghoul.copyLocationAndAnglesFrom(par1EntityLivingBase);
					ghoul.onSpawnWithEgg((IEntityLivingData)null);
					par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
					ghoul.setGhoulType(0);
					par1EntityLivingBase.worldObj.spawnEntityInWorld(ghoul);
				}
		}
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
		return 0;
	}
}