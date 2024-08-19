package app.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable
public class Endereco {
    private String cidade;
    private String rua;

    @Pattern(regexp = "^\\d{5}(-\\d{3})?$", message = "CEP inválido")
    private String cep;
}
