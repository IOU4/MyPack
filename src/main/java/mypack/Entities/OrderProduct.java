package mypack.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "order_product")
public class OrderProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int quantity;

  @ManyToOne
  private Order order;

  @ManyToOne
  private Product product;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + quantity;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderProduct other = (OrderProduct) obj;
    if (id != other.id)
      return false;
    if (quantity != other.quantity)
      return false;
    return true;
  }

}
