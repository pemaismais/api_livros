package app.crud.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@JsonTypeName("revista")
public class Revista extends EntidadeBibliografica {

}

