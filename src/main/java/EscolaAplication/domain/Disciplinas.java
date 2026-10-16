package EscolaAplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="disciplinas")
public class Disciplinas {

    private String name;

    @Column(name="cargaH")
    private int cargaH;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected Disciplinas(){

    }

    public Disciplinas(String name, int cargaH, Professor professor) {
        this.name = name;
        this.cargaH = cargaH;
        this.professor = professor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCargaH(int cargaH) {
        this.cargaH = cargaH;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getName() {
        return this.name;
    }

    public int getCargaH() {
        return this.cargaH;
    }

    public Professor getProfessor() {
        return this.professor;
    }
}