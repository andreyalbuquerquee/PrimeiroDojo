import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();
        List<Venda> listaVendas = new ArrayList<>();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Cadastrar estoque inicial");
            System.out.println("3- Venda de produtos");
            System.out.println("4- Exibir estoque de produtos");
            System.out.println("5- Exibir produtos com menos de 10 unidades");
            System.out.println("6- Exibir vendas por produto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                System.out.println("Digite o nome do produto: \n");
                String nome = in.next();
                System.out.println("Informe o código do produto \n");
                String codigo = in.next();
                System.out.println("Informe o preço do produto: \n");
                Double preco = in.nextDouble();
                int qtd = 0;

                listaProdutos.add(new Produto(codigo, nome, preco, qtd));

                System.out.println("Produto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                System.out.println("Informe o código do produto");
                String codigoInformado = in.next();
                
                List<Produto> listaP = listaProdutos.stream()
                .filter(p -> p .getCodigo().contains(codigoInformado)).collect(Collectors.toList());;

                if (listaP.isEmpty()) {
                    System.out.println("Produto não localizado!");
                } else {
                    System.out.println("Informe quantas unidades serão adicionadas");
                    int estoque = in.nextInt();
                    Produto produto = listaP.get(0);
                    
                    produto.setQtd(produto.getQtd() + estoque);
                }



                voltarMenu(in);
            } else if (opcao == 3) {
                
                
                System.out.println("Informe o código do produto");
                String codigoInformado = in.next();
                List<Produto> novaLista = listaProdutos.stream()
                .filter(v -> v .getCodigo().equals(codigoInformado)).collect(Collectors.toList());
                
                if (novaLista.isEmpty()) {
                    System.out.println("Produto não localizado!");
                } else {
                    System.out.println("Informe quantas unidades foram vendidas");
                    int qtdVendida = in.nextInt();
                    Produto produto = novaLista.get(0);
                    Venda venda = new Venda(produto, qtdVendida);
                    listaVendas.add(venda);
                    produto.setQtd(produto.getQtd() - qtdVendida);
                    
                }

                voltarMenu(in);
            } 
            
            else if (opcao == 4) {
                for (Produto produto : listaProdutos) {
                    System.out.println(produto);
                }
                
                voltarMenu(in);
            } 
            
            else if (opcao ==5) {
                
                Boolean achou = false;
                
                for (Produto produto : listaProdutos) {
                    if (produto.getQtd() < 10) {
                        System.out.println(produto);
                        achou = true;
                    }
                }

                if (!achou){
                    System.out.println("Não foi encontrado produtos com essa opção");
                }
                voltarMenu(in);
            }
            
            else if (opcao ==6 ){
                Map<Produto, List<Venda>> vendasPorProduto = 
                listaVendas.stream().collect(Collectors.groupingBy(Venda::getPtd));
                vendasPorProduto.entrySet().forEach(v -> System.out.printf("Produto: %s - Vendas: %s\n", v.getKey(), v.getValue()) );
            }
            
            
            
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
