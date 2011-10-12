1
package developerworks.ajax.store;

/**
 * Represents an Item sticked by the store
 */
public class Item {
 
  private String id;
  private String name;
  private String description;
  private int price   ;

  /**
   * Creates an Item
   * @param id Item's unique catalogue identifier
   * @param name Item's name
   * @param description short description of the item
   * @param price price of Item in cents
   */
  public Item(String id, String name, String description, int price) {

    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  /**
   * Returns unique ID of item
   * @return ID of item
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the name of the item
   * @return name of Item
   */
  public String getName() {
    return name;
  }

  /**
   * Returns a short description of the Item
   * @return short description of Item
   */
  public String getDescription() {
    return description;
  }

  /**
   * Return price of Item in cents
   * @return price of Item in cents
   */
  public int getPrice() {
    return price;
  }

  /**
   * Return price of Item formatted for display
   * @return price of Item formatted for display
   */
  public String getFormattedPrice() {
    return Utils.formatCurrency(price);
  }

  /**
   * Tests for equality with another object
   * @param o Object to test for equality
   * @return true if the objects is equal to this Item
   */
  public boolean equals(Object o) {

    if (o==this) return true;
    if (o==null) return false;
    if (!(o instanceof Item)) return false;
    return (((Item)o).getId().equals(id));
  }

  /**
   * @return the hashcode for this Item instance
   */
  public int hashCode() {
    return id.hashCode();
  }
}
