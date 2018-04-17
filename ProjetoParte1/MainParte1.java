package com.ProjetoParte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainParte1 {
    private Scanner leitoraDeTeclado;

    /**
     * Método main da classe, o primeiro a ser executado
     */
    public static void main(String[] args) {

        //Instanciando um novo objeto
        MainParte1 mainParte1 = new MainParte1();

        //Chamada do método para ativar o menu ao usuario.
        mainParte1.executarAcao(mainParte1.capturarOpcao());
    }

    /**
     * Método responsavel por executar a ação de acordo com o que foi escolhido
     * pelo usuario
     *
     * @param capturarOpcao
     */
    private void executarAcao(int opcaoSelecionada) {
        //Switch para definir qual ação executar, dependendo do que for recebido como parametro
        switch (opcaoSelecionada) {
            case 1:
                somarNumeros();
                executarAcao(capturarOpcao());
                break;
            case 2:
                subtrairNumeros();
                executarAcao(capturarOpcao());
                break;
            case 3:
                dividirNumeros();
                executarAcao(capturarOpcao());
                break;
            case 4:
                calcularMediaIdades();
                executarAcao(capturarOpcao());
                break;
            case 5:
                somarNumerosPrimos();
                executarAcao(capturarOpcao());
                break;
            case 6:
                mudarBase();
                executarAcao(capturarOpcao());
                break;
            case 7:
                System.out.println("FINALIZANDO PROGRAMA ...");
                break;
        }
    }

    /**
     * Método responsavel por mudar a base para binario ou decimal
     */
    private void mudarBase() {

        // inicializando o objeto Scanner, que sera responsavel por ler dados doteclado.
        leitoraDeTeclado = new Scanner(System.in);

        //Variavel que amazena a quantidade de numero que serao informados
        int qtdNumeros = 0;

        System.out.println("Informe a quantidade de numeros a serem convertidos:");
        qtdNumeros = leitoraDeTeclado.nextInt();

        for (int i = 0; i < qtdNumeros; i++) {

            //Variavel temporaria que armazenara o numero informado pelo usuario.
            int numeroInfomado = 0;

            //Variavel temporaria que armazenara a base informada pelo usuario.
            String baseInformada = "";

            //Deixar em loop, caso numero informado seja menor que zero
            do {
                System.out.println("Informe o numero:");
                numeroInfomado = leitoraDeTeclado.nextInt();
            } while (numeroInfomado < 0);

            //Deixar em loop, caso base informada seja diferente de B  ou D
            do {
                System.out.println("Informe a base:");
                baseInformada = leitoraDeTeclado.next();
            } while (!baseInformada.equalsIgnoreCase("b") && !baseInformada.equalsIgnoreCase("d"));

            //Verificando qual foi a base informada, e realizando a conversão utilizando a Classe Integer
            System.out.println("NUMERO CONVERTIDO DE");
            if (baseInformada.equalsIgnoreCase("b")) {

                //Convertendo de binario para decimal
                System.out.print("BINARIO PARA DECIMAL = ");
                System.out.println(Integer.parseInt(Integer.toString(numeroInfomado), 2));
            } else {
                //Convertendo de decimal para binario
                System.out.print("DECIMAL PARA BINARIO= ");
                System.out.println(Integer.toBinaryString(numeroInfomado));
            }

        }

    }

    /**
     * Método responsavel por somar os numeros primos entre 1 e X e apresentar
     * na tela.
     */
    private void somarNumerosPrimos() {
        // inicializando o objeto Scanner, que sera responsavel por ler dados doteclado.
        leitoraDeTeclado = new Scanner(System.in);
        System.out.println("Informe o numero final desejado:");

        //variavel que armazenara o numero informado pelo usuario.
        int numero = leitoraDeTeclado.nextInt();
        int somatorio = 0;

        for (int i = 2; i <= numero; i++) {
            boolean numeroPrimo = false; //variavel usada para analisar se o numero e primo ou nao
            for (int j = 2; j <= numero; j++) { //segundo loop, para fazer a analise se o numero e primo ou nao
                if (j != i && i % j == 0) { // se o resto da divisao do de i por j for zero, significa que aquele numero nao e primo
                    numeroPrimo = true; // definindo o numero como nao primo
                }
            }
            //só realiza a soma, caso o numero seja primo
            if (!numeroPrimo) {
                System.out.println("Numero primo encontrado -> " + i);
                somatorio += i;
            }
        }

        System.out.println("SOMATORIO DOS NUMEROS PRIMOS = " + somatorio);

    }

    /**
     * Método responsavel por solicitar idade e sexo de um grupo x de pessoas e
     * chamar metodo especializados e calcular medias de idade.
     */
    private void calcularMediaIdades() {
        // inicializando o objeto Scanner, que sera responsavel por ler dados doteclado.
        leitoraDeTeclado = new Scanner(System.in);
        //Variavel que irá guardar a quantidade de pessoas do grupo.
        int qtdDePessoas = 0;
        //ArrayList que armazenara  a idade de todas as mulheres
        List<Integer> idadesFemininas = new ArrayList<>();

        //ArrayList que armazenará  a idade de todas os homens
        List<Integer> idadesMasculinas = new ArrayList<>();

        do {
            System.out.println("Quantas pessoas há no grupo?");
            qtdDePessoas = leitoraDeTeclado.nextInt();
        } while (qtdDePessoas <= 0);//Nao permitir numeros negativos, ou zero, para essa informação

        //realizar um loop, solicitando idade e sexo de cada pessoa do grupo.
        for (int i = 0; i < qtdDePessoas; i++) {
            int idade = 0;//variavel que armazenara de forma temporaria a idade da pessoa
            String sexo = ""; //variavel que armazenara de forma temporada o sexo da pessoa
            System.out.println("Informe a idade da pessoa " + (i + 1));
            idade = leitoraDeTeclado.nextInt();

            System.out.println("Informe o sexo da pessoa " + (i + 1));
            sexo = leitoraDeTeclado.next();
            /*Dependendo do sexo selecionado, salvar a idade em listas diferentes*/
            if (sexo.equalsIgnoreCase("f")) {
                idadesFemininas.add(idade);
            } else {
                idadesMasculinas.add(idade);
            }
        }

        System.out.println("MEDIA TOTAL:" + calcularMediaGeral(idadesFemininas, idadesMasculinas));
        //Analisando se foi informado alguma mulher
        if (!idadesFemininas.isEmpty()) {
            System.out.println("MEDIA FEMININA:" + calcularMediaFeminina(idadesFemininas));
        }
        //Analisando se foi informado algum homem
        if (!idadesMasculinas.isEmpty()) {
            System.out.println("MEDIA MASCULINA:" + calcularMediaMasculina(idadesMasculinas));
        }

    }

    /**
     * Método especifico para calcular a media de idades das mulheres.
     *
     * @param idadesFemininas
     * @return
     */
    private int calcularMediaMasculina(List<Integer> idadesMasculinas) {
        //descobrindo quantos homens há no array
        int qtdHomens = idadesMasculinas.size();
        //variavel que armazenara a soma das idades de todas os homens
        int somaDasIdades = 0;

        for (int i = 0; i < idadesMasculinas.size(); i++) {
            //Somando as idades masculinas, uma a uma.
            somaDasIdades += idadesMasculinas.get(i);
        }

        return somaDasIdades / qtdHomens;
    }

    /**
     * Método especifico para calcular a media de idades das mulheres.
     *
     * @param idadesFemininas
     * @return
     */
    private int calcularMediaFeminina(List<Integer> idadesFemininas) {
        //descobrindo quantas mulheres há no array
        int qtdMulheres = idadesFemininas.size();
        //variavel que armazenara a soma das idades de todas as mulheres
        int somaDasIdades = 0;

        for (int i = 0; i < idadesFemininas.size(); i++) {
            //Somando as idades femininas, uma a uma.
            somaDasIdades += idadesFemininas.get(i);
        }

        return somaDasIdades / qtdMulheres;
    }

    /**
     * Método especifico para calcular a media de idade geral de um grupo de
     * pessoas
     *
     * @param idadesFemininas
     * @param idadesMasculinas
     */
    private int calcularMediaGeral(List<Integer> idadesFemininas, List<Integer> idadesMasculinas) {
        //Somando a qtd total de posicoes dos arrays, para saber quantas pessoas tem.
        int qtdPessoas = idadesFemininas.size() + idadesMasculinas.size();
        int somaDasIdades = 0;

        for (int i = 0; i < idadesFemininas.size(); i++) {
            //Somando as idades femininas, uma a uma.
            somaDasIdades += idadesFemininas.get(i);
        }

        for (int i = 0; i < idadesMasculinas.size(); i++) {
            //Somando as idades masculinas, uma a uma.
            somaDasIdades += idadesMasculinas.get(i);
        }

        return somaDasIdades / qtdPessoas;

    }

    /**
     * Método responsavel por solicitar dois numeros ao usuario e imprimir a
     * divisão na tela.
     */
    private void dividirNumeros() {
        // inicializando o objeto Scanner, que sera responsavel por ler dados doteclado.
        leitoraDeTeclado = new Scanner(System.in);
        int numero1 = 0, numero2 = 0;
// Criando as variaveis que iro possuir os numeros informados pelo usuario
        System.out.println("\t ---------- DIVISAO ----------");
        System.out.println("Informe o primeiro numero:");
        numero1 = leitoraDeTeclado.nextInt();
        //loop para nao permitir que seja informado 0
        do {
            System.out.println("Informe o segundo numero:");
            numero2 = leitoraDeTeclado.nextInt();
        } while (numero2 == 0);

        System.out.println("RESULTADO = " + (numero1 / numero2));
        /*Subtraindo os valores e apresentando na tela*/
    }

    /**
     * Método responsavel por solicitar dois numeros ao usuario e imprimir a
     * sutracao na tela.
     */
    private void subtrairNumeros() {
        // inicializando o objeto Scanner, que sera responsavel por ler dados doteclado.
        leitoraDeTeclado = new Scanner(System.in);
        int numero1 = 0, numero2 = 0; // Criando as variaveis que ir�o possuir os numeros informados pelo usuario
        System.out.println("\t ---------- SUBTRACAO ----------");
        System.out.println("Informe o primeiro numero:");
        numero1 = leitoraDeTeclado.nextInt();
        System.out.println("Informe o segundo numero:");
        numero2 = leitoraDeTeclado.nextInt();
        System.out.println("RESULTADO = " + (numero1 - numero2));
        /*Subtraindo os valores e apresentando na tela*/
    }

    /**
     * Método responsavel por solicitar dois numeros ao usuario e imprimir a
     * soma na tela.
     */
    private void somarNumeros() {
        //inicializando  o objeto Scanner, que sera responsavel por ler dados do teclado.
        leitoraDeTeclado = new Scanner(System.in);
        int numero1 = 0, numero2 = 0; //Criando as variaveis que irao possuir os numeros informados pelo usuario
        System.out.println("\t ---------- SOMA ----------");
        System.out.println("Informe o primeiro numero:");
        numero1 = leitoraDeTeclado.nextInt();
        System.out.println("Informe o segundo numero:");
        numero2 = leitoraDeTeclado.nextInt();
        System.out.println("RESULTADO = " + (numero1 + numero2)); //Somando os valores e apresentando na tela

    }

    /**
     * Método responsavel por exibir o menu e retornar qual opção o usuario
     * escolheu
     *
     * @return
     */
    private int capturarOpcao() {
        //inicializando  o objeto Scanner, que sera responsavel por ler dados do teclado.
        leitoraDeTeclado = new Scanner(System.in);
        //Variavel que representa a op��o escolhida pelo usuario.
        int opcaoEscolhida = 0;
        do {
            // Apresentando menu
            System.out.println("----------------------");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Divisão");
            System.out.println("4 - Faixa etaria");
            System.out.println("5 - Numeros primos");
            System.out.println("6 - Mudanca de Base");
            System.out.println("7 - Sair");
            System.out.println("----------------------");
            System.out.print("Selecione uma opção do menu:");
            //Capturando a opção escolhida pelo usuario.
            opcaoEscolhida = leitoraDeTeclado.nextInt();
        } while (opcaoEscolhida < 0 || opcaoEscolhida > 7); //loop enquanto a op��o escolhida n�o for uma opcao valida

        //retornando a opção escolhida pelo usuario;
        return opcaoEscolhida;

    }

}
