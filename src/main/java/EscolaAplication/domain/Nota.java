package EscolaAplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="notas")
public class Nota {

    private double valor;
    private String avaliacao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="matricula_id")
    @JsonIgnore
    private Matricula matricula;

    protected Nota(){

    }

    public Nota(double valor, String avaliacao, Matricula matricula) {
        this.valor = valor;
        this.avaliacao = avaliacao;
        this.matricula = matricula;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public int getId() {
        return this.id;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return this.matricula;
    }
}

