package com.broken_e.ui.testapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.broken_e.ui.BaseScreen;
import com.broken_e.ui.UiApp;

/**
 * the first screen you see in the game.
 * 
 * @author trey miller
 * 
 */
public class MainScreen extends BaseScreen {

	public MainScreen(final UiApp app) {
		super(app);

		final TextButton button = new TextButton("Start", app.skin);

		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				app.switchScreens(new GameScreen(app));
				button.setChecked(false);
			}
		});
		mainTable.defaults().pad(6f);
		mainTable.setBackground(app.skin.getDrawable("window1"));
		mainTable.setColor(app.skin.getColor("lt-blue"));
		mainTable.add(label("gdx-ui-app: test!", Color.GREEN));
		mainTable.row();
		mainTable.add(button);
		mainTable.row();
		mainTable.add(label("To play:\nclick the objects moving around\nbefore they turn fully red.", Color.LIGHT_GRAY));
		mainTable.row();
		mainTable.add(label("If you don't and one turns red,\nyou will get a strike.", Color.LIGHT_GRAY));
		mainTable.row();
		mainTable.add(label("3 strikes and you are out!", Color.RED));
	}

	/** used to tidy up the label adding a bit for the how to play description */
	private Label label(String text, Color color) {
		Label label = new Label(text, app.skin);
		label.setAlignment(Align.center, Align.center);
		label.setColor(color);
		return label;
	}

	@Override
	public void onBackPress() {
		Gdx.app.exit();
	}

}
