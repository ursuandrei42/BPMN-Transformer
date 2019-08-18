package com.bearnecessities.orders;

import com.adapter.bpmn.camel.CamelAdapter;
import com.adapter.bpmn.camel.CamelAdapterFactory;
import com.adapter.bpmn.model.flowobject.FlowObject;

public class OrderStartEventCamelAdapterFactory implements CamelAdapterFactory {
    @Override
    public CamelAdapter getAdapter(FlowObject flowObject) {
        return new OrderStartEventCamelAdapter(((OrderStartEvent)flowObject).getDirectoryName());
    }
}
