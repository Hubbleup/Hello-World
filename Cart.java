1
package developerworks.ajax.store;

import java.util.*;

/**
 * Represents a user's shopping cart
 */
public class Cart {

  private Map<Item,Integer> contents;
  private int totalPrice = 0;

  /**
   * Create a new instance
   */
  public Cart() {
    contents = new HashMap<Item,Integer>();
  }

  
  /**
   * Adds an item to the shopping cart
   * @param itemId The catalogue ID of the item to add
   * @return the Cart
   */
  public Cart addItemToCart(String itemId) {

    Item item = new CatalogueDAO().getItem(itemId);
    if (item != null) {
      totalPrice += item.getPrice();

      int newQuantity = 1;
      
      Integer oldQuantity = contents.get(item);
      if (oldQuantity != null) {
        newQuantity += oldQuantity.intValue();
      }
    
      contents.put(item,new Integer(newQuantity));
    }

    return this;
  }


  /**
   * Returns the cart itself
   * @return the cart
   */
  public Cart getCart() {
    return this;
  }

  /**
   * Returns the total price of all the items in the cart
   * @return the total price of all the items in the cart
   */
  public int getTotalPrice() {
    return this.totalPrice;
  }

  /**
   * Returns the total price of all the items in the cart, formatted for display
   * @return the total price of all the items in the cart, formatted for display
   */
  public String getFormattedTotalPrice() {
    return Utils.formatCurrency(this.totalPrice);
  }

  /**
   * Returns the cart contents in a simplified form for an Ajax client
   * @return simplified cart contents
   */
  public Map<String,Integer> getSimpleContents() {

    Map<String,Integer> simpleContents = new HashMap<String,Integer>();

    for (Iterator<Item> I = contents.keySet().iterator() ; I.hasNext() ; ) {

      Item item = I.next();
      simpleContents.put(item.getName(),contents.get(item));
    }

    return simpleContents;
  }
}
