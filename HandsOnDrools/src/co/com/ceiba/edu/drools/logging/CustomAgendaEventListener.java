package co.com.ceiba.edu.drools.logging;

import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.AgendaGroupPoppedEvent;
import org.drools.event.rule.AgendaGroupPushedEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.RuleFlowGroupActivatedEvent;
import org.drools.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomAgendaEventListener implements AgendaEventListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomAgendaEventListener.class);

    public void activationCancelled(ActivationCancelledEvent event) {
        logger.info("Activation Cancelled: " + event.getActivation());
    }

    public void activationCreated(ActivationCreatedEvent event) {
        logger.info("Activation Created: " + event.getActivation());
    }

    public void beforeActivationFired(BeforeActivationFiredEvent event) {
        logger.info("Before Activation Fired: " + event.getActivation());
    }

    public void afterActivationFired(AfterActivationFiredEvent event) {
        logger.info("After Activation Fired: " + event.getActivation());
    }

    public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
        logger.info("Agenda Group Popped: " + event.getAgendaGroup());
    }

    public void agendaGroupPushed(AgendaGroupPushedEvent event) {
        logger.info("Agenda Group Pushed: " + event.getAgendaGroup());
    }

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		 logger.info("Rule Group Activated: " + event.getRuleFlowGroup());
		
	}

	@Override
	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		logger.info("Rule Group DeActivated: " + event.getRuleFlowGroup());
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		logger.info("Rule Group will be Activated: " + event.getRuleFlowGroup());
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		 logger.info("Rule Group will be Activated: " + event.getRuleFlowGroup());
		
	}

}
