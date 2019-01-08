/**
 * 
 */
package cgl.xyhs.util.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
* @ClassName: DateConverter.java
* @Description: 时间格式转换器
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月8日 上午9:15:34 
 */
public class DateConverter implements Converter<String, Date> {

	
	public static String convert(Date str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(str);
	}

	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}