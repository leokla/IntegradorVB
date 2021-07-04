package org.acme.getting.response;

import org.acme.getting.model.OperatorPerform;

import java.util.ArrayList;
import java.util.List;

public class OperatorPerformResponse {

    private List<OperatorPerform> operatorPerformList = new ArrayList<>();

    public List<OperatorPerform> getOperatorPerformList() {
        return operatorPerformList;
    }

    public void setOperatorPerformList(List<OperatorPerform> operatorPerformList) {
        this.operatorPerformList = operatorPerformList;
    }
}
