package com.adapter.bpmn.bpmnjs.startevent;

import com.adapter.bpmn.bpmnjs.BPMNElementAdapter;
import com.adapter.bpmn.bpmnjs.BPMNElementAdapterFactory;
import com.adapter.bpmn.model.flowobject.FlowObject;
import com.adapter.bpmn.model.flowobject.startevent.StartFrom;

public class StartFromBPMNElementAdapterFactory implements BPMNElementAdapterFactory {
    @Override
    public BPMNElementAdapter getAdapter(FlowObject flowObject) {
        return new StartFromBPMNElementAdapter(((StartFrom)flowObject).getUri());
    }
}