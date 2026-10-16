package EscolaAplication.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
    private String name;
    @Column(name = "cpf")
    private String CPF;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    protected Pessoa(){

    }

    public Pessoa(String name, String CPF, String email) {
        this.setName(name);
        this.setCPF(CPF);
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be void.");
        } else {
            this.name = name;
        }
    }

    public void setCPF(String CPF) {
        if (CPF.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be void.");
        } else {
            this.CPF = CPF;
        }
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCPF() {
        return this.CPF;
    }
}