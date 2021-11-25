package twilightforest.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import twilightforest.TwilightForestMod;
import twilightforest.TwilightForestMod;
import twilightforest.api.RegistryObject;
import twilightforest.api.TFRegistry;
import twilightforest.item.ChainBlockItem;

public class TFEnchantments {

	public static final TFRegistry<Enchantment> ENCHANTMENTS = TFRegistry.create(Registry.ENCHANTMENT, TwilightForestMod.ID);

	public static final RegistryObject<Enchantment> FIRE_REACT = ENCHANTMENTS.register("fire_react", () -> new FireReactEnchantment(Enchantment.Rarity.UNCOMMON));
	public static final RegistryObject<Enchantment> CHILL_AURA = ENCHANTMENTS.register("chill_aura", () -> new ChillAuraEnchantment(Enchantment.Rarity.UNCOMMON));
	public static final RegistryObject<Enchantment> PRESERVATION = ENCHANTMENTS.register("preservation", () -> new PreservationEnchantment(Enchantment.Rarity.RARE));
	public static final RegistryObject<Enchantment> BLOCK_STRENGTH = ENCHANTMENTS.register("block_strength", () -> new BlockStrengthEnchantment(Enchantment.Rarity.RARE));
	public static final RegistryObject<Enchantment> DESTRUCTION = ENCHANTMENTS.register("destruction", () -> new DestructionEnchantment(Enchantment.Rarity.RARE));

	public static final EnchantmentCategory BLOCK_AND_CHAIN = EnchantmentCategory.ARMOR;//create("twilightforest_block_and_chain", item -> item instanceof ChainBlockItem);
}
