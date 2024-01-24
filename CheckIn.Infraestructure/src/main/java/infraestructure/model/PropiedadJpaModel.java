package infraestructure.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "propiedades")
public class PropiedadJpaModel {

  @Id
  @Column(name = "id", nullable = false)
  public UUID id;

  @Column(nullable = false)
  public String nombre;

  @Column(name = "estado", nullable = false)
  public String estado;

  @Column(nullable = false)
  public double precio;

  @Column(nullable = false)
  UUID tipoPropiedadId;

  @OneToMany(mappedBy = "propiedades", cascade = CascadeType.REMOVE)
  private List<ComodidadJpaModel> comodidades = new ArrayList<>();

  @Column(name = "descripcion", nullable = true)
  public String descripcion;

  @Column(name = "hora_checkout", nullable = false)
  public String hora_checkout;

  @Column(name = "hora_checkin", nullable = false)
  public String hora_checkin;

  @Column(name = "image", nullable = true)
  private String image;

  public UUID getTipoPropiedadId() {
    return tipoPropiedadId;
  }

  public void setTipoPropiedadId(UUID tipoPropiedadId) {
    this.tipoPropiedadId = tipoPropiedadId;
  }

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

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public List<ComodidadJpaModel> getComodidades() {
    return comodidades;
  }

  public void setComodidades(List<ComodidadJpaModel> comodidades) {
    this.comodidades = comodidades;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getHora_checkout() {
    return hora_checkout;
  }

  public void setHora_checkout(String hora_checkout) {
    this.hora_checkout = hora_checkout;
  }

  public String getHora_checkin() {
    return hora_checkin;
  }

  public void setHora_checkin(String hora_checkin) {
    this.hora_checkin = hora_checkin;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
