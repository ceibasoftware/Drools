package co.com.drools.example.vacation.tarifa;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;

public interface ITarifadorVacaciones {

	public abstract void tarifar(CotizacionVacaciones cot);

}