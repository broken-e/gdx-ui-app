package com.broken_e.ui.testapp.game;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Pools;

/**
 * event class for Mob when it needs to be removed.
 * 
 * @author trey miller
 */
public abstract class MobRemoveEvent extends Event {
	public void removeMob() {
		Mob mob = (Mob) getTarget();
		mob.remove();
		Pools.free(mob);
	}

	/** dummy class for specifying the type of event being a mob touched */
	public static class MobTouchedEvent extends MobRemoveEvent {
		@Override
		public void removeMob() {
			Mob mob = (Mob) getTarget();
			mob.addAction(Actions.rotateBy(720f, .42f));
			mob.addAction(Actions.sequence(Actions.scaleTo(0f, 0f, .42f), Actions.run(new Runnable() {
				@Override
				public void run() {
					MobTouchedEvent.super.removeMob();
				}
			})));
		}
	}

	/** dummy class for specifying the type of event being a mob exploded */
	public static class MobExplodeEvent extends MobRemoveEvent {
		@Override
		public void removeMob() {
			Mob mob = (Mob) getTarget();
			mob.addAction(Actions.sequence(Actions.scaleTo(42f, 42f, .42f), Actions.run(new Runnable() {
				@Override
				public void run() {
					MobExplodeEvent.super.removeMob();
				}
			})));
		}
	}
}
