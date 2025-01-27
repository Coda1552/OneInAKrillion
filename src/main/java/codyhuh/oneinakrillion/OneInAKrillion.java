package codyhuh.oneinakrillion;

import codyhuh.oneinakrillion.registry.ModEntities;
import codyhuh.oneinakrillion.registry.ModItems;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@Mod(OneInAKrillion.MOD_ID)
public class OneInAKrillion {
    public static final String MOD_ID = "oneinakrillion";

    public OneInAKrillion(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::createAttributes);
        modEventBus.addListener(this::registerSpawnPlacements);

        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);

        modEventBus.addListener(this::populateTabs);
    }

    private void createAttributes(EntityAttributeCreationEvent e) {
        e.put(ModEntities.KRILL.get(), AbstractFish.createAttributes().build());
    }

    private void registerSpawnPlacements(RegisterSpawnPlacementsEvent e) {
        e.register(ModEntities.KRILL.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkSurfaceWaterAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
    }

    private void populateTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.TADPOLE_BUCKET.getDefaultInstance(), ModItems.KRILL_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.insertAfter(Items.PUFFERFISH.getDefaultInstance(), ModItems.KRILL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.insertAfter(Items.IRON_GOLEM_SPAWN_EGG.getDefaultInstance(), ModItems.KRILL_SPAWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        }
    }
}
