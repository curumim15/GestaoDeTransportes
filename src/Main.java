import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[]args){
            GestaoTransportes gestaoTransportes = new GestaoTransportes();
            Scanner scanner = new Scanner(System.in);

            int opcao = 0;
            while (opcao != 8) {
                System.out.println("----- Menu -----");
                System.out.println("| 1 - Inserir camião");
                System.out.println("| 2 - Mostrar frota de camiões");
                System.out.println("| 3 - Alterar informações de um camião");
                System.out.println("| 4 - Excluir um camião");
                System.out.println("| 5 - Atribuir carga a um camião");
                System.out.println("| 6 - Calcular custo de uma carga");
                System.out.println("| 7 - Listar camiões com inspeção no mês corrente");
                System.out.println("| 8 - Sair");
                System.out.print("| Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Matrícula: ");
                        String matricula = scanner.next();
                        System.out.print("Carga máxima (kg): ");
                        int cargaMaxima = scanner.nextInt();
                        System.out.print("Data próxima inspeção (mês/ano): ");
                        String dataInspecao = scanner.next();
                        System.out.print("Custo por km: ");
                        double custoPorKm = scanner.nextDouble();
                        Camiao novoCamiao = new Camiao(matricula, cargaMaxima, dataInspecao, custoPorKm);
                        gestaoTransportes.inserirCamiao(novoCamiao);
                        System.out.println();
                        break;
                    case 2:
                        gestaoTransportes.mostrarFrotaDeCamioes();
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Matrícula do camião a ser alterado: ");
                        String matriculaAlterar = scanner.next();
                        gestaoTransportes.alterarCamiao(matriculaAlterar);
                        System.out.println();
                        break;
                    case 4:
                        System.out.print("Matrícula do camião a ser excluído: ");
                        String matriculaExcluir = scanner.next();
                        gestaoTransportes.eliminarCamiao(matriculaExcluir);
                        System.out.println();
                        break;
                    case 5:
                        System.out.print("Informe a matrícula do camião: ");
                        String matriculaCaminhao = scanner.next();

                        // Verificar se o camião existe na frota
                        Camiao camiao = gestaoTransportes.encontrarCamiaoPorMatricula(matriculaCaminhao);
                        if (camiao != null) {
                            // Pedir informações da carga
                            System.out.print("Nome do cliente: ");
                            String nomeCliente = scanner.next();
                            System.out.print("Local de origem: ");
                            String localOrigem = scanner.next();
                            System.out.print("Local de destino: ");
                            String localDestino = scanner.next();
                            System.out.print("Distância (km): ");
                            int distancia = scanner.nextInt();
                            System.out.print("Peso (kg): ");
                            int peso = scanner.nextInt();

                            // Criar objeto Carga
                            Carga carga = new Carga(nomeCliente, localOrigem, localDestino, distancia, peso);

                            // Atribuir a carga ao camião
                            gestaoTransportes.atribuirCargaAoCamiao(carga, camiao);
                        } else {
                            System.out.println("Camião não encontrado na frota.");
                        }
                        break;
                    case 6:
                        System.out.print("Informe o peso da carga (kg): ");
                        int pesoCarga = scanner.nextInt();
                        System.out.print("Informe a distância (km): ");
                        int distanciaCarga = scanner.nextInt();

                        // Criar objeto Carga
                        Carga carga = new Carga("", "", "", distanciaCarga, pesoCarga);

                        // Calcular o custo da carga
                        double custoCarga = gestaoTransportes.calcularCustoCarga(carga);
                        System.out.println("O custo da carga é: " + custoCarga + "€");
                        break;
                    case 7:
                        // Obter o mês corrente
                        LocalDate dataAtual = LocalDate.now();
                        int mesCorrente = dataAtual.getMonthValue();

                        // Listar camiões com inspeção no mês corrente
                        List<Camiao> camioesInspecaoMesCorrente = gestaoTransportes.obterCamiõesInspecaoMesCorrente(mesCorrente);

                        // Exibir os camiões encontrados
                        System.out.println("Camiões com inspeção no mês corrente:");
                        for (Camiao camiaoInspecao : camioesInspecaoMesCorrente) {
                            System.out.println("Matrícula: " + camiaoInspecao.getMatricula());
                        }
                        break;
                    case 8:
                        System.out.println("A sair.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tenta novamente.");
                        System.out.println();
                        break;
                }
            }



        }
    }
