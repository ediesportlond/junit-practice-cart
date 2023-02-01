package tech.strategio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class shoppingCartTest {

  private ShoppingCart shoppingCart;

  @BeforeEach
  public void createCart() {
    shoppingCart = new ShoppingCart();
  }

  @Test
  public void emptyTest() {
    assertEquals(true, true);
  }

  @Test
  public void zeroItemsWhenCreated() {
    assertEquals(0, shoppingCart.getItemCount());
  }

  @Test
  public void testAddItems() {
    Product test_product = new Product("item1", 10.99);
    shoppingCart.addItem(test_product);
    assertEquals(1, shoppingCart.getItemCount());
  }

  @Test
  public void testRemovetems() throws ProductNotFoundException{
    Product test_product = new Product("item1", 10.99);
    shoppingCart.addItem(test_product);
    shoppingCart.removeItem(test_product);

    assertEquals(0, shoppingCart.getItemCount());
  }

  @Test
  public void removeItemNotFound() throws ProductNotFoundException{
    Product unreal = new Product("Golden Ticket", 1.99);
    assertThrows(ProductNotFoundException.class, ()-> shoppingCart.removeItem(unreal));
  }

  @Test
  public void isCartEmpty() {
    shoppingCart.empty();
    assertEquals(0, shoppingCart.getItemCount(), 0.0001);
  }

  @Test
  public void AddItemUpdateBalance() throws ProductNotFoundException{
    Product unreal = new Product("Golden Ticket", 1.99);
    double oldBalance = shoppingCart.getBalance();
    shoppingCart.addItem(unreal);
    double newBalance = shoppingCart.getBalance();
    assertEquals(newBalance,( oldBalance + unreal.getPrice()));
  }
}
