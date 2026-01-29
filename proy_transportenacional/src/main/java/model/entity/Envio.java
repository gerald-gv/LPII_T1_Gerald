package model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "envio")
public class Envio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nro_guia;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha_despacho;
	
	@ManyToOne
	@JoinColumn(name = "id_transp", nullable = false)
	private Transporte transporte;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal peso_paquete;
	
	@Column(nullable = false, length = 150)
	private String destino_final;
	
	@Transient
	private int codigoInterno;
	
	public Envio() {
		
	}

	public Date getFecha_despacho() {
		return fecha_despacho;
	}

	public void setFecha_despacho(Date fecha_despacho) {
		this.fecha_despacho = fecha_despacho;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public BigDecimal getPeso_paquete() {
		return peso_paquete;
	}

	public void setPeso_paquete(BigDecimal peso_paquete) {
		this.peso_paquete = peso_paquete;
	}

	public String getDestino_final() {
		return destino_final;
	}

	public void setDestino_final(String destino_final) {
		this.destino_final = destino_final;
	}

	public int getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(int codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	
	
	
}
