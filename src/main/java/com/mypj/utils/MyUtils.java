package com.mypj.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevinzcf
 */
public class MyUtils {

	public static List<String> stringSplitBySep(String strs, String sep) {
		List<String> out = new ArrayList<String>();
		String[] split = strs.split(sep);
		for (String str : split) {
			out.add(str);
		}
		return out;
	}

}
