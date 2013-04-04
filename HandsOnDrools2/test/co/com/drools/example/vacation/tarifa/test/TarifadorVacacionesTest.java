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
import co.com.drools.example.vacation.tarifa.TarifadorVacaciones;




public class TarifadorVacacionesTest {

	@Test
	public void testTodoICartagenaFam(){
		printDrl();
		TarifadorVacaciones t = new TarifadorVacaciones();
		CotizacionVacaciones cot = new CotizacionVacaciones("Todo Incluido","CARTAGENA","Familiar");
	
		t.tarifar(cot);		
		Assert.assertEquals("Tarifa para todo incluido - Cartagena - Familiar", 80, cot.getTarifaBase());
	}

	@Test
	public void testDescuentoTemporadaBaja(){
		printDrl();
		TarifadorVacaciones t = new TarifadorVacaciones();
		CotizacionVacaciones cot = new CotizacionVacaciones();
		try{
			cot.setFeinicio(new SimpleDateFormat("yyyymmdd").parse("20140120"));
			cot.setFefin(new SimpleDateFormat("yyyymmdd").parse("20140601"));
		}catch(ParseException e){
			e.printStackTrace();
		}		
	
		t.tarifar(cot);		
		Assert.assertEquals("Descuento temporada baja", 20, cot.getDescuento());
	}
	
	
	/**
	 * Método para imprimir el drl en out de system
	 */
	private void printDrl(){
		try {
			SpreadsheetCompiler compiler = new SpreadsheetCompiler();
			String drl = compiler.compile(new ClassPathResource("tarifa/decisiontables/TableDecisionExample1.xls").getInputStream(), InputType.XLS);
			System.out.println(drl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
