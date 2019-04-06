package br.com.udi.management.product.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

	public static BigDecimal getBigDecimailOrZero(BigDecimal value) {
		return value == null ? BigDecimal.ZERO : value;
	}

	public static BigDecimal round(BigDecimal value) {
		return getBigDecimailOrZero(value).setScale(2, RoundingMode.CEILING);
	}
}
