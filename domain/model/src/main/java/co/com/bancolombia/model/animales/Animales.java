package co.com.bancolombia.model.animales;
import lombok.*;
//import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animales {
    private String id;
    private String animalesname;
    private String habitat;
    private boolean genero;
    private int numpatas;
    private boolean domesticos;
}
