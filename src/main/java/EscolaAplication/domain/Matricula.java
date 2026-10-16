package EscolaAplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name="matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="disciplina_id")
    private Disciplinas disciplinas;

    @OneToMany(mappedBy = "matricula")
    private List<Nota> notas = new ArrayList<>();


    protected Matricula(){
    }

    public Matricula(Aluno aluno, Disciplinas disciplinas) {
        this.aluno = aluno;
        this.disciplinas = disciplinas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplinas getDisciplinas() {
        return this.disciplinas;
    }

    public List<Nota> getNotas() {
        return notas;
    }
}
