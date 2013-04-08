package co.com.drools.example.vacation.tarifa;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatelessKnowledgeSession;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;

public class TarifadorVacacionesGuvnor implements ITarifadorVacaciones{
	
	/* (non-Javadoc)
	 * @see co.com.drools.example.vacation.tarifa.ITarifadorVacaciones#tarifar(co.com.drools.example.vacation.domain.CotizacionVacaciones)
	 */
	@Override
	public void tarifar(CotizacionVacaciones cot) {
		
		StatelessKnowledgeSession ksession = createKSessionFromGuvnor();
		ksession.execute(cot);
		
	}
	
	private StatelessKnowledgeSession createKSessionFromGuvnor(){		
		
		KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent( "MyAgent" );
		kagent.applyChangeSet( ResourceFactory.newClassPathResource( "tarifa/changesets/change-set.xml" ) );
		KnowledgeBase kbase = kagent.getKnowledgeBase();
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        
        ResourceFactory.getResourceChangeNotifierService().start();

        ResourceFactory.getResourceChangeScannerService().start();
        
        return ksession;
    }
}
