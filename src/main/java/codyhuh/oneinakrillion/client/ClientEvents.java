package codyhuh.oneinakrillion.client;

import codyhuh.oneinakrillion.OneInAKrillion;
import codyhuh.oneinakrillion.client.models.KrillModel;
import codyhuh.oneinakrillion.client.renders.KrillRenderer;
import codyhuh.oneinakrillion.registry.ModEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = OneInAKrillion.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(ModEntities.KRILL.get(), KrillRenderer::new);
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(KrillModel.KRILL_LAYER, KrillModel::createBodyLayer);
    }
}
