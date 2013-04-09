package co.com.drools.example.vacation.tarifa;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.definition.KnowledgeDefinition.KnowledgeType;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import co.com.drools.example.vacation.domain.CotizacionVacaciones;

public class TarifadorVacacionesGuvnor implements ITarifadorVacaciones{

	@Override
	public void tarifar(CotizacionVacaciones cot) {
		KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent("MiAgente");
		
		kagent.applyChangeSet(ResourceFactory.newClassPathResource("tarifa/changesets/change-set.xml"));
		KnowledgeBase kbase = kagent.getKnowledgeBase();
		StatefulKnowledgeSession ksesion =  kbase.newStatefulKnowledgeSession();
		
		ksesion.insert(cot);
		ksesion.fireAllRules();
		
	}
}
