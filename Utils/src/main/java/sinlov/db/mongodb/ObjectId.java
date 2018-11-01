package sinlov.db.mongodb;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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
public class ObjectId implements Comparable<ObjectId>, java.io.Serializable {
    //    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectId.class);
    public final int _time;
    public final int _machine;
    public final int _inc;
    public final int _random;
    public boolean _new;
    private static final int _gen_machine;
    private static AtomicInteger _nextInc = new AtomicInteger();

    static {
        try {
            final int machinePiece;
            {
                StringBuilder sb = new StringBuilder();
                Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
                while (e.hasMoreElements()) {
                    NetworkInterface ni = e.nextElement();
                    sb.append(ni.toString());
                }
                machinePiece = sb.toString().hashCode() << 16;
            }
            final int processPiece;
            {
                int processId = new java.util.Random().nextInt();
                try {
                    processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                ClassLoader loader = ObjectId.class.getClassLoader();
                int loaderId = loader != null ? System.identityHashCode(loader) : 0;
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toHexString(processId));
                sb.append(Integer.toHexString(loaderId));
                processPiece = sb.toString().hashCode() & 0xFFFF;
            }
            _gen_machine = machinePiece | processPiece;
        } catch (java.io.IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public String idString() {
        return String.format("%08x%10x%06x", _time, _machine, _random).replace(" ", "_");
    }

    public int compareTo(ObjectId o) {
        if (this._time == o._time && this._machine == o._machine && this._inc == o._inc && this._new == o._new) {
            return 1;
        }
        return 0;
    }

    public ObjectId(String mark) {
        long timeMillis = System.currentTimeMillis();
        _time = (int) (timeMillis / 1000);
        _machine = _gen_machine;
        _inc = _nextInc.getAndIncrement();
        _new = true;
        if (mark == null || mark.length() < 4) {
            mark = String.valueOf(new Random(System.nanoTime()).nextInt()) + mark;
        }
        _random = mark.hashCode();
    }

    public ObjectId(int random) {
        long timeMillis = System.currentTimeMillis();
        _time = (int) (timeMillis / 1000);
        _machine = _gen_machine;
        _inc = _nextInc.getAndIncrement();
        _new = true;
        if (random == 0) {
            random = new Random(System.nanoTime()).nextInt();
        }
        _random = random;
    }

    public ObjectId() {
        long timeMillis = System.currentTimeMillis();
        _time = (int) (timeMillis / 1000);
        _machine = _gen_machine;
        _inc = _nextInc.getAndIncrement();
        _new = true;
        _random = new Random(System.nanoTime()).nextInt();
    }
}
