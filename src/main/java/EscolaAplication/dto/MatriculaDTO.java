package EscolaAplication.dto;

public class MatriculaDTO {
    private String alunoMatricula;
    private Integer disciplinaId;

    protected MatriculaDTO(){
    }

    public MatriculaDTO(String alunoMatricula, Integer disciplinaId){
        this.alunoMatricula = alunoMatricula;
        this.disciplinaId = disciplinaId;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public String getAlunoMatricula() {
        return alunoMatricula;
    }
}
