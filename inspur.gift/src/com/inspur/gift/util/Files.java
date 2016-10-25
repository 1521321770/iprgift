package com.inspur.gift.util;

import java.util.regex.Matcher;

import org.apache.commons.lang3.StringUtils;

public class Files {
	public static String toPath(String... args) {
		StringBuilder strBuilder = new StringBuilder();
		if (!Params.isArray(args)) {
			for(String arg:args) {
				if(arg != null) {
					strBuilder.append(arg + "/");
				}
			}
		} else {
			return null;
		}
		String str = strBuilder.toString();
		if (str.length() > 0) {
			str = StringUtils.substring(str, 0, str.length()-1);
		}
		return str;
	}

	public static String toFile(String path, String fileName) {
		if (Params.isNull(path, fileName)) {
			return null;
		}
		return path + "/" + fileName;
	}

	public static String formatPath(String path) {
		if (Params.isNull(path)) {
			return null;
		}
		String replaced = path.replaceAll(Matcher.quoteReplacement("\\"), "/");
		StringBuilder str = new StringBuilder(replaced);
		while (str.charAt(0) == '/') {
			str = str.replace(0, 1, "");
		}
		return str.toString().replaceAll("/+", "/");
	}
}
