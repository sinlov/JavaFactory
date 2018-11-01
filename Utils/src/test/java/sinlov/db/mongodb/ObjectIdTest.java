package sinlov.db.mongodb;

import org.junit.Before;
import org.junit.Test;

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
 * Created by sinlov on 2018/11/1.
 */
public class ObjectIdTest {

    private ObjectId objectId;

    @Before
    public void setUp() {
        objectId = new ObjectId("1231231");
    }

    @Test
    public void test_obj_id() {
        String gen = objectId.idString();
        System.out.println("genString = " + gen);
    }

    @Test
    public void test_gen_less() {
        String gen = objectId.idString();
        System.out.println("genString = " + gen);
    }

    @Test
    public void test_gen_more() {
        String gen = objectId.idString();
        System.out.println("genString = " + gen);
    }

    @Test
    public void test_gen_more_and_more() {
        for (int i = 0; i < 50; i++) {
            ObjectId objectId = new ObjectId("asd" + i);
            String gen = objectId.idString();
            System.out.println("genString = " + gen);
        }
    }

    @Test
    public void test_gen_fast() {
        for (int i = 0; i < 50; i++) {
            ObjectId objectId = new ObjectId();
            String gen = objectId.idString();
            System.out.println("genString = " + gen);
        }
    }

    @Test
    public void testCompareTo() throws Exception {

    }
}
