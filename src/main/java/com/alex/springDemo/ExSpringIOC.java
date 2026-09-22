package com.alex.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExSpringIOC {

    public static void main(String[] args) {

        // Sto dicendo a Spring quali classi voglio che siano gestite dall'application context
        ApplicationContext spring = new AnnotationConfigApplicationContext(Game.class, Score.class);

        // Prendo l'istanza della classe Score dall'application context
        Score score = spring.getBean(Score.class);

        /** IOC - Inversion Of Control
         * Non sono io sviluppatore a dovermi preoccupare del ciclo di vita di certi componenti,
         * E' Spring a farlo per me.
         * In questo esempio, non ho dovuto creare l'istanza dell'oggetto:
         * Ci ha pensato Spring, io mi sono limitato a prenderla.
         * */

        // Singleton - l'istanza passata all'interno del codice e' sempre la stessa
        for (int x = 0; x < 5; x++){
            //Score s = new Score();
            Score s = spring.getBean(Score.class);
            s.wins++;
            System.out.println(s.wins);
        }

        Game game = spring.getBean(Game.class);
        game.playTheGame();
        System.out.println(game.score.wins); //Stampa 6, perche' l'istanza e' sempre la stessa
    }
}

class Game {

    // Score e' una dipendenza di Game
    /** Dependency Injection
     * Grazie ad @Autowired, sto passando l'istanza di Score dentro Game
     * Quando richiamero' Game, non avro' bisogno di istanziare Score
     * */
    @Autowired
    Score score;

    public void playTheGame() {
        score.wins++;
    }
}

class Score {

    int wins;
    int losses;
    int ties;
}
