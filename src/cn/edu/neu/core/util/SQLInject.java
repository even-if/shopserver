package cn.edu.neu.core.util;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.lang.String; 
 
public class SQLInject {
	public static boolean sql_inj(String str)
	{
	    String inj_str = "'|and|exec|insert|select|delete|update|drop|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		//这里的东西还可以自己添加
		String[] inj_stra=inj_str.split("\\|");
	    for (int i=0 ; i < inj_stra.length ; i++ )
	    {
	        if (str.indexOf(inj_stra[i])>=0)
	        {
	            return true;
	        }
	    }
	    return false;
	}
}
