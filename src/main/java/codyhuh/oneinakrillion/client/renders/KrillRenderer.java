package codyhuh.oneinakrillion.client.renders;

import codyhuh.oneinakrillion.OneInAKrillion;
import codyhuh.oneinakrillion.client.models.KrillModel;
import codyhuh.oneinakrillion.common.entities.Krill;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class KrillRenderer extends MobRenderer<Krill, LivingEntityRenderState, KrillModel> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "textures/entity/krill.png");

    public KrillRenderer(EntityRendererProvider.Context p_173954_) {
        super(p_173954_, new KrillModel(p_173954_.bakeLayer(KrillModel.KRILL_LAYER)), 0.3F);
    }

    public ResourceLocation getTextureLocation(LivingEntityRenderState p_362950_) {
        return TEXTURE;
    }

    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
