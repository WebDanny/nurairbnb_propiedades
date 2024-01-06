package infraestructure.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "metodopago")
public class MetodoPagoJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String detalle;

  @Column(nullable = false)
  private String tipo;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }
}
