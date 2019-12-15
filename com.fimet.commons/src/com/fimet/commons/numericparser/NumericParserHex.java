package com.fimet.commons.numericparser;

import com.fimet.commons.exception.FormatException;
import com.fimet.commons.utils.StringUtils;

/**
 * 
 * @author <a href="mailto:marcoasb99@ciencias.unam.mx">Marco A. Salazar</a>
 *
 */
public class NumericParserHex extends NumericParser {
	
	NumericParserHex(int id, String name) {
		super(id, name);
	}

	@Override
	public int parse(byte[] ascii) {
		return Integer.parseInt(new String(ascii),16);
	}

	@Override
	public byte[] format(int number, int length) {
		String fmt = Integer.toString(number,16);
		if (fmt.length() == length) {
			return fmt.getBytes();
		} else if (fmt.length() < length) {
			return StringUtils.leftPad(fmt, length, '0').getBytes();
		} else {
			throw new FormatException("Cannot format number "+number+" to "+length+" digits");
		}
	}
}
