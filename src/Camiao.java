import java.util.ArrayList;
import java.util.List;

class Camiao {
    private String matricula;
    private int cargaMaxima;
    private String dataInspecao;
    private double custoPorKm;
    private List<Carga> cargas;

    public Camiao(String matricula, int cargaMaxima, String dataInspecao, double custoPorKm) {
        this.matricula = matricula;
        this.cargaMaxima = cargaMaxima;
        this.dataInspecao = dataInspecao;
        this.custoPorKm = custoPorKm;
        this.cargas = new ArrayList<>();
    }

    public String getMatricula() {

        return matricula;
    }

    public int getCargaMaxima() {

        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public String getDataInspecao() {

        return dataInspecao;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDataInspecao(String dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public void setCustoPorKm(double custoPorKm) {
        this.custoPorKm = custoPorKm;
    }

    public double getCustoPorKm() {

        return custoPorKm;
    }

    public List<Carga> getCargas() {

        return cargas;
    }
}