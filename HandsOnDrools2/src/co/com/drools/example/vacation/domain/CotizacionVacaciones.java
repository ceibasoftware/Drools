package co.com.drools.example.vacation.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CotizacionVacaciones {
	private String plan;
	private String ciudad;
	private String modalidad;
	private int tarifaBase;
	private Date feinicio;
	private Date fefin;
	private int descuento;
	
	public Date getFeinicio() {
		return feinicio;
	}

	public void setFeinicio(Date feinicio) {
		this.feinicio = feinicio;
	}

	public Date getFefin() {
		return fefin;
	}

	public void setFefin(Date fefin) {
		this.fefin = fefin;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public CotizacionVacaciones(){
	}
	
	public CotizacionVacaciones(String plan, String ciudad, String modalidad){
		this.plan = plan;
		this.ciudad = ciudad;
		this.modalidad = modalidad;
		this.feinicio = new Date();
		this.fefin = new Date();
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
	
	public boolean before(String date){
		try {
			return this.fefin.before(new SimpleDateFormat("yyyy-mm-dd").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean after(String date){
		try {
			return this.feinicio.after(new SimpleDateFormat("yyyy-mm-dd").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
}
