package com.broken_e.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectFloatMap;
import com.badlogic.gdx.utils.ObjectFloatMap.Entry;

/**
 * Stores a collection of objects along with a float associated with each that is the object's weight for randomizing.
 * Weights can be any value, and the random output is chosen based on the item weight's size relative to all other item
 * weights in the collection.
 * 
 * @author trey miller
 */
public class WeightedRandom<T> {

	private final ObjectFloatMap<T> objects = new ObjectFloatMap<T>();
	private float totalPossible;

	/** adds the item if it doesn't exist in the collection, otherwise just sets the weight. */
	public void setItem(float weight, T object) {
		objects.put(object, weight);
		setTotalPossible();
	}

	/** simply removes the item, by identity. */
	public T removeItem(T object) {
		objects.remove(object, 0f);
		setTotalPossible();
		return object;
	}

	private void setTotalPossible() {
		totalPossible = 0f;
		for (Entry<T> obj : objects.entries())
			totalPossible += obj.value;
	}
	
	public float getTotalPossible(){
		return totalPossible;
	}

	public void clear() {
		objects.clear();
		totalPossible = 0f;
	}

	/** Returns a random object based on weights. remove == true if you want the object to be removed from the collection */
	public T random(boolean remove) {
		if (objects.size < 1)
			return null;
		T result = null;
		float r = MathUtils.random(totalPossible + Float.MIN_VALUE);
		float accum = 0;
		for (Entry<T> obj : objects.entries())
			if (r <= (accum += obj.value)) {
				result = obj.key;
				if (remove)
					removeItem(result);
				break;
			}
		return result;
	}

	/** returns the object's weight, or 0f if the object is not found */
	public float getWeight(T object) {
		return objects.get(object, 0f);
	}

	/** sets totalPossible to 1f and adjusts all weights accordingly. never called automatically. */
	public void normalize() {
		for (Entry<T> obj : objects.entries()) 
			objects.put(obj.key, obj.value / totalPossible);
		totalPossible = 1f;
	}
}
