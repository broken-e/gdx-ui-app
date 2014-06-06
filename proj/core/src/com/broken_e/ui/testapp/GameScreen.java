package com.broken_e.ui.testapp;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.StringBuilder;
import com.broken_e.ui.BaseScreen;
import com.broken_e.ui.UiApp;
import com.broken_e.ui.testapp.game.GameRoot;
import com.broken_e.ui.testapp.game.Stats;

/**
 * the screen that holds the GameRoot group and shows the HUD
 * 
 * @author trey miller
 * 
 */
public class GameScreen extends BaseScreen {

	private Label lblPoints;
	private Label lblStrikes;

	public GameScreen(UiApp app) {
		super(app);
		mainTable.setBackground(app.skin.getDrawable("window1"));
		mainTable.setColor(app.skin.getColor("lt-green"));
		mainTable.addActor(new GameRoot(this, app.atlas).init());

		Label lblPointText = new Label("Points: ", app.skin);
		lblPointText.setTouchable(Touchable.disabled);
		lblPoints = new Label("0", app.skin);
		lblPoints.setTouchable(Touchable.disabled);

		lblStrikes = new Label("", app.skin);
		lblStrikes.setTouchable(Touchable.disabled);

		mainTable.row().left().top();
		mainTable.add(lblPointText);
		mainTable.add(lblPoints).expandX().fill();
		mainTable.add(lblStrikes);
		mainTable.row();
		mainTable.add().expand().fill().colspan(3);
		// mainTable.debug();
	}

	@Override
	public void onBackPress() {
		app.switchScreens(new MainScreen(app));
	}

	public void pointsChanged(StringBuilder points) {
		lblPoints.setText(points);
	}

	public void mobExploded(StringBuilder totalStrikes) {
		lblStrikes.setText(totalStrikes);
	}

	public void gameOver(Stats stats) {
		app.switchScreens(new GameOverScreen(app, stats));

	}

}
