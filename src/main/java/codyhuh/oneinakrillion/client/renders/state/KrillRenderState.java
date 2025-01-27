package codyhuh.oneinakrillion.client.renders.state;

import codyhuh.oneinakrillion.client.models.KrillModel;
import net.minecraft.client.model.ParrotModel;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.animal.Parrot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KrillRenderState extends LivingEntityRenderState {
    public KrillModel.Pose pose = KrillModel.Pose.SWIMMING;
}
