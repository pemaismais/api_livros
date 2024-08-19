package app.crud.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonTypeName("livro")
public class Livro extends EntidadeBibliografica {
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

}
