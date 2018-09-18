package org.zer0.pocs.caffeine.demoCaffeine.data;

public class Datos {

	private String clave;
	private String datosSinMapear;
	private String datosMapedos;
	
	public Datos() {
		// TODO Auto-generated constructor stub
	}
	
	public Datos(String clave, String datosSinMapear) {
		super();
		this.clave = clave;
		this.datosSinMapear = datosSinMapear;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDatosSinMapear() {
		return datosSinMapear;
	}
	public void setDatosSinMapear(String datosSinMapear) {
		this.datosSinMapear = datosSinMapear;
	}
	public String getDatosMapedos() {
		return datosMapedos;
	}
	public void setDatosMapedos(String datosMapedos) {
		this.datosMapedos = datosMapedos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((datosMapedos == null) ? 0 : datosMapedos.hashCode());
		result = prime * result + ((datosSinMapear == null) ? 0 : datosSinMapear.hashCode());
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
		Datos other = (Datos) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (datosMapedos == null) {
			if (other.datosMapedos != null)
				return false;
		} else if (!datosMapedos.equals(other.datosMapedos))
			return false;
		if (datosSinMapear == null) {
			if (other.datosSinMapear != null)
				return false;
		} else if (!datosSinMapear.equals(other.datosSinMapear))
			return false;
		return true;
	}
	
}
