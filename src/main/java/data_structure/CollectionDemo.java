package data_structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2018/11/5
 * Description:
 * Modified:
 */
public class CollectionDemo {

    public static void test1() {
        Iterator iterator;
        Iterable iterable;
        ListIterator listIterator;
        Collection collection;
        List<String> list = new ArrayList<>();
        CopyOnWriteArrayList copyOnWriteArrayList;

        List list1 = Arrays.asList(1, 2, 3);

//        ArrayList
        List<String> list2 = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);
        List<String> list3 = new CopyOnWriteArrayList<>();

//        linkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.addFirst(2);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "123");
        map.put(null, "3");
        map = new Hashtable<>();
        map.put(3, "111");
        map.put(null, "123");
        ConcurrentHashMap<Integer, String> map1 = new ConcurrentHashMap<Integer, String>();
        map1.put(1, "3");
        map1.get(3);


        AtomicInteger integer = new AtomicInteger();
        integer.compareAndSet(1, 3);
        System.out.println(integer);

        LinkedHashMap<Integer, AtomicInteger> map3 = new LinkedHashMap<>();
        map3.put(3,integer);

        WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<Integer, Integer>();
        weakHashMap.put(1,2);

    }

    public static void main(String[] args) {
        test1();
    }
}
