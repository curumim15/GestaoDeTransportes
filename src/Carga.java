class Carga {
    private String nomeCliente;
    private String localOrigem;
    private String localDestino;
    private int distancia;
    private int peso;

    public Carga(String nomeCliente, String localOrigem, String localDestino, int distancia, int peso) {
        this.nomeCliente = nomeCliente;
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.distancia = distancia;
        this.peso = peso;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getPeso() {
        return peso;
    }
}