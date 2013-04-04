package co.com.drools.example.vacation.tarifa;



import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatelessKnowledgeSession;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;

public class TarifadorVacaciones {

	public void tarifar(CotizacionVacaciones cot) {
		
		StatelessKnowledgeSession ksession = createKSession();
		ksession.execute(cot);
		
	}

	private StatelessKnowledgeSession createKSession(){		
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(new ClassPathResource("tarifa/decisiontables/TableDecisionExample1.xls"),ResourceType.DTABLE);

        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        
        return ksession;
    }

	
	
	
}
