import controller.LoginController;
import model.Database;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Database db = new Database();
            new LoginController(db);
        });
    }
}
