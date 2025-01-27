package codyhuh.oneinakrillion.registry;

import codyhuh.oneinakrillion.OneInAKrillion;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OneInAKrillion.MOD_ID);

    public static final DeferredItem<Item> KRILL_SPAWN_EGG = ITEMS.register("krill_spawn_egg", () -> new SpawnEggItem(ModEntities.KRILL.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "krill_spawn_egg")))));
    public static final DeferredItem<Item> KRILL_BUCKET = ITEMS.register("krill_bucket", () -> new MobBucketItem(ModEntities.KRILL.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "krill_bucket")))));
    public static final DeferredItem<Item> KRILL = ITEMS.registerSimpleItem("krill", new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build(), Consumables.DRIED_KELP));
}
