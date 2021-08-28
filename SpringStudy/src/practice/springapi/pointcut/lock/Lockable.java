package practice.springapi.pointcut.lock;

public interface Lockable {
	void lock();
	void unlock();
	boolean locked();
}
