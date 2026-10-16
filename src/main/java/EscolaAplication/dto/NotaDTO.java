package EscolaAplication.dto;

public class NotaDTO {
    private Integer matriculaId;
    private double valor;
    private String avaliacao;

    protected NotaDTO(){
    }

    public NotaDTO(Integer matriculaId, double valor, String avaliacao){
        this.matriculaId = matriculaId;
        this.valor = valor;
        this.avaliacao = avaliacao;

    }

    public double getValor() {
        return valor;
    }

    public Integer getMatriculaId() {
        return matriculaId;
    }

    public String getAvaliacao() {
        return avaliacao;
    }
}
