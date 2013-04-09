package co.com.drools.example.vacation.tarifa;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;

public class TarifadorVacaciones implements ITarifadorVacaciones {

	@Override
	public void tarifar(CotizacionVacaciones cot) {
		try {
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(new ClassPathResource("tarifa/decisiontables/TableDecisionExample1.xls"), 
						ResourceType.DTABLE);
			
			KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
			
			StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			
			ksession.insert(cot);
			ksession.fireAllRules();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
}
