
package fr.odysseyus.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import fr.odysseyus.mod.itemgroup.OdysseyusItemGroup;
import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class OsamadisqueItem extends OdysseyusModElements.ModElement {
	@ObjectHolder("odysseyus:osamadisque")
	public static final Item block = null;

	public OsamadisqueItem(OdysseyusModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, OdysseyusModElements.sounds.get(new ResourceLocation("odysseyus:osoama_song")),
					new Item.Properties().group(OdysseyusItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("osamadisque");
		}
	}
}
