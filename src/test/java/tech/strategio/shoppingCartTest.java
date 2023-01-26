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
  public void removeItemNotFound() throws ProductNotFoundException{
    Product unreal = new Product("Golden Ticket", 1.99);
    assertThrows(ProductNotFoundException.class, ()-> shoppingCart.removeItem(unreal));
  }

  @Test

  public void isCartEmpty() {
    shoppingCart.empty();
    assertEquals(0, shoppingCart.getItemCount(), 0.0001);
  }

  public void AddItemUpdateBalance() throws ProductNotFoundException{
    Product unreal = new Product("Golden Ticket", 1.99);
    double oldBalance = shoppingCart.getBalance();
    shoppingCart.addItem(unreal);
    double newBalance = shoppingCart.getBalance();
    assertEquals(newBalance,( oldBalance + unreal.getPrice()));
  }
}
