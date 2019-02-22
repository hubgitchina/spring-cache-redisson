package cn.com.ut.util;

public class LockException extends RuntimeException {

	public LockException() {

		super();
	}

	public LockException(String message) {

		super(message);
	}

	public LockException(String message, Throwable cause) {

		super(message, cause);
	}

	public LockException(Throwable cause) {

		super(cause);
	}
}
