package codyhuh.oneinakrillion.common.entities;

import codyhuh.oneinakrillion.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Krill extends AbstractSchoolingFish {
    private static final EntityDataAccessor<Boolean> PARTYING = SynchedEntityData.defineId(Krill.class, EntityDataSerializers.BOOLEAN);
    private boolean party;
    @Nullable
    private BlockPos jukebox;

    public Krill(EntityType<? extends AbstractSchoolingFish> p_27523_, Level p_27524_) {
        super(p_27523_, p_27524_);
        this.moveControl = new SmoothSwimmingMoveControl(this, 80, 10, 0.1F,0.5F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6, 1.4, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0, 1));
        this.goalSelector.addGoal(5, new FollowFlockLeaderGoal(this));
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COD_HURT;
    }

    @Override
    public int getMaxSchoolSize() {
        return 12;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.KRILL_BUCKET.get());
    }

    @Override
    public void aiStep() {
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 3.46) || !this.level().getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            this.party = false;
            this.jukebox = null;
            setPartying(false);
        }

        super.aiStep();
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (getPartying()) {
            if (getNavigation().getPath() != null) {
                getNavigation().stop();
            }
            setSpeed(0.0F);
            travelVector = Vec3.ZERO;
            setDeltaMovement(Vec3.ZERO);

            System.out.println(getPartying());
        }

        super.travel(travelVector);
    }

    @Override
    public void setRecordPlayingNearby(BlockPos pos, boolean isPartying) {
        this.jukebox = pos;
        this.party = isPartying;
        setPartying(isPartying);
    }

    public boolean isPartying() {
        return this.party;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326212_) {
        super.defineSynchedData(p_326212_);

        p_326212_.define(PARTYING, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        if (this.entityData.get(PARTYING)) {
            compound.putBoolean("partying", getPartying());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        this.entityData.set(PARTYING, compound.getBoolean("partying"));
    }

    public boolean getPartying() {
        return this.entityData.get(PARTYING);
    }

    public void setPartying(boolean partying) {
        this.entityData.set(PARTYING, partying);
    }
}
