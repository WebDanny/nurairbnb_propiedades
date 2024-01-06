package infraestructure.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "check_in")
public class CheckInJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(name = "prop_id", nullable = false)
  private UUID propiedadId;

  @Column(nullable = false)
  private Date date;

  @OneToOne(optional = true)
  private PropiedadJpaModel propiedad;

  public PropiedadJpaModel getPropiedad() {
    return propiedad;
  }

  public void setPropiedad(PropiedadJpaModel propiedad) {
    this.propiedad = propiedad;
  }

  @OneToOne private PersonaJpaModel persona;

  public CheckInJpaModel() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public UUID getPropiedadId() {
    return propiedadId;
  }

  public void setPropiedadId(UUID propiedadId) {
    this.propiedadId = propiedadId;
  }

  public PersonaJpaModel getPersona() {
    return persona;
  }

  public void setPersona(PersonaJpaModel persona) {
    this.persona = persona;
  }
}
