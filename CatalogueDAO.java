1
package developerworks.ajax.store;

import java.util.*;
import java.util.regex.*;

/**
 * Data access class for product catalogue.
 * In this implementation, backing store is a simple static map
 */
public class CatalogueDAO {

  // Static datastore in lieu of a live database
  private static Map<String,Item> allItems = new HashMap<String,Item>();

  /**
   * Returns the Item corresponding to a given Item ID Code
   * @param id The ID code of the item
   * @return the matching Item
   */
  public Item getItem(String id) {
    return allItems.get(id);
  }

  /**
   * Returns all Items in the catalogue
   * @return all items in the catalogue
   */
  public Collection<Item> getAllItems() {
    return allItems.values();
  }

  /**
   * Returns a list of items in the catalogue that have names or
   * descriptions matching the search expression
   * @param expression Text to search item names and descriptions for
   * @return list of all matching items
   */
  public List<Item> findItems(String expression) {

    List<Item> foundItems = new ArrayList<Item>();
    String needles[] = expression.trim().toLowerCase().split("\\s+");

    for (Iterator<Item> I = allItems.values().iterator() ; I.hasNext() ; ) {

      Item item = I.next();

      // Fake a case-insensitive boolean AND search over the item's text fields
      String haystack = (item.getName()+" "+item.getDescription()).toLowerCase();
      boolean isMatch = true;

      // Need to find all the needles in the haystack for the item to be a match
      for (int needleIdx = 0 ; (needleIdx < needles.length) && isMatch ; needleIdx++) {

        if (!haystack.matches(".*\\b"+needles[needleIdx]+"\\b.*")) {
          isMatch = false;
        } 
      } // needles

      if (isMatch) {
        foundItems.add(item);
      }

    } // items

    return foundItems;
  }

  // Statically populate the datastore
  static {
    allItems.put("i-20897", new Item("i-20897","Bel-link USB Bluetooth dongle","Supplied with drivers for Windows and Macintosh",1999));
    allItems.put("i-55766", new Item("i-55766","Oolong 128MB CF Card","128 Megabyte Type 1 CompactFlash card. Manufactured by Oolong Industries",1999));
    allItems.put("i-55767", new Item("i-55767","Oolong 256MB CF Card","256 Megabyte Type 1 CompactFlash card. Manufactured by Oolong Industries",3499));
    allItems.put("i-55768", new Item("i-55768","Oolong 512MB CF Card","512 Megabyte Type 1 CompactFlash card. Manufactured by Oolong Industries",4999));
    allItems.put("i-55769", new Item("i-55769","Oolong 1GB CF Card","1 Gigabyte Type 1 CompactFlash card. Manufactured by Oolong Industries",8999));
    allItems.put("i-74488", new Item("i-74488","Fujak Superpix130 Camera","3.0 Megapixel digital camera featuring six shooting modes and 2x optical zoom. Silver.",14999));
    allItems.put("i-74489", new Item("i-74489","Fujak Superpix145 Camera","4.5 Megapixel digital camera featuring six shooting modes and 2x optical zoom. Silver.",19999));
    allItems.put("i-74490", new Item("i-74490","Fujak Superpix158 Camera","5.8 Megapixel digital camera featuring six shooting modes and 2.5x optical zoom. Silver.",24999));
    allItems.put("i-74491", new Item("i-74491","Fujak Superpix172 Camera","7.2 Megapixel digital camera featuring six shooting modes and 3x optical zoom. Silver.",29999));
    allItems.put("i-87871", new Item("i-87871","Maxigate HD400L","40GB Serial ATA Disk Drive, 7200rpm, 8MB cache",4499));
    allItems.put("i-87872", new Item("i-87872","Maxigate HD800L","80GB Serial ATA Disk Drive, 7200rpm, 8MB cache",5999));
    allItems.put("i-87873", new Item("i-87873","Maxigate HD1200L","120GB Serial ATA Disk Drive, 7200rpm, 8MB cache",7999));
    allItems.put("i-87874", new Item("i-87874","Maxigate HD1600L","160GB Serial ATA Disk Drive, 7200rpm, 8MB cache",9999));
    allItems.put("i-87875", new Item("i-87875","Maxigate HD2000L","200GB Serial ATA Disk Drive, 7200rpm, 8MB cache",11999));
  }
}
