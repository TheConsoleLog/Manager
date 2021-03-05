package com.theconsolelog.entitys;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class ArmorStandUtility {
	private final org.bukkit.entity.ArmorStand armorstand;

	public ArmorStandUtility (String name, Location location) {
		this.armorstand = location.getWorld ().spawn (location, org.bukkit.entity.ArmorStand.class);
		this.armorstand.setCustomName (name);
		this.armorstand.setCustomNameVisible (true);
	}

	public ArmorStandUtility setCustomNameVisible (boolean value) {
		this.armorstand.setCustomNameVisible (value);
		return this;
	}

	public ArmorStandUtility setGravity (boolean value) {
		this.armorstand.setGravity (value);
		return this;
	}

	public ArmorStandUtility setSmall (boolean value) {
		this.armorstand.setSmall (value);
		return this;
	}

	public ArmorStandUtility setArms (boolean value) {
		this.armorstand.setArms (value);
		return this;
	}

	public ArmorStandUtility setBasePlate (boolean value) {
		this.armorstand.setBasePlate (value);
		return this;
	}

	public ArmorStandUtility setChestPlate (ItemStack chestPlate) {
		this.armorstand.setChestplate (chestPlate);
		return this;
	}

	public ArmorStandUtility setBoots (ItemStack boots) {
		this.armorstand.setBoots (boots);
		return this;
	}

	public ArmorStandUtility setLeggins (ItemStack leggins) {
		this.armorstand.setLeggings (leggins);
		return this;
	}

	public ArmorStandUtility setHelmet (ItemStack helmet) {
		this.armorstand.setHelmet (helmet);
		return this;
	}

	public ArmorStandUtility setItemInHand (ItemStack itemInHand) {
		this.armorstand.setItemInHand (itemInHand);
		return this;
	}

	public ArmorStandUtility setVisible (boolean visible) {
		this.armorstand.setVisible (visible);
		return this;
	}

	public ArmorStandUtility setBodyPose (EulerAngle eulerAngle) {
		this.armorstand.setBodyPose (eulerAngle);
		return this;
	}

	public ArmorStandUtility setHeadPose (EulerAngle eulerAngle) {
		this.armorstand.setHeadPose (eulerAngle);
		return this;
	}

	public ArmorStandUtility setLeftArmPose (EulerAngle eulerAngle) {
		this.armorstand.setLeftArmPose (eulerAngle);
		return this;
	}

	public ArmorStandUtility setRightArmPose (EulerAngle eulerAngle) {
		this.armorstand.setRightArmPose (eulerAngle);
		return this;
	}

	public ArmorStandUtility setLeftLegPose (EulerAngle eulerAngle) {
		this.armorstand.setLeftLegPose (eulerAngle);
		return this;
	}

	public ArmorStandUtility setRightLegPose (EulerAngle eulerAngle) {
		this.armorstand.setRightLegPose (eulerAngle);
		return this;
	}
}