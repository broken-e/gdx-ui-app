package com.broken_e.ui.testapp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.StringBuilder;
import com.broken_e.utils.KeyValue;

public class Stats {

	public final KeyValue<String> keyValue = new KeyValue<String>();

	static public final String strPOINTS = "Points";
	static public final String strSTRIKES = "Strikes";

	private final StringBuilder tmpSB = new StringBuilder();
	private final Preferences prefs = Gdx.app.getPreferences("prefs");

	public void pointUp() {
		keyValue.addToValue(strPOINTS, 1);
	}

	/** not safe to continue using the returned StringBuilder */
	public StringBuilder getPoints() {
		tmpSB.setLength(0);
		tmpSB.append(keyValue.get(strPOINTS));
		return tmpSB;
	}

	public StringBuilder mobExploded() {
		keyValue.addToValue(strSTRIKES, 1);
		tmpSB.setLength(0);
		int strikes = keyValue.get(strSTRIKES);
		for (int i = 0; i < strikes; i++)
			tmpSB.append('X');
		return tmpSB;

	}

	public void reset() {
		keyValue.clear();
	}

	public int getStrikes() {
		return keyValue.get(strSTRIKES);
	}

	public int getTopScore() {
		return prefs.getInteger(strPOINTS);
	}

	public void save() {
		int points = keyValue.get(strPOINTS);
		if (prefs.getInteger(strPOINTS) < points) {
			prefs.putInteger(strPOINTS, points);
			prefs.flush();
		}
	}
}
