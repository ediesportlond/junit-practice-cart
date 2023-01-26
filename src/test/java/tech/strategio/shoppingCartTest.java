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
  public void removeItemNotFound() throws ProductNotFoundException{
    Product unreal = new Product("Golden Ticket", 1.99);
    assertThrows(ProductNotFoundException.class, ()-> shoppingCart.removeItem(unreal));
  }
}