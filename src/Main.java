import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int value = sc.nextInt();

        for (int x = 1; x <= value; x++) {
            System.out.println("\nDados da " + x + "a aula: ");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();
            if (ch == 'c'){
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                list.add(new Video(title, url, seconds));
            }else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                list.add(new Task(title, description, questionCount));
            }
        }

        int sum = 0;
        for (Lesson le : list){
            sum += le.duration();
        }

        System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + sum + " segundos");

        sc.close();

    }
}