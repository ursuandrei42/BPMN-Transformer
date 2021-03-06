package com.bpmn.transformer.camel;

import com.bpmn.transformer.model.BusinessProcess;

import java.util.List;

public class BPMNCamelApp {
    private List<BusinessProcess> businessProcesses;


    public BPMNCamelApp(List<BusinessProcess> businessProcesses) {
        if (businessProcesses == null || businessProcesses.isEmpty()) {
            throw new IllegalArgumentException("Your app does not have any Business Processes defined!");
        }

        this.businessProcesses = businessProcesses;
    }

    public List<BusinessProcess> getBusinessProcesses() {
        return businessProcesses;
    }


}
