import DAO.DAOFactory;
import DAO.DAOJugador.DAOJugador;
import Entidades.Jugador;


public class Main {

    public static void main(String[] args) {
        Jugador jugador = new Jugador("alejandra","alejandra@gmail.com","alejandra");
        DAOFactory.getInstance().getDaoJugador().add(jugador);
        System.out.println(DAOFactory.getInstance().getDaoJugador().getJugador());
    }
}
