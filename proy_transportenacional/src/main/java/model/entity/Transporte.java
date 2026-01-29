package model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transporte")
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_transp;
	
	@Column(nullable = false, length = 45)
	private String placa_vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal", nullable = false)
	private Sucursal sucursal;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal capacidad_kg;
	
	
	public Transporte() {
		
	}

	public String getPlaca_vehiculo() {
		return placa_vehiculo;
	}




	public void setPlaca_vehiculo(String placa_vehiculo) {
		this.placa_vehiculo = placa_vehiculo;
	}




	public Sucursal getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}


	public BigDecimal getCapacidad_kg() {
		return capacidad_kg;
	}


	public void setCapacidad_kg(BigDecimal capacidad_kg) {
		this.capacidad_kg = capacidad_kg;
	}
	
	
	
}
