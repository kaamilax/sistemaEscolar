package EscolaAplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="alunos")
public class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    protected Aluno(){

    }

    public Aluno(String name, String CPF, String email, String matricula, String curso) {
        super(name, CPF, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getCurso() {
        return this.curso;
    }
}