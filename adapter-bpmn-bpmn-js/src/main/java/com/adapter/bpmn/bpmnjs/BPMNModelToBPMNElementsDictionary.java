package com.adapter.bpmn.bpmnjs;

import com.adapter.bpmn.bpmnjs.activity.NamedActivityBPMNElementAdapterFactory;
import com.adapter.bpmn.bpmnjs.endevent.NamedEndEventBPMNElementAdapterFactory;
import com.adapter.bpmn.bpmnjs.exclusivegateway.ExclusiveGatewayBPMNElementAdapterFactory;
import com.adapter.bpmn.bpmnjs.startevent.StartFromBPMNElementAdapterFactory;
import com.adapter.bpmn.model.Dictionary;
import com.adapter.bpmn.model.flowobject.FlowObject;
import com.adapter.bpmn.model.flowobject.activity.NamedActivity;
import com.adapter.bpmn.model.flowobject.endevent.NamedEndEvent;
import com.adapter.bpmn.model.flowobject.exclusivegateway.ExclusiveGateway;
import com.adapter.bpmn.model.flowobject.startevent.UriStartEvent;

import java.util.HashMap;
import java.util.Map;

public class BPMNModelToBPMNElementsDictionary implements Dictionary {

   private final Map<Class<? extends FlowObject>, BPMNElementAdapterFactory> dictionary;

    public BPMNModelToBPMNElementsDictionary() {
        dictionary = new HashMap<>();
        dictionary.put(UriStartEvent.class, new StartFromBPMNElementAdapterFactory());
        dictionary.put(NamedActivity.class, new NamedActivityBPMNElementAdapterFactory());
        dictionary.put(ExclusiveGateway.class, new ExclusiveGatewayBPMNElementAdapterFactory());
        dictionary.put(NamedEndEvent.class, new NamedEndEventBPMNElementAdapterFactory());
    }

    public BPMNElementAdapter getAdapter(FlowObject flowObject) {
        return dictionary.get(flowObject.getClass()).getAdapter(flowObject);
    }

    public Map<Class<? extends FlowObject>, BPMNElementAdapterFactory> getDictionary() {
        return dictionary;
    }
}
