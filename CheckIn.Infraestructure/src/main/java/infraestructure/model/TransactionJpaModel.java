package infraestructure.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transacciones")
public class TransactionJpaModel {

  @Id
  @Column(nullable = false)
  private UUID code;

  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private double monto;

  public UUID getCode() {
    return code;
  }

  public void setCode(UUID code) {
    this.code = code;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }
}
