
package fr.odysseyus.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import fr.odysseyus.mod.itemgroup.MusicDiscTabItemGroup;
import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class SuperIdolDiscItem extends OdysseyusModElements.ModElement {
	@ObjectHolder("odysseyus:super_idol_disc")
	public static final Item block = null;

	public SuperIdolDiscItem(OdysseyusModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, OdysseyusModElements.sounds.get(new ResourceLocation("odysseyus:super_idol")),
					new Item.Properties().group(MusicDiscTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("super_idol_disc");
		}
	}
}
