package cn.com.ut.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常处理工具类
 */
public class ExceptionUtil {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

	/**
	 * 获取异常链的详细信息，以便输出至日志文件
	 * 
	 * @param e
	 * @return 常链的详细信息
	 */
	public static String printStackTrace(Throwable e) {

		if (e == null)
			return null;

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		PrintStream ps = new PrintStream(bos, false);
		e.printStackTrace(ps);
		ps.close();
		return os.toString();
	}

	/**
	 * 输入错误日志信息
	 * 
	 * @param e
	 */
	public static void logError(Throwable e) {

		logger.error(printStackTrace(e));
	}

	/**
	 * throw RuntimeException
	 * 
	 * @param message
	 */
	public static void throwRuntimeException(String message) {

		throw new RuntimeException(message);
	}

	/**
	 * throw ServiceException
	 * 
	 * @param message
	 */
	public static void throwServiceException(String message) {

		throw new ServiceException(message);
	}

	/**
	 * throw ValidateException
	 * 
	 * @param message
	 */
	public static void throwValidateException(String message) {

		throw new ValidateException(message);
	}

	/**
	 * throw ValidateException
	 *
	 * @param message
	 */
	public static void throwLockException(String message) {

		throw new LockException(message);
	}

}
