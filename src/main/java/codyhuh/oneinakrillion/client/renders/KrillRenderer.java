package codyhuh.oneinakrillion.client.renders;

import codyhuh.oneinakrillion.OneInAKrillion;
import codyhuh.oneinakrillion.client.models.KrillModel;
import codyhuh.oneinakrillion.client.renders.state.KrillRenderState;
import codyhuh.oneinakrillion.common.entities.Krill;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KrillRenderer extends MobRenderer<Krill, KrillRenderState, KrillModel> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "textures/entity/krill.png");

    public KrillRenderer(EntityRendererProvider.Context p_173954_) {
        super(p_173954_, new KrillModel(p_173954_.bakeLayer(KrillModel.KRILL_LAYER)), 0.3F);
    }

    public ResourceLocation getTextureLocation(KrillRenderState p_362950_) {
        return TEXTURE;
    }

    public KrillRenderState createRenderState() {
        return new KrillRenderState();
    }

    public void extractRenderState(Krill p_363889_, KrillRenderState p_362444_, float p_361350_) {
        super.extractRenderState(p_363889_, p_362444_, p_361350_);
        p_362444_.pose = KrillModel.getPose(p_363889_);
    }
}
