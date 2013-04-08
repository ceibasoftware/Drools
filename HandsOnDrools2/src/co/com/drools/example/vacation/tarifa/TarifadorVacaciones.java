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

public class TarifadorVacaciones implements ITarifadorVacaciones {

	/* (non-Javadoc)
	 * @see co.com.drools.example.vacation.tarifa.ITarifadorVacaciones#tarifar(co.com.drools.example.vacation.domain.CotizacionVacaciones)
	 */
	@Override
	public void tarifar(CotizacionVacaciones cot) {
		
		StatelessKnowledgeSession ksession = createKSession();
		ksession.execute(cot);
		
	}

	private StatelessKnowledgeSession createKSession(){		
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        ClassPathResource resource = getResourceFromXLS();
        kbuilder.add(resource,resource.getResourceType());

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

	/**
	 * Crea el recurso a partir de un archivo drl
	 * @return
	 */
	private ClassPathResource getResourceFromDRL() {
		ClassPathResource resource = new ClassPathResource("tarifa/drls/tarifaBase.drl");
		resource.setResourceType(ResourceType.DRL);
		return resource;
	}

	
	/**
	 * Crea el recurso a partir de una tabla de excel
	 * @return
	 */
	private ClassPathResource getResourceFromXLS() {
		ClassPathResource resource = new ClassPathResource("tarifa/decisiontables/TableDecisionExample1.xls");
		resource.setResourceType(ResourceType.DTABLE);
		return resource;
	}	
	
}
