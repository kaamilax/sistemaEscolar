package EscolaAplication.dto;


public class DisciplinasDTO {
    private String name;
    private int cargaH;
    private String professorMatricula;


    protected DisciplinasDTO(){
    }

    public DisciplinasDTO(String name, int cargaH, String professorMatricula) {
        this.name = name;
        this.cargaH = cargaH;
        this.professorMatricula = professorMatricula;
    }

    public String getName() {
        return name;
    }

    public int getCargaH() {
        return cargaH;
    }

    public String getProfessorMatricula() {
        return professorMatricula;
    }
}
