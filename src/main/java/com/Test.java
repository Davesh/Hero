package com;

import org.apache.commons.lang.StringUtils;

public class Test {
	public static void main(String[] args) {
		String url = "https://twitter.com/bhupatipatel009";
		System.out.println(StringUtils.substring(url, StringUtils.lastIndexOf(url, '/') + 1));
	}
}
