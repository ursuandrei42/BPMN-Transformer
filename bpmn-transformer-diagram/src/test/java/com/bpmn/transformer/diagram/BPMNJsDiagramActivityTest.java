package com.bpmn.transformer.diagram;

import com.bpmn.transformer.model.BusinessProcess;
import com.bpmn.transformer.model.flowobject.activity.NamedActivity;
import com.bpmn.transformer.model.flowobject.startevent.UriStartEvent;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BPMNJsDiagramActivityTest {

    private final BPMNModelToBPMNElementsDictionary dictionary = new BPMNModelToBPMNElementsDictionary();

    @Test
    public void testBusinessProcessesWithStartEventAndActivity() throws Exception {
        ArrayList<BusinessProcess> businessProcesses = new ArrayList<>();
        businessProcesses.add(new BusinessProcess(new UriStartEvent("My Start Event"), new NamedActivity("This is an activity")));
        BPMNJsDiagram diagram = new BPMNJsDiagram();

        String xml = diagram.asXml(businessProcesses, new BPMNModelToBPMNElementsDictionary());

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<definitions xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"definitions\" targetNamespace=\"http://camunda.org/examples\" xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\">\n" +
                "  <process id=\"ProjectName\">\n" +
                "    <startEvent id=\"element_0\" name=\"My Start Event\">\n" +
                "      <outgoing>element_0-element_1</outgoing>\n" +
                "    </startEvent>\n" +
                "    <task id=\"element_1\" name=\"This is an activity\">\n" +
                "      <incoming>element_0-element_1</incoming>\n" +
                "    </task>\n" +
                "    <sequenceFlow id=\"element_0-element_1\" name=\"\" sourceRef=\"element_0\" targetRef=\"element_1\"/>\n" +
                "  </process>\n" +
                "  <bpmndi:BPMNDiagram id=\"BPMNDiagram\">\n" +
                "    <bpmndi:BPMNPlane bpmnElement=\"ProjectName\" id=\"BPMNPlane\">\n" +
                "      <bpmndi:BPMNShape bpmnElement=\"element_0\" id=\"element_0_shape\">\n" +
                "        <dc:Bounds height=\"50.0\" width=\"50.0\" x=\"15.0\" y=\"20.0\"/>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNShape bpmnElement=\"element_1\" id=\"element_1_shape\">\n" +
                "        <dc:Bounds height=\"80.0\" width=\"150.0\" x=\"200.0\" y=\"10.0\"/>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"element_0-element_1\" id=\"edge_element_0-element_1\">\n" +
                "        <di:waypoint x=\"65.0\" y=\"45.0\"/>\n" +
                "        <di:waypoint x=\"200.0\" y=\"45.0\"/>\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "    </bpmndi:BPMNPlane>\n" +
                "  </bpmndi:BPMNDiagram>\n" +
                "</definitions>\n" +
                "\n";

        TestHelper.assertEqualsIgnoreLineEndings(xml, expected);
    }

    @Test
    public void testBusinessProcessesWithStartEventAndTwoActivity() throws Exception {
        ArrayList<BusinessProcess> businessProcesses = new ArrayList<>();
        businessProcesses.add(new BusinessProcess(new UriStartEvent("My Start Event"), new NamedActivity("This is an activity"), new NamedActivity("This is an activity")));
        BPMNJsDiagram diagram = new BPMNJsDiagram();

        String xml = diagram.asXml(businessProcesses, dictionary);

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<definitions xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"definitions\" targetNamespace=\"http://camunda.org/examples\" xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\">\n" +
                "  <process id=\"ProjectName\">\n" +
                "    <startEvent id=\"element_0\" name=\"My Start Event\">\n" +
                "      <outgoing>element_0-element_1</outgoing>\n" +
                "    </startEvent>\n" +
                "    <task id=\"element_1\" name=\"This is an activity\">\n" +
                "      <incoming>element_0-element_1</incoming>\n" +
                "      <outgoing>element_1-element_2</outgoing>\n" +
                "    </task>\n" +
                "    <sequenceFlow id=\"element_0-element_1\" name=\"\" sourceRef=\"element_0\" targetRef=\"element_1\"/>\n" +
                "    <task id=\"element_2\" name=\"This is an activity\">\n" +
                "      <incoming>element_1-element_2</incoming>\n" +
                "    </task>\n" +
                "    <sequenceFlow id=\"element_1-element_2\" name=\"\" sourceRef=\"element_1\" targetRef=\"element_2\"/>\n" +
                "  </process>\n" +
                "  <bpmndi:BPMNDiagram id=\"BPMNDiagram\">\n" +
                "    <bpmndi:BPMNPlane bpmnElement=\"ProjectName\" id=\"BPMNPlane\">\n" +
                "      <bpmndi:BPMNShape bpmnElement=\"element_0\" id=\"element_0_shape\">\n" +
                "        <dc:Bounds height=\"50.0\" width=\"50.0\" x=\"15.0\" y=\"20.0\"/>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNShape bpmnElement=\"element_1\" id=\"element_1_shape\">\n" +
                "        <dc:Bounds height=\"80.0\" width=\"150.0\" x=\"200.0\" y=\"10.0\"/>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"element_0-element_1\" id=\"edge_element_0-element_1\">\n" +
                "        <di:waypoint x=\"65.0\" y=\"45.0\"/>\n" +
                "        <di:waypoint x=\"200.0\" y=\"45.0\"/>\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "      <bpmndi:BPMNShape bpmnElement=\"element_2\" id=\"element_2_shape\">\n" +
                "        <dc:Bounds height=\"80.0\" width=\"150.0\" x=\"400.0\" y=\"10.0\"/>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"element_1-element_2\" id=\"edge_element_1-element_2\">\n" +
                "        <di:waypoint x=\"350.0\" y=\"45.0\"/>\n" +
                "        <di:waypoint x=\"400.0\" y=\"45.0\"/>\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "    </bpmndi:BPMNPlane>\n" +
                "  </bpmndi:BPMNDiagram>\n" +
                "</definitions>\n" +
                "\n";

        TestHelper.assertEqualsIgnoreLineEndings(xml, expected);
    }

}
