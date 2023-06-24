import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List <Pokemon> listaPokemon = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;

        do{
            System.out.println("1- Capturar Pokemon");
            System.out.println("2- Consultar relatório do Pokemon");
            System.out.println("3- Pokedex");
            System.out.println("4- Transferir Pokemon");
            System.out.println("0 - Sair");
            opcao=sc.nextInt();

        if(opcao==1){
            System.out.println("Digite o Pokemon a ser capturado: ");
            String nome=sc.next();
            LocalDate data = LocalDate.now();
            System.out.println("Digite os Pontos de Combate: ");
            int pc=sc.nextInt();
            listaPokemon.add(new Pokemon(nome, data, pc));
        }
        if(opcao==2){
            ConsumoAPI consumoAPI = new ConsumoAPI();
            System.out.println("Qual Pokemon deseja consultar? ");
            String pokemon=sc.next();
            List <Pokemon> listaP=listaPokemon.stream()
            .filter(p->p.getNome().equals(pokemon)).collect(Collectors.toList());
            if(listaP.isEmpty()){
                System.out.println("Você não possui este Pokemon!");
            }else{
            String resposta = consumoAPI.buscaPokemon(pokemon);
            System.out.println("Relatório do Pokemon: ");
            System.out.println(resposta);
        }}
        if(opcao==3){
            if (listaPokemon.isEmpty()){
                System.out.println("Não existem Pokemons capturados no momento!");
            }else{
            for (Pokemon pokemon2 : listaPokemon) {
                System.out.println(pokemon2);
            }}
        }
    if (opcao==4){
        
        System.out.println("Qual Pokemon deseja transferir ao professor?");
        String transferido=sc.next();
        boolean removido=listaPokemon.removeIf(p-> p.getNome().equals(transferido));
        if(removido){
            System.out.println("Pokemon transferido ao professor!");
        } else{
            System.out.println("Você não possui este Pokemon para transferir!");
        }
            
        }
    }  while (opcao!=0);
}
}
