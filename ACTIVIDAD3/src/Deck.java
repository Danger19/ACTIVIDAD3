import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
//Creamos la clase
public class Deck {
    //Hacemos una lista que almacene las cartas del deck
    private List<Card> cards;
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }
//Aquí rellneamos el mazo con todas las combinaciones posibles
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }
//Aquí hacemos el método para barajear las cartas, usamos el Shuffle como dije
    //antes para mezclar e imprimimos el mensaje de confirmación de mezcla
    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }
//Creamos head que mostrará y retirará la primera carta del deck
    //básicamente con extraemos la primera carta, luego la imprimimos e informamos cuantas cartas
    //quedan
    public void head() {
        if (!cards.isEmpty()) {
            Card drawnCard = cards.remove(0);
            System.out.println(drawnCard);
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No quedan cartas en el Deck.");
        }
    }
//Aquí vamos a retirar y mostrar una carta al azar (no es la primera)
    // creamos un random para generar números, generamos un índice aleatorio del deck
    //extrae la carta, la imprimimos e informamos cuantas quedan
    public void pick() {
        if (!cards.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(cards.size());
            Card drawnCard = cards.remove(randomIndex);
            System.out.println(drawnCard);
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No quedan cartas en el Deck.");
        }
    }
//Aquí vamos a sacar 5, prácticamente itera en cinco ocaciones extraer e imprimir
    //y lo mismo, mostrar e informar
    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card drawnCard = cards.remove(0);
                System.out.println(drawnCard);
            }
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No hay suficientes cartas en el Deck para formar una mano.");
        }
    }
}
//Hacemos la clase card
class Card {
    private Rank rank;//(valor de carta)
    private Suit suit;//(valor de palo y color
//Inicializamos una carta con un valor y un palo específico
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
//Aquí sobrescribimos el método toString para imprimir la carta de forma
    //personalizada y le ponemos el formato palo, color, valor
    @Override
    public String toString() {
        return "{" + suit + "}, {" + suit.getColor() + "}, {" + rank + "}";
    }
}

enum Rank { //Valores posibles de las cartas
    dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, jota, reina, rey, as
}

enum Suit { //valores de palos con color
    treboles("negro"), diamentes("rojo"), corazones("rojo"), picas("negro");

    private String color;

    Suit(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
//Hacemos le ejecutador
class Main {
    public static void main(String[] args) {
        Deck deck = new Deck(); //Instacia de la clase deck

        deck.head();//llama al método head
        deck.pick();// llama al método pick
        deck.hand();// lama al método hand
    }
}
