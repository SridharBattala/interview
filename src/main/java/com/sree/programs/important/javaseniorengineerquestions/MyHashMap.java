package com.sree.programs.important.javaseniorengineerquestions;

public class MyHashMap {
	int capacity = 10;

	class Entry {
		Integer key;
		String value;
		Entry next;

		Entry(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	Entry[] entries = new Entry[capacity];

	public static void main(String a[]) {
		MyHashMap map = new MyHashMap();
		map.put(1, "sridhar");
		map.put(2, "pravallika");
		map.put(11, "krishna");
		System.out.println(map.get(1));
		System.out.println(map.get(11));
	}

	public void put(Integer key, String value) {
		int index = key % capacity;
		Entry entry = entries[index];

		if (entry == null) {
			entries[index] = new Entry(key, value);
		} else {
			Entry previous = entry;
			while (entry != null) {
				if (entry.key == key) {
					entry.value = value;
					return;
				}
				previous = entry;
				entry = entry.next;

			}
			previous.next = new Entry(key, value);
		}

	}

	public String get(Integer key) {
		// match both key and value
		int index = key % capacity;
		Entry entry = entries[index];
		while (entry.key != key) {
			entry = entry.next;
		}
		return entry.value;
	}
}
