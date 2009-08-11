package de.forsthaus.backend.model;

public class KeyValuePair {

	private String key;
	private String value;

	public KeyValuePair(Object key, Object value) {
		super();
		this.setKey((String) key);
		this.setValue((String) value);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return getKey() + " " + getValue();
	}

}
