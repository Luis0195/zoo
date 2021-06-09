import java.awt.EventQueue;

public class MainZoo {
	
	//Crea un objeto de la clase VentanaPrincipal.
	private static VentanaPrincipal inicio;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio = new VentanaPrincipal();
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
