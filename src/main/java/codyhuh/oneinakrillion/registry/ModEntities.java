package codyhuh.oneinakrillion.registry;

import codyhuh.oneinakrillion.OneInAKrillion;
import codyhuh.oneinakrillion.common.entities.Krill;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.createEntities(OneInAKrillion.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<Krill>> KRILL = ENTITIES.register("krill", () -> EntityType.Builder.of(Krill::new, MobCategory.WATER_AMBIENT).sized(0.35F, 0.2F).build(ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "krill"))));
}
