package base.lru;

import java.util.LinkedHashMap;
import java.util.Map;

//此实现为非线程安全，若在多线程环境下使用需要在相关方法上添加synchronized以实现线程安全操作
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LruCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

//    默认返回false， 在程序中效果就是不删除最近最少使用的值
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LruCache<Integer, Integer> cache = new LruCache<Integer, Integer>(3);
        for (int i = 0; i < 3; i++) {
            cache.put(i, i);
        }
        System.out.println(cache);
        cache.put(4, 4);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
