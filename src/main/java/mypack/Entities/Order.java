package mypack.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "order")
  private List<OrderProduct> procducts;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "shipping_addr")
  private String shippingAddr;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<OrderProduct> getProcducts() {
    return procducts;
  }

  public void setProcducts(List<OrderProduct> procducts) {
    this.procducts = procducts;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getShippingAddr() {
    return shippingAddr;
  }

  public void setShippingAddr(String shippingAddr) {
    this.shippingAddr = shippingAddr;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (customerName == null) {
      if (other.customerName != null)
        return false;
    } else if (!customerName.equals(other.customerName))
      return false;
    return true;
  }

}
