package com.example.exercises.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDTO {
    @XmlElement(name = "user")
    List<UserSeedDTO> userSeedDTOList;

    public UserSeedRootDTO() {
    }

    public List<UserSeedDTO> getUserSeedDTOList() {
        return userSeedDTOList;
    }

    public void setUserSeedDTOList(List<UserSeedDTO> userSeedDTOList) {
        this.userSeedDTOList = userSeedDTOList;
    }
}
