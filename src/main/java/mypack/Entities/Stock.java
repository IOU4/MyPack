package mypack.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int capacity;
  private String addr;

  @OneToMany(mappedBy = "stock", cascade = CascadeType.PERSIST)
  private List<StockProduct> products;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manager_id")
  private Manager manager;

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public List<StockProduct> getProducts() {
    return products;
  }

  public void setProducts(List<StockProduct> products) {
    this.products = products;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + capacity;
    result = prime * result + ((addr == null) ? 0 : addr.hashCode());
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
    Stock other = (Stock) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (capacity != other.capacity)
      return false;
    if (addr == null) {
      if (other.addr != null)
        return false;
    } else if (!addr.equals(other.addr))
      return false;
    return true;
  }

}
