package lab3;
import java.util.TimerTask;
public class SimTask extends TimerTask { //dziedziczymy z klasy TimerTask
//pola do przechowywania obiektów klas
private SimEngine obiekt1;
private SpringApplet obiekt2;
private double t;
//konstruktor z parametrami:
public SimTask(SimEngine obiekt1, SpringApplet obiekt2, double t){
this.obiekt1=obiekt1;
this.obiekt2=obiekt2;
this.t=t;
}
public void run() { //przeci¹¿ona metoda run
obiekt1.symulacjaUkladu(t); //wywo³ujemy krok
obiekt2.repaint(); // oraz odœwie¿amy powierzchnie apletu
}
}