package codyhuh.oneinakrillion.common.entities.ai;

import codyhuh.oneinakrillion.common.entities.Krill;
import net.minecraft.world.entity.ai.goal.Goal;

//https://tenor.com/view/get-real-gif-20133241
public class GetRealGoal extends Goal {
    private final Krill krill;
    private boolean isReal;
    protected boolean forceTrigger;


    public GetRealGoal(Krill krill) {
        this.krill = krill;
        this.isReal = false;
    }
    @Override
    public void start() {
        this.krill.getNavigation().stop();
    }
    @Override
    public boolean canUse() {
        isReal = krill.isPartying();
        return isReal;
    }
    @Override
    public boolean canContinueToUse() {
        return isReal;
    }
    public void trigger() {
        this.forceTrigger = true;
    }

}
