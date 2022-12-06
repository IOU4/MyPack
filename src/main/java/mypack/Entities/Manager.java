package mypack.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "manager")
public class Manager extends Employee {

  @OneToOne
  @JoinColumn(name = "stock_id")
  private Stock stock;

  public Stock getStock() {
    return stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((stock == null) ? 0 : stock.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Manager other = (Manager) obj;
    if (stock == null) {
      if (other.stock != null)
        return false;
    } else if (!stock.equals(other.stock))
      return false;
    return true;
  }

}
