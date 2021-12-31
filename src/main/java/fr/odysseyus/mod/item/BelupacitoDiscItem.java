
package fr.odysseyus.mod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import fr.odysseyus.mod.itemgroup.MusicDiscTabItemGroup;
import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class BelupacitoDiscItem extends OdysseyusModElements.ModElement {
	@ObjectHolder("odysseyus:belupacito_disc")
	public static final Item block = null;

	public BelupacitoDiscItem(OdysseyusModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, OdysseyusModElements.sounds.get(new ResourceLocation("odysseyus:belupacito")),
					new Item.Properties().group(MusicDiscTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("belupacito_disc");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
