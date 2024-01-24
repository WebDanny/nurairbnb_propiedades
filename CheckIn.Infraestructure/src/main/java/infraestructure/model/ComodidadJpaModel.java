package infraestructure.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "comodidades")
public class ComodidadJpaModel {

  @Id
  @Column(nullable = false)
  public UUID id;

  @Column(nullable = false)
  public String nombre;

  @ManyToOne private PropiedadJpaModel propiedades;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public PropiedadJpaModel getPropiedades() {
    return propiedades;
  }

  public void setPropiedades(PropiedadJpaModel propiedades) {
    this.propiedades = propiedades;
  }
}
