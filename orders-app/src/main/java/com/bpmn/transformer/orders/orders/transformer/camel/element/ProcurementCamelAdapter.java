package com.bpmn.transformer.orders.orders.transformer.camel.element;

import com.bpmn.transformer.camel.BPMNToCamelDictionary;
import com.bpmn.transformer.camel.CamelAdapter;
import org.apache.camel.model.ProcessorDefinition;

public class ProcurementCamelAdapter implements CamelAdapter {
    private String message;

    public ProcurementCamelAdapter(String message) {
        this.message = message;
    }

    @Override
    public void adapt(ProcessorDefinition processorDefinition, BPMNToCamelDictionary dictionary) {
        processorDefinition.log(String.format(message, "${exchangeProperty.order.body}"));
    }
}
