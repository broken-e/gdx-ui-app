package com.broken_e.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

/**
 * basically an ordered ObjectIntMap, useful for storing stats and scores.
 * 
 * @author trey miller
 * */
public class KeyValue<T> {
	private Array<T> keys = new Array<T>();
	private IntArray values = new IntArray();

	public int size() {
		return keys.size;
	}

	public int addToValue(T k, int amount) {
		put(k, amount + getValue(k));
		return getValue(k);
	}

	/** sets value if key exists, adds key-value pair if not */
	public void put(T key, int value) {
		if (keys.contains(key, false)) {
			int index = keys.indexOf(key, false);
			values.set(index, value);
		} else {
			keys.add(key);
			values.add(value);
		}
	}

	/** get value, returns 0 if key doesn't exist */
	public int getValue(T key) {
		if (keys.contains(key, false))
			return values.get(keys.indexOf(key, false));
		else
			return 0;
	}

	public T getKey(int index) {
		if (index >= keys.size)
			return null;
		return keys.get(index);
	}

	public boolean containsKey(T key, boolean identity) {
		return keys.contains(key, identity);
	}

	/** clears all keys and values */
	public void clear() {
		keys.clear();
		values.clear();
	}
}
