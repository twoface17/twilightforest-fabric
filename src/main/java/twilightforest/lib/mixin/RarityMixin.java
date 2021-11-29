package twilightforest.lib.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.Rarity;

@Mixin(Rarity.class)
public abstract class RarityMixin {
//    @SuppressWarnings("ShadowTarget")
//    @Shadow @Final @Mutable
//    private static Rarity[] $VALUES;
//
//    @SuppressWarnings("InvokerTarget")
//    @Invoker("<init>")
//    public static Rarity init(String name, int id, ChatFormatting chatFormatting) {
//        throw new AssertionError();
//    }
//
//    // add new property from the static constructor
//    // static blocks are merged into the target class (at the end)
//    static {
//        ArrayList<Rarity> values =  new ArrayList<>(Arrays.asList($VALUES));
//        Rarity last = values.get(values.size() - 1);
//
//        // add new value
//        values.add(init("TWILIGHT", last.ordinal() + 1, ChatFormatting.DARK_GREEN));
//
//        $VALUES = values.toArray(new Rarity[0]);
//    }
}
