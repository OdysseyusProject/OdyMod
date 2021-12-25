
package fr.odysseyus.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.odysseyus.mod.itemgroup.OdysseyusItemGroup;
import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class OdyritepickaxeItem extends OdysseyusModElements.ModElement {
	@ObjectHolder("odysseyus:odyritepickaxe")
	public static final Item block = null;

	public OdyritepickaxeItem(OdysseyusModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 3.5f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(OdyriteingotItem.block));
			}
		}, 1, -2.7f, new Item.Properties().group(OdysseyusItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("odyritepickaxe"));
	}
}
