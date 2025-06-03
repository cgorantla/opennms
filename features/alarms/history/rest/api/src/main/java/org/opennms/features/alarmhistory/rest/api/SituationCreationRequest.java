package org.opennms.features.alarmhistory.rest.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "situationCreationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SituationCreationRequest {

    @XmlElement(name = "alarmId")
    private String alarmId;

    @XmlElement(name = "situationDetails")
    private String situationDetails;

    public SituationCreationRequest() {
    }

    public SituationCreationRequest(String alarmId, String situationDetails) {
        this.alarmId = alarmId;
        this.situationDetails = situationDetails;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getSituationDetails() {
        return situationDetails;
    }

    public void setSituationDetails(String situationDetails) {
        this.situationDetails = situationDetails;
    }
}
