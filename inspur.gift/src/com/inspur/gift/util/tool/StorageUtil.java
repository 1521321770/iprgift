package com.inspur.gift.util.tool;

public class StorageUtil {

    /**
     * byte��С����1.
     */
	public static final long BYTE = 1;

	/**
	 * 1kb���Ӧ��byte���1024.
	 */
	public static final long KB = 1024 * BYTE;

	/**
	 * 1MB��Ӧ��byte��1024*1024*1.
	 */
	public static final long MB = 1024 * KB;

	/**
	 * 1GB��Ӧ��byte��1024*1024*1024*1.
	 */
	public static final long GB = 1024 * MB;

	/**
	 * 1TB��Ӧ��byte��1024*1024*1024*1024*1.
	 */
	public static final long TB = 1024 * GB;

	/**
	 * 1PB��Ӧ��byte��1024*1024*1024*1024*1024*1.
	 */
	public static final long PB = 1024 * TB;

	/**
	 * 1EB��Ӧ��byte��1024*1024*1024*1024*1024*1024*1.
	 */
	public static final long EB = 1024 * PB;

	/**
	 * �ֽ�ת����KB.
	 * @param bytes
	 * 			byte�Ĵ�С
	 * @return KB
	 */
	public static double fromByteToKB(long bytes) {
		return (double) bytes / KB;
	}

	/**
	 * �ֽ�ת����.
	 * @param bytes
	 * 			byte�Ĵ�С
	 * @return MB
	 */
	public static double fromByteToMB(long bytes) {
		return (double) bytes / MB;
	}

	/**
	 * �ֽ�ת����GB.
	 * @param bytes
	 * 			byte�Ĵ�С
	 * @return GB
	 */
	public static double fromByteToGB(long bytes) {
		return (double) bytes / GB;
	}

	/**
	 * �ֽ�ת����TB.
	 * @param bytes
	 * 			byte�Ĵ�С
	 * @return TB
	 */
	public static double fromByteToTB(long bytes) {
		return (double) bytes / TB;
	}

	/**
	 * KBת�����ֽ�.
	 * @param kb
	 * 			kb�Ĵ�С
	 * @return byte
	 */
	public static long fromKBToByte(long kb) {
		return kb * KB;
	}

	/**
	 * MBת�����ֽ�.
	 * @param mb
	 * 			MB�Ĵ�С
	 * @return MB 
	 */
	public static long fromMBToByte(long mb) {
		return mb * MB;
	}

	/**
	 * GBת�����ֽ�.
	 * @param gb
	 * 			GB�Ĵ�С
	 * @return byte
	 */
	public static double fromGBToByte(long gb) {
		return (double) gb * GB;
	}

	/**
	 * GBת����KB.
	 * @param gb
	 * 			GB�Ĵ�С
	 * @return KB
	 */
	public static double fromGBToKB(long gb) {
		return (double) gb * MB;
	}

	/**
	 * GBת����MB.
	 * @param gb
	 * 			GB�Ĵ�С
	 * @return MB
	 */
	public static double fromGBToMB(long gb) {
		return (double) gb * KB;
	}

	/**
	 * MBת����GB.
	 * @param mb
	 * 			MB�Ĵ�С
	 * @return GB
	 */
	public static double fromMBToGB(long mb) {
		return (double) mb / KB;
	}

	/**
	 * MBת����KB.
	 * @param mb
	 * 			MB�Ĵ�С
	 * @return KB
	 */
	public static double fromMBToKB(long mb) {
		return (double) mb * KB;
	}

	/**
	 * KBת����MB.
	 * @param kb
	 * 			KB�Ĵ�С
	 * @return MB
	 */
	public static double fromKBToMB(long kb) {
		return (double) kb / KB;
	}

	/**
	 * KBת����GB.
	 * @param kb
	 * 			KB�Ĵ�С
	 * @return GB
	 */
	public static double fromKBToGB(long kb) {
		return (double) kb / MB;
	}
}
