package com.sinlov.my.test.collection;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.*;

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
public class TimeStringTreeSetTest extends TempTest {

    private static final String FIRST_MARK = "FIRST_MARK";
    private static final String LAST_MARK = "LAST_MARK";
    private static final String MID_MARK = "MID_MARK";
    private static final String SAVE_MARK = "SAVE_MARK";
    private static final int TEST_INIT_SIZE = 5;

    private TimeStringTreeSet<TimeLineString> timeLineSet;
    private int count = 0;
    private long nowDate;
    private long saveDate;
    private TimeLineString midItem;
    private TimeLineString firstItem;
    private TimeLineString lastItem;
    private TimeLineString saveItem;
    private TimeLineString saveItem1;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        nowDate = System.currentTimeMillis();
        saveDate = nowDate + 4;
        saveItem = saveItem(SAVE_MARK);
        saveDate++;
        saveItem1 = saveItem(SAVE_MARK);
        initSet();
        addData();
        printNowSet(timeLineSet);
    }

    private void addData() {
        firstItem = initItem(FIRST_MARK);
        timeLineSet.add(firstItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            timeLineSet.add(initItem(7));
        }
        midItem = initItem(MID_MARK);
        timeLineSet.add(midItem);
        timeLineSet.remove(midItem);
        timeLineSet.add(midItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            timeLineSet.add(initItem(8));
        }
        lastItem = initItem(LAST_MARK);
        timeLineSet.add(lastItem);
    }

    private void printNowSet(TimeStringTreeSet<TimeLineString> set) {
        System.out.println("===========");
        Iterator<TimeLineString> iterator = set.iterator();
        printIteratorInfo(iterator);
        System.out.println("===========");
    }

    private void printIteratorInfo(Iterator<TimeLineString> iterator) {
        while (iterator.hasNext()) {
            TimeLineString next = iterator.next();
            String content = next.getContent();
            long time = next.getTime().getTime();
            System.out.println("content = " + content + " | time = " + time);
        }
    }

    private void initSet() {
        if (timeLineSet == null) {
            timeLineSet = new TimeStringTreeSet<TimeLineString>();
        }
        timeLineSet.clear();
    }

    private TimeLineString initItem(String content) {
        TimeLineString item = new TimeLineString();
        item.setContent(content);
        long date = nowDate + this.count;
        item.setTime(new Date(date));
        this.count++;
        return item;
    }

    private TimeLineString saveItem(String content) {
        TimeLineString item = new TimeLineString();
        item.setContent(content);
        item.setTime(new Date(saveDate));
        this.count++;
        return item;
    }

    private TimeLineString initItem(int count) {
        TimeLineString item = new TimeLineString();
        item.setContent(randomString(count));
        long date = nowDate + this.count;
        item.setTime(new Date(date));
        this.count++;
        return item;
    }

    @Test
    public void test_01_print_first_last() throws Exception {
        TimeLineString pollFirstItem = timeLineSet.pollFirst();
        long fistItemTime = pollFirstItem.getTime().getTime();
        System.out.println("fistItemTime = " + fistItemTime);
        System.out.println("pollFirstItem = " + pollFirstItem.getContent());
        TimeLineString pollLastItem = timeLineSet.pollLast();
        long lastItemTime = pollLastItem.getTime().getTime();
        System.out.println("lastItemTime = " + lastItemTime);
        System.out.println("pollLastItem = " + pollLastItem.getContent());

    }

    @Test
    public void test_02_mid_mark_before() throws Exception {
        SortedSet<TimeLineString> headSet = timeLineSet.headSet(midItem);
        Iterator<TimeLineString> iterator = headSet.iterator();
        printIteratorInfo(iterator);
    }

    @Test
    public void test_03_join() throws Exception {
        TimeStringTreeSet<TimeLineString> d = new TimeStringTreeSet<TimeLineString>(new DescendingTimeString<>()) {
        };
        d.addAll(timeLineSet);
        printNowSet(d);
        d.add(saveItem);
        d.add(saveItem1);
        printNowSet(d);
        SortedSet<TimeLineString> timeLineStrings = d.subSet(lastItem, true, saveItem, true);
        Iterator<TimeLineString> iterator = timeLineStrings.iterator();
        printIteratorInfo(iterator);
    }
}