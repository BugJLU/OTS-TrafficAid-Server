package org.bugjlu.ots_server.po;

public class Contact {
    String contactId;
    Integer group; // 1 relative; 2 friend; 3 colleague;
    Double intimacy; // between 0 and 1;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Double getIntimacy() {
        return intimacy;
    }

    public void setIntimacy(Double intimacy) {
        this.intimacy = intimacy;
    }
}
