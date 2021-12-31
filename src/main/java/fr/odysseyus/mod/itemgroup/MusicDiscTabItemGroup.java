
package fr.odysseyus.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.odysseyus.mod.OdysseyusModElements;

@OdysseyusModElements.ModElement.Tag
public class MusicDiscTabItemGroup extends OdysseyusModElements.ModElement {
	public MusicDiscTabItemGroup(OdysseyusModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmusic_disc_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.MUSIC_DISC_PIGSTEP);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
