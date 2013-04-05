package co.com.drools.example.vacation.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CotizacionVacaciones {
	private String plan;
	private String ciudad;
	private String modalidad;
	private int tarifaBase;

	public CotizacionVacaciones(){
	}
	
	public CotizacionVacaciones(String plan, String ciudad, String modalidad){
		this.plan = plan;
		this.ciudad = ciudad;
		this.modalidad = modalidad;
	}
	
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public int getTarifaBase() {
		return tarifaBase;
	}
	public void setTarifaBase(int tarifaBase) {
		this.tarifaBase = tarifaBase;
	}
}
