package twilightforest.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import twilightforest.TwilightForestMod;
import twilightforest.TwilightForestMod;
import twilightforest.item.ChainBlockItem;

public class TFEnchantments {

	//public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TwilightForestMod.ID);

	public static final Enchantment FIRE_REACT = Registry.register(Registry.ENCHANTMENT, TwilightForestMod.prefix("fire_react"), new FireReactEnchantment(Enchantment.Rarity.UNCOMMON));
	public static final Enchantment CHILL_AURA = Registry.register(Registry.ENCHANTMENT, TwilightForestMod.prefix("chill_aura"), new ChillAuraEnchantment(Enchantment.Rarity.UNCOMMON));
	public static final Enchantment PRESERVATION = Registry.register(Registry.ENCHANTMENT, TwilightForestMod.prefix("preservation"), new PreservationEnchantment(Enchantment.Rarity.RARE));
	public static final Enchantment BLOCK_STRENGTH = Registry.register(Registry.ENCHANTMENT, TwilightForestMod.prefix("block_strength"), new BlockStrengthEnchantment(Enchantment.Rarity.RARE));
	public static final Enchantment DESTRUCTION = Registry.register(Registry.ENCHANTMENT, TwilightForestMod.prefix("destruction"), new DestructionEnchantment(Enchantment.Rarity.RARE));

	public static final EnchantmentCategory BLOCK_AND_CHAIN = EnchantmentCategory.create("twilightforest_block_and_chain", item -> item instanceof ChainBlockItem);
}
