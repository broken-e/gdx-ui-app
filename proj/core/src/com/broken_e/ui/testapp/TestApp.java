package com.broken_e.ui.testapp;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.broken_e.ui.BaseScreen;
import com.broken_e.ui.UiApp;

/**
 * an example game using the gdx-ui-app stuff.
 * 
 * @author trey miller
 * 
 */
public class TestApp extends UiApp {
	@Override
	protected String atlasPath() {
		return "data/tex.atlas";
	}

	@Override
	protected String skinPath() {
		return null;
	}
	@Override
	protected void styleSkin(Skin skin, TextureAtlas atlas) {
		new Styles().styleSkin(skin, atlas);
	}

	@Override
	protected BaseScreen getFirstScreen() {
		return new MainScreen(this);
	}


}
