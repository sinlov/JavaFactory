package com.sinlov.my.test.collection;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;

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
    private static final int TEST_INIT_SIZE = 5;

    private TimeStringTreeSet<TimeLineString> timeLineSet;
    private int count = 0;
    private long nowDate;
    private TimeLineString midItem;
    private TimeLineString firstItem;
    private TimeLineString lastItem;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        nowDate = System.currentTimeMillis();
        initSet();
        addData();
        printNowSet();
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

    private void printNowSet() {
        System.out.println("===========");
        Iterator<TimeLineString> iterator = timeLineSet.iterator();
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
            timeLineSet = new TimeStringTreeSet<TimeLineString>(new DescendingTimeString<>());
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
}