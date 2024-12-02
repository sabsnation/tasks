import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Produtos e Adicionais para Restaurantes já existentes
        List<Adicional> adicionais1 = Arrays.asList(
                new Adicional("Benção", 17.0),
                new Adicional("Benção ao quadrado", 17.0)
        );

        List<Adicional> adicionais2 = Arrays.asList(
            new Adicional("Mais pregos", 5.0),
            new Adicional("Mais Cola cola", 10.0),
            new Adicional("Dissolver prego enferrujado com Cola cola", 100.0)
        );

        List<Adicional> adicionais3 = Arrays.asList(
            new Adicional("Soltosofirebolboni", 70.0)
        );

        List<Adicional> adicionais4 = Arrays.asList(
            new Adicional("refrigrante", 10.0),
            new Adicional("brindes", 3.0),
            new Adicional("bala zaza", 1.0)
        );

        List<Adicional> adicionais5 = Arrays.asList(
            new Adicional("refrigrante", 10.0),
            new Adicional("brindes", 3.0),
            new Adicional("bala zaza", 1.0)
        );

        List<Produto> produtos1 = Arrays.asList(
                new Produto("Pirão de galinha", 70.0, adicionais1),
                new Produto("Refrigerante Santa Joana", 17.0, adicionais1),
                new Produto("Feijão", 70.0, adicionais1),
                new Produto("Chá Verde", 70.0, adicionais1)
        );

        List<Produto> produtos2 = Arrays.asList(
                new Produto("Pregos", 20.0, adicionais2),
                new Produto("Coca cola", 40.0, adicionais2)
        );

        List<Produto> produtos3 = Arrays.asList(
            new Produto("Benção", 100.0, adicionais3),
            new Produto("Mais bençãos", 200.0, adicionais3)
        );

        List<Produto> produtos4 = Arrays.asList(
            new Produto("SOPA", 100.0, adicionais4),
            new Produto("Refeição mistério", 99.99, adicionais4),
            new Produto("Peixe ao molho zaza", 70.0, adicionais4),
            new Produto("Cumbuca de farinha", 2.0, adicionais4),
            new Produto("Salgado frio", 10.0, adicionais4)
        );

        List<Produto> produtos5 = Arrays.asList(
                new Produto("Amburge artezanal", 100.0, adicionais5),
                new Produto("Coxinha", 4.0, adicionais5),
                new Produto("Coxinha de matte verde", 8.0, adicionais5),
                new Produto("Matte verde", 5.0, adicionais5)
        );

        // Produtos e Adicionais para Novos Restaurantes
        List<Adicional> adicionais6 = Arrays.asList(
            new Adicional("Molho especial", 5.0),
            new Adicional("Porção extra de batata", 7.0)
        );

        List<Produto> produtos6 = Arrays.asList(
            new Produto("Pizza Margherita", 50.0, adicionais6),
            new Produto("Pizza Calabresa", 55.0, adicionais6),
            new Produto("Pizza Portuguesa", 60.0, adicionais6)
        );

        List<Adicional> adicionais7 = Arrays.asList(
            new Adicional("Açaí com banana", 10.0),
            new Adicional("Granola extra", 5.0)
        );

        List<Produto> produtos7 = Arrays.asList(
            new Produto("Açaí Tradicional", 15.0, adicionais7),
            new Produto("Açaí Gourmet", 20.0, adicionais7)
        );

        List<Adicional> adicionais8 = Arrays.asList(
            new Adicional("Pimenta da casa", 3.0),
            new Adicional("Salada extra", 7.0)
        );

        List<Produto> produtos8 = Arrays.asList(
            new Produto("Churrasco Completo", 80.0, adicionais8),
            new Produto("Picanha na Brasa", 90.0, adicionais8)
        );

        List<Adicional> adicionais9 = Arrays.asList(
            new Adicional("Molho Teriaki", 3.0),
            new Adicional("Adicional de salmão", 10.0)
        );

        List<Produto> produtos9 = Arrays.asList(
            new Produto("Sushi Combo", 120.0, adicionais9),
            new Produto("Temaki Especial", 25.0, adicionais9)
        );

        List<Adicional> adicionais10 = Arrays.asList(
            new Adicional("Farofa", 2.0),
            new Adicional("Vinagrete", 3.0)
        );

        List<Produto> produtos10 = Arrays.asList(
            new Produto("Espetinho de Carne", 15.0, adicionais10),
            new Produto("Espetinho de Frango", 10.0, adicionais10),
            new Produto("Espetinho de Queijo", 12.0, adicionais10)
        );

        // Lista completa de Restaurantes
        List<Restaurante> restaurantes = Arrays.asList(
                new Restaurante("Restaurante ZM Delícias", produtos1),
                new Restaurante("Pregos e Coca Cola", produtos2),
                new Restaurante("Bol Boni Bençãos", produtos3),
                new Restaurante("S&J Refeições", produtos4),
                new Restaurante("Colinas Refeições", produtos5),
                new Restaurante("Pizza do Chef", produtos6),
                new Restaurante("Açaí da Tarde", produtos7),
                new Restaurante("Churrascaria do Zé", produtos8),
                new Restaurante("Sushi Master", produtos9),
                new Restaurante("Espetinhos da Vovó", produtos10)
        );


        Carrinho carrinho = new Carrinho();

        while (true) {
            try {
                exibirMenuPrincipal();
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> listarRestaurantes(scanner, restaurantes, carrinho);
                    case 2 -> carrinho.exibirCarrinho();
                    case 3 -> processarEndereco(scanner);
                    case 4 -> {
                        System.out.println("Obrigado por utilizar o sistema!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (MenuException e) {
                System.out.println("Erro no menu: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
    
    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Listar restaurantes");
        System.out.println("2. Exibir carrinho");
        System.out.println("3. Cadastrar endereço de entrega");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarRestaurantes(Scanner scanner, List<Restaurante> restaurantes, Carrinho carrinho) throws MenuException {
        System.out.println("\n--- Restaurantes Disponíveis ---");
        for (int i = 0; i < restaurantes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, restaurantes.get(i).getNome());
        }

        System.out.print("Selecione um restaurante: ");
        int escolhaRestaurante = scanner.nextInt();

        if (escolhaRestaurante < 1 || escolhaRestaurante > restaurantes.size()) {
            throw new MenuException("Restaurante inválido!");
        }

        Restaurante restauranteSelecionado = restaurantes.get(escolhaRestaurante - 1);
        listarProdutos(scanner, restauranteSelecionado, carrinho);
    }

    public static void processarEndereco(Scanner scanner) {
        Endereco endereco = new Endereco();
    
        // Solicitar o CEP do usuário
        String cep = solicitarEntrada(scanner, "Digite seu CEP: ", "O CEP não pode ser vazio!");
        
        // Buscar informações do endereço com o CEP
        endereco.buscarPorCep(cep);
    
        // Solicitar o número do endereço
        String numero = solicitarEntrada(scanner, "Digite o número do endereço: ", "O número não pode ser vazio!");
    
        // Definir o número no objeto de endereço
        endereco.definirNumero(numero);
    
        // Exibir o endereço completo
        System.out.println("\nSeu endereço completo:");
        endereco.exibirEnderecoCompleto();
    }
    
    private static String solicitarEntrada(Scanner scanner, String mensagem, String mensagemErro) {
        String entrada;
        boolean primeiraTentativa = true; // Controla se é a primeira vez que solicita a entrada
        do {
            if (!primeiraTentativa) {
                System.out.println(mensagemErro); // Mostra o erro apenas se já foi solicitado antes
            }
            System.out.print(mensagem);
            entrada = scanner.nextLine().trim(); // Remove espaços extras
            primeiraTentativa = false;
        } while (entrada.isEmpty());
        return entrada;
    }
    

    private static void listarProdutos(Scanner scanner, Restaurante restaurante, Carrinho carrinho) throws MenuException {
        System.out.println("\n--- Produtos no Restaurante " + restaurante.getNome() + " ---");
        List<Produto> produtos = restaurante.getProdutos();

        for (int i = 0; i < produtos.size(); i++) {
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, produtos.get(i).getNome(), produtos.get(i).getPreco());
        }

        System.out.print("Selecione um produto: ");
        int escolhaProduto = scanner.nextInt();

        if (escolhaProduto < 1 || escolhaProduto > produtos.size()) {
            throw new MenuException("Produto inválido!");
        }

        Produto produtoSelecionado = produtos.get(escolhaProduto - 1);
        carrinho.adicionarItem(produtoSelecionado.getNome(), produtoSelecionado.getPreco());

        listarAdicionais(scanner, produtoSelecionado, carrinho);
    }

    private static void listarAdicionais(Scanner scanner, Produto produto, Carrinho carrinho) {
        System.out.println("\n--- Adicionais para " + produto.getNome() + " ---");
        List<Adicional> adicionais = produto.getAdicionais();

        for (int i = 0; i < adicionais.size(); i++) {
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, adicionais.get(i).getNome(), adicionais.get(i).getPreco());
        }

        System.out.println("Selecione um adicional (0 para finalizar): ");
        int escolhaAdicional = scanner.nextInt();

        while (escolhaAdicional != 0) {
            if (escolhaAdicional < 1 || escolhaAdicional > adicionais.size()) {
                System.out.println("Adicional inválido! Tente novamente.");
            } else {
                Adicional adicionalSelecionado = adicionais.get(escolhaAdicional - 1);
                carrinho.adicionarItem(adicionalSelecionado.getNome(), adicionalSelecionado.getPreco());
            }

            System.out.print("Selecione outro adicional (0 para finalizar): ");
            escolhaAdicional = scanner.nextInt();
        }
    }
}

