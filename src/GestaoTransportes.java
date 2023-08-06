import java.util.*;
import java.util.stream.Collectors;

class GestaoTransportes {

    private List<Camiao> camioes;

    public GestaoTransportes() {
        this.camioes = new ArrayList<>();
    }

    public void inserirCamiao(Camiao camiao) {
        camioes.add(camiao);
        System.out.println("Camião inserido com sucesso.");
    }

    public void mostrarFrotaDeCamioes() {

        List<Camiao> camioesOrdenados = camioes.stream().sorted(Comparator.comparingInt(Camiao::getCargaMaxima)).collect(Collectors.toList());

        if (camioes.isEmpty()) {
            System.out.println("A frota de camiões está vazia.");
        } else {
            System.out.println("Frota de camiões:");
            for (Camiao camiao : camioes) {
                System.out.println("Matrícula: " + camiao.getMatricula());
                System.out.println("Carga máxima (kg): " + camiao.getCargaMaxima());
                System.out.println("Data próxima inspeção (mês/ano): " + camiao.getDataInspecao());
                System.out.println("Custo por km: " + camiao.getCustoPorKm());
                System.out.println("-----------------------------");
            }
        }
    }

    public void alterarCamiao(String matricula) {
        Camiao camiao = buscarCamiaoPorMatricula(matricula);
        if (camiao != null) {
            // Pedir novos valores para as informações do camião
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nova carga máxima (kg): ");
            int novaCargaMaxima = scanner.nextInt();
            camiao.setCargaMaxima(novaCargaMaxima);

            System.out.print("Nova data próxima inspeção (mês/ano): ");
            String novaDataInspecao = scanner.next();
            camiao.setDataInspecao(novaDataInspecao);

            System.out.print("Novo custo por km: ");
            double novoCustoPorKm = scanner.nextDouble();
            camiao.setCustoPorKm(novoCustoPorKm);

            System.out.println("Informações do camião alteradas com sucesso.");
        } else {
            System.out.println("Camião não encontrado.");
        }
    }

    public void eliminarCamiao(String matricula) {
        Camiao camiao = buscarCamiaoPorMatricula(matricula);
        if (camiao != null) {
            camioes.remove(camiao);
            System.out.println("Camião removido com sucesso.");
        } else {
            System.out.println("Camião não encontrado.");
        }
    }

    private Camiao buscarCamiaoPorMatricula(String matricula) {
        for (Camiao camiao : camioes) {
            if (camiao.getMatricula().equals(matricula)) {
                return camiao;
            }
        }
        return null;
    }

    public void atribuirCargaAoCamiao(Carga carga, Camiao camiao) {
        if (carga.getPeso() <= camiao.getCargaMaxima()) {
            camiao.getCargas().add(carga);
            System.out.println("Carga atribuída ao camião com sucesso.");
        } else {
            System.out.println("Erro: A carga excede a carga máxima do camião.");
        }
    }

    public double calcularCustoCarga(Carga carga) {
        int distancia = carga.getDistancia();
        int peso = carga.getPeso();
        int minimoDistancia = 100;
        int minimoPeso = 1000;
        double tarifaPorDistancia = distancia >= minimoDistancia ? (distancia / minimoDistancia) : 1;
        double tarifaPorPeso = peso >= minimoPeso ? (peso / minimoPeso) : 1;
        double custoCarga = tarifaPorDistancia * 1 + tarifaPorPeso * 50;
        return custoCarga;
    }

    public List<Camiao> obterCamiõesInspecaoMesCorrente(int mesCorrente) {
        List<Camiao> camioesInspecaoMesCorrente = new ArrayList<>();

        // Lógica para obter os camiões com inspeção no mês corrente
        // Percorre a lista de camiões e verifica se a inspeção ocorre no mês corrente
        for (Camiao camiao : camioes) {
            int mesInspecao = Integer.parseInt(camiao.getDataInspecao().split("/")[0]);
            if (mesInspecao == mesCorrente) {
                camioesInspecaoMesCorrente.add(camiao);
            }
        }

        return camioesInspecaoMesCorrente;
    }

    public Camiao encontrarCamiaoPorMatricula(String matricula) {
        for (Camiao camiao : camioes) {
            if (camiao.getMatricula().equals(matricula)) {
                return camiao;
            }
        }
        return null; // Retorna null se o camião não for encontrado
    }

}