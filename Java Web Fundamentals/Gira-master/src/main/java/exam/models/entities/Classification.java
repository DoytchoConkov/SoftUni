package exam.models.entities;

import exam.models.entities.enums.ClassificaionName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{
    private ClassificaionName name;
    private String description;

    public Classification() {
    }

    public Classification(ClassificaionName name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public ClassificaionName getName() {
        return name;
    }

    public void setName(ClassificaionName name) {
        this.name = name;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
