package codyhuh.oneinakrillion.client.models;

import codyhuh.oneinakrillion.OneInAKrillion;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class KrillModel extends EntityModel<LivingEntityRenderState> {
	public static final ModelLayerLocation KRILL_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(OneInAKrillion.MOD_ID, "krill"), "main");
	private final ModelPart root;
	private final ModelPart leftAntenna;
	private final ModelPart rightAntenna;
	private final ModelPart tail;
	private final ModelPart legs1;
	private final ModelPart legs2;
	private final ModelPart legs3;
	private final ModelPart legs4;

	public KrillModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.leftAntenna = this.root.getChild("leftAntenna");
		this.rightAntenna = this.root.getChild("rightAntenna");
		this.tail = this.root.getChild("tail");
		this.legs1 = this.root.getChild("legs1");
		this.legs2 = this.root.getChild("legs2");
		this.legs3 = this.root.getChild("legs3");
		this.legs4 = this.root.getChild("legs4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(14, 10).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition leftAntenna = root.addOrReplaceChild("leftAntenna", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -3.0F));

		PartDefinition rightAntenna = root.addOrReplaceChild("rightAntenna", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -3.0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(-3, 16).addBox(-2.5F, 0.0F, -0.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.5F));

		PartDefinition legs1 = root.addOrReplaceChild("legs1", CubeListBuilder.create().texOffs(16, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -1.0F));

		PartDefinition legs2 = root.addOrReplaceChild("legs2", CubeListBuilder.create().texOffs(16, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition legs3 = root.addOrReplaceChild("legs3", CubeListBuilder.create().texOffs(16, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		PartDefinition legs4 = root.addOrReplaceChild("legs4", CubeListBuilder.create().texOffs(16, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(LivingEntityRenderState renderState) {
		super.setupAnim(renderState);

		if (renderState.isInWater) {
			this.root.xRot = renderState.xRot * (float) (Math.PI / 180.0);
			this.root.yRot = renderState.yRot * (float) (Math.PI / 180.0);
		}

		float a = renderState.ageInTicks;
		float b = 0.5F;

		this.leftAntenna.xRot = Mth.cos(a * 0.6F) * 0.2F * b;
		this.rightAntenna.xRot = Mth.sin(a * 0.6F) * 0.2F * b;

		this.legs1.xRot = Mth.cos(a * 0.6F) * 1.4F * b;
		this.legs2.xRot = Mth.cos(-0.8F + a * 0.6F) * 1.4F * b;
		this.legs3.xRot = Mth.cos(-1.6F + a * 0.6F) * 1.4F * b;
		this.legs4.xRot = Mth.cos(-2.4F + a * 0.6F) * 1.4F * b;

		this.tail.xRot = Mth.cos(a * 0.6F) * 0.8F * b;
	}
}