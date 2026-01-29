package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_sucursal;
	
	@Column(nullable = false, length = 45)
	private String nombre_ciudad;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 45)
	private EnumSucursal tipo_almacen;
	
	public Sucursal() {
		
	}
	
	

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}



	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}



	public EnumSucursal getTipo_almacen() {
		return tipo_almacen;
	}

	public void setTipo_almacen(EnumSucursal tipo_almacen) {
		this.tipo_almacen = tipo_almacen;
	}

	
	
	
}
