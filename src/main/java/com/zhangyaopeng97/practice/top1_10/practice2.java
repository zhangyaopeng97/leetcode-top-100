package com.zhangyaopeng97.practice.top1_10;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 *
 * @since 2025/04/15 17:15
 * @see <a href="题目地址">https://leetcode.cn/problems/lru-cache</a>
 * @author zyp
 */
public class practice2 {
	private final LinkedHashMap<Integer, Integer> cache;

	public practice2(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
		practice2 lruCache = new practice2(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}
}
