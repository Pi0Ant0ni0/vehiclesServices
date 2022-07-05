package it.unisannio.jpa;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "nome collezione")
@Data
public class EntityDiProva {
}
