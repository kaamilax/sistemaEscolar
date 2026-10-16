package EscolaAplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="professores")
public class Professor extends Pessoa {
    private String especialidade;
    private String matricula;

    protected Professor(){

    }

    public Professor(String name, String CPF, String email, String especialidade, String matricula) {
        super(name, CPF, email);
        this.matricula = matricula;
        this.especialidade = especialidade;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }
}