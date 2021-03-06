package com.bpmn.transformer.orders.orders.transformer.camel.element;

import com.bpmn.transformer.camel.CamelAdapter;
import com.bpmn.transformer.camel.CamelAdapterFactory;
import com.bpmn.transformer.model.flowobject.FlowObject;
import com.bpmn.transformer.orders.orders.transformer.flowobject.OrderStartEvent;

public class OrderStartEventCamelAdapterFactory implements CamelAdapterFactory {
    @Override
    public CamelAdapter getAdapter(FlowObject flowObject) {
        return new OrderStartEventCamelAdapter(((OrderStartEvent)flowObject).getDirectoryName());
    }
}
