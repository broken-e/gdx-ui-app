package com.broken_e.utils;

import com.badlogic.gdx.utils.ObjectIntMap;

/**
 * A small extension to ObjectIntMap.
 * 
 * @author trey miller
 * */
public class KeyValue<T> extends ObjectIntMap<T> {

	public int get(T k) {
		return get(k, 0);
	}

	public int addToValue(T k, int amount) {
		int result = amount + this.get(k, 0);
		put(k, result);
		return result;
	}
}
