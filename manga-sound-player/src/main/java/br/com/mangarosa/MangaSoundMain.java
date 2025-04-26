package br.com.mangarosa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import br.com.mangarosa.collections.ListaReproducao;
import br.com.mangarosa.collections.MangaController;


public class MangaSoundMain {
    public static void main(String[] args) {
        MangaController controller = new MangaController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MangaSound ===");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Caminho do arquivo .wav: ");
                    String path = scanner.nextLine();
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    try {
                        File src = new File(path);
                        File repo = new File("repositorio");
                        if (!repo.exists()) repo.mkdirs();
                        File dest = new File(repo, src.getName());
                        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        controller.adicionarMusica(titulo, dest.getPath(), artista);
                        System.out.println("Música adicionada ao repositório.");
                    } catch (IOException e) {
                        System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nome da nova lista de reprodução: ");
                    String nomeLista = scanner.nextLine();
                    controller.CriarListaReproducao(nomeLista);
                    System.out.println("Lista de reprodução criada: " + nomeLista);
                    break;

                case 3:
                    if (controller.listasReproducao == null || controller.listasReproducao.size() == 0) {
                        System.out.println("Nenhuma lista disponível.");
                        break;
                    }
                    System.out.println("Listas de reprodução:");
                    for (int i = 0; i < controller.listasReproducao.size(); i++) {
                        ListaReproducao lr = (ListaReproducao) controller.listasReproducao.get(i);
                        System.out.println(i + ". " + lr.getTitulo());
                    }
                    System.out.print("Escolha o número da lista: ");
                    int idxLista = Integer.parseInt(scanner.nextLine());
                    ListaReproducao editList = (ListaReproducao) controller.listasReproducao.get(idxLista);
                    System.out.print("Título da música a mover: ");
                    String mvTitulo = scanner.nextLine();
                    System.out.print("Nova posição (0-based): ");
                    int novaPos = Integer.parseInt(scanner.nextLine());
                    controller.removerMusicaListaReproducao(mvTitulo, editList.getTitulo());
                    controller.adicionarMusicaListaReproducaoEmPosicao(mvTitulo, editList.getTitulo(), novaPos);
                    System.out.println("Música movida.");
                    break;

                case 4:
                    if (controller.listasReproducao == null || controller.listasReproducao.size() == 0) {
                        System.out.println("Nenhuma lista disponível.");
                        break;
                    }
                    System.out.println("Listas de reprodução:");
                    for (int i = 0; i < controller.listasReproducao.size(); i++) {
                        ListaReproducao lr = (ListaReproducao) controller.listasReproducao.get(i);
                        System.out.println(i + ". " + lr.getTitulo());
                    }
                    System.out.print("Escolha o número da lista a executar: ");
                    int execIdx = Integer.parseInt(scanner.nextLine());
                    String listaExec = ((ListaReproducao) controller.listasReproducao.get(execIdx)).getTitulo();
                    controller.reproduzirListaDeReproducao(listaExec);

                    boolean playing = true;
                    while (playing) {
                        System.out.println("Comandos: p=pause, r=restart, n=próxima, b=voltar, s=stop, q=voltar ao menu");
                        String cmd = scanner.nextLine();
                        switch (cmd) {
                            case "p": controller.pausarMusica(); break;
                            case "r": controller.reiniciarMusica(); break;
                            case "n": controller.passarMusica(); break;
                            case "b": controller.voltarMusica(); break;
                            case "s": controller.pararLista(); break;
                            case "q": playing = false; break;
                        }
                    }
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Aplicativo encerrado.");
    }
}