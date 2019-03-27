import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestService
{
    private final MyMutableInteger myValue = new MyMutableInteger(0);
    private volatile boolean resetSequence = false;
    private final Map<String, ReentrantLock> locks = new HashMap<String, ReentrantLock>()
    {
        {
            this.put("contract", new ReentrantLock());
            this.put("customer", new ReentrantLock());
            this.put("party", new ReentrantLock());
        }
    };

    public int increment(String entity)
    {
        Lock lock = locks.get(entity);
        lock.lock();
        System.out.println(String.format("Entity: %s, lock: %s, inTime: %d", entity, lock, Calendar.getInstance().getTimeInMillis()));
        try
        {

            int val = myValue.getValue();
            myValue.setValue(val + 1);
        } finally
        {
            System.out.println(String.format("Entity: %s, lock: %s, outTime: %d", entity, lock, Calendar.getInstance().getTimeInMillis()));
            lock.unlock();
        }

        return myValue.getValue();
    }
}
