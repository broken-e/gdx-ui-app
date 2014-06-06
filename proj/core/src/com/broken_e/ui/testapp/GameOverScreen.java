package com.broken_e.ui.testapp;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.broken_e.ui.BaseScreen;
import com.broken_e.ui.UiApp;
import com.broken_e.ui.testapp.game.Stats;

/**
 * the final screen shown after the game is over, obviously.
 * 
 * @author trey miller
 */
public class GameOverScreen extends BaseScreen {

	public GameOverScreen(final UiApp app, Stats stats) {
		super(app);
		mainTable.setBackground(app.skin.getDrawable("window1"));
		mainTable.setColor(app.skin.getColor("dark-blue"));
		mainTable.setSkin(app.skin);
		mainTable.add("Game Over!");
		mainTable.row();
		mainTable.add("Points: " + stats.getPoints());
		mainTable.row();
		mainTable.add("Top Score: " + stats.getTopScore()).padBottom(100f);
		

		mainTable.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				app.switchScreens(new MainScreen(app));
			}
		});
		mainTable.setTouchable(Touchable.enabled);
		
		dur = .666f;
	}
	
	@Override
	protected void screenOut() {
		addAction(Actions.fadeOut(dur));
	}

	@Override
	public void onBackPress() {
		app.switchScreens(new MainScreen(app));
	}

}
