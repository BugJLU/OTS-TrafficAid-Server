package org.bugjlu.ots_server.web.vo;

public class ContactCommand {

    String subjectId;
    String objectId;
    Integer groupType; // 1 relative; 2 friend; 3 colleague;
    Double intimacy; // between 0 and 1;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Double getIntimacy() {
        return intimacy;
    }

    public void setIntimacy(Double intimacy) {
        this.intimacy = intimacy;
    }
}
