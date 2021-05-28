package RGR.Gallery.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tags implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tagsId;
    private String name;

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
