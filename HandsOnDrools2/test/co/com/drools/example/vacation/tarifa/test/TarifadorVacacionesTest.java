package co.com.drools.example.vacation.tarifa.test;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.drools.io.impl.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;
import co.com.drools.example.vacation.tarifa.ITarifadorVacaciones;
import co.com.drools.example.vacation.tarifa.TarifadorVacaciones;
import co.com.drools.example.vacation.tarifa.TarifadorVacacionesGuvnor;




public class TarifadorVacacionesTest {
	
	/**
	 * Obtiene la instancia del Tarifador con el cual vamos a trabajar
	 * @return
	 */
	private ITarifadorVacaciones getTarifadorVacaciones() {
		return new TarifadorVacacionesGuvnor();
	}
	
	@Test
	public void testTodoICartagenaInd(){
		try{
			ITarifadorVacaciones t = getTarifadorVacaciones();
			CotizacionVacaciones cot = new CotizacionVacaciones("Todo Incluido","CARTAGENA","Individual");
	
			t.tarifar(cot);		
			Assert.assertEquals("Tarifa para todo incluido - Cartagena - Individual", 100, cot.getTarifaBase());
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testHDStaMartaFam(){
		try{
			ITarifadorVacaciones t = getTarifadorVacaciones();
			CotizacionVacaciones cot = new CotizacionVacaciones("HospedajeDesayuno","SANTA MARTA","Familiar");
	
			t.tarifar(cot);		
			Assert.assertEquals("Tarifa para hosp + desayuna - Santa marta - Familiar", 90, cot.getTarifaBase());
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
}
