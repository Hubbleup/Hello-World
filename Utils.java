1
package developerworks.ajax.store;

import java.text.*;

public class Utils {

  private static NumberFormat cash = new DecimalFormat("$#,##0.00");

  public static String formatCurrency(int cents) {
    return cash.format((double)(cents/100));
  }
}
