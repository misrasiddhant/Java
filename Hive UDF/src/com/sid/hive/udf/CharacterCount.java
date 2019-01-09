package com.sid.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class CharacterCount extends UDF {
	public int evaluate(String s) {
		if(s==null) {return 0;}
		return s.length();
	}
}
