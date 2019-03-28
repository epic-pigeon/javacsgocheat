package org.xena.plugin.official;

import org.xena.Indexer;
import org.xena.Settings;
import org.xena.cs.ClientState;
import org.xena.cs.GameEntity;
import org.xena.cs.Me;
import org.xena.cs.Player;
import org.xena.keylistener.NativeKeyUtils;
import org.xena.plugin.Plugin;
import org.xena.plugin.utils.AngleUtils;
import org.xena.plugin.utils.Vector;

public final class HeadFollowPlugin extends Plugin {

    private final AngleUtils aimHelper = new AngleUtils(this, 100f, 1.7F, 2.5F, 1.7F, 2.5F);
    private final Vector aim = new Vector();
    private final Vector lastaim = new Vector();
    private Player lastTarget = null;

    @Override
    public void pulse(ClientState clientState, Me me, Indexer<GameEntity> players) {
        if (true && !me.getCursorEnabled()) {
            Player target = me.getClosestTarget(aimHelper, 10);
            if (lastTarget != null && target == null) {
                if (!lastTarget.isDead() && lastTarget.isSpotted()) {
                    target = lastTarget;
                } else {
                    lastTarget = null;
                }
            }

            if (target == null) {
                lastaim.reset();
                return;
            }

            if (aimHelper.canShoot(me, target)) {
                aimHelper.velocityComp(me, target, target.getBones());
                aimHelper.calculateAngle(me, me.getViewOrigin(), target.getBones(), aim);
                aimHelper.setAngleSmooth(aim, target.getViewAngles());

                lastTarget = target;
            } else {
                lastTarget = null;
            }
        } else {
            lastTarget = null;
        }
        sleep(10);
    }
}

