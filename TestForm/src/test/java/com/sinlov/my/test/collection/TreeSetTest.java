package com.sinlov.my.test.collection;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/12/27.
 */
public class TreeSetTest extends TempTest {
    private static final String FIRST_MARK = "FIRST_MARK";
    private static final String LAST_MARK = "LAST_MARK";
    private static final String MID_MARK = "MID_MARK";
    private TreeSet<String> strTree;
    private TreeSet<Item> itemTree;
    private long count;

    @Before
    public void setUp() throws Exception {
        initStringTree();
        initItemTree();
    }

    class Item {
        Date time;
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public Item(String content) {
            this.content = content;
            this.time = new Date(System.currentTimeMillis());
        }

        public Item(Date time, String content) {
            this.time = time;
            this.content = content;
        }
    }

    class InsertSort<T extends Item> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            int res = (o1.getTime().compareTo(o2.getTime()));
            if (res == 0) {
                res = (o1.getContent().compareTo(o2.getContent()));
            }
            return res;
        }
    }

    private void initStringTree() {
        if (strTree == null) {
            strTree = new TreeSet<String>();
        } else {
            strTree.clear();
        }
        strTree.add(FIRST_MARK);
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(MID_MARK);
        strTree.remove(MID_MARK);
        strTree.add(MID_MARK);
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(LAST_MARK);
        Iterator<String> iterator = strTree.iterator();
        System.out.println("======");
        while (iterator.hasNext()) {
            String strItem = iterator.next();
            System.out.println("strTree = " + strItem);
        }
        System.out.println("======");
    }

    private void initItemTree() {
        if (itemTree == null) {
            itemTree = new TreeSet<Item>(new InsertSort<Item>());
        }
        itemTree.clear();
        itemTree.add(initTestItem(FIRST_MARK));
        itemTree.add(initTestItem(randomString(5)));
        itemTree.add(initTestItem(randomString(5)));
        itemTree.add(initTestItem(randomString(5)));
        Item midMask = initTestItem(MID_MARK);
        itemTree.add(midMask);
        itemTree.remove(midMask);
        itemTree.add(midMask);
        itemTree.add(initTestItem(randomString(5)));
        itemTree.add(initTestItem(randomString(5)));
        itemTree.add(initTestItem(LAST_MARK));
        Iterator<Item> iteratorItem = itemTree.iterator();
        System.out.println("======");
        while (iteratorItem.hasNext()) {
            Item next = iteratorItem.next();
            String content = next.getContent();
            System.out.println("content = " + content);
        }
        System.out.println("======");
    }

    private Item initTestItem(String firstMark) {
        long date = System.currentTimeMillis() + count;
        count++;
        return new Item(new Date(date), firstMark);
    }

    @Test
    public void test_01_ceiling() throws Exception {
        String ceiling = strTree.ceiling(FIRST_MARK);
        System.out.println("ceiling = " + ceiling);
    }

    @Test
    public void test_02_cell() throws Exception {
//        String pollFirst = strTree.pollFirst();
//        System.out.println("pollFirst = " + pollFirst);
//        String pollLast = strTree.pollLast();
//        System.out.println("pollLast = " + pollLast);

        Item pollFirstItem = itemTree.pollFirst();
        long fistItemTime = pollFirstItem.getTime().getTime();
        System.out.println("fistItemTime = " + fistItemTime);
        System.out.println("pollFirstItem = " + pollFirstItem.getContent());
        Item pollLastItem = itemTree.pollLast();
        long lastItemTime = pollLastItem.getTime().getTime();
        System.out.println("lastItemTime = " + lastItemTime);
        System.out.println("pollLastItem = " + pollLastItem.getContent());

    }


}
