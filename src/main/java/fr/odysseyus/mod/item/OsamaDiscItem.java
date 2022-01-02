
package fr.odysseyus.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import fr.odysseyus.mod.itemgroup.MusicDiscTabItemGroup;
import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class OsamaDiscItem extends OdysseyusModElements.ModElement {
	@ObjectHolder("odysseyus:osama_disc")
	public static final Item block = null;

	public OsamaDiscItem(OdysseyusModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, OdysseyusModElements.sounds.get(new ResourceLocation("odysseyus:osama_song")),
					new Item.Properties().group(MusicDiscTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("osama_disc");
		}
	}
}
