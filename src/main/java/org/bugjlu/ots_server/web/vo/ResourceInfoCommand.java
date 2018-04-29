package org.bugjlu.ots_server.web.vo;

public class ResourceInfoCommand {

    Integer id;
    Integer type;   // 1 ; 2 ;
    String possessorId;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPossessorId() {
        return possessorId;
    }

    public void setPossessorId(String possessorId) {
        this.possessorId = possessorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
