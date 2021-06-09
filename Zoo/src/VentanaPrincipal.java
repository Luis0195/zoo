import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


//Clase VentanaPrincipal. Crea las ventanas utilizadas en la clase MainZoo
//para simular una visita al zoo de manera gráfica.
public class VentanaPrincipal extends JFrame {

	private JPanel panelPrincipal;
	private JTextField name;
	private JPanel panelZoo;
	private JPanel panelMenu;
	private JPanel textoBoton;
	private JTextArea datosAnimal;
	private ArrayList<String> lista;
	//Crea dos objetos de la clase aves
	private Aves pinguino;
	private Aves buho; 
	//Crea tres objetos de la clase Reptiles
	private Reptiles cocodrilo;
	private Reptiles gecko;
	private Reptiles serpiente;
	//Crea dos objetos de la clase Canino
	private Caninos coyote;
	private Caninos hiena;
	//Crea dos objetos de la clase Felinos
	private Felinos leon;
	private Felinos tigre;
	//Crea un objeto de la clase MusicPlayer
	private MusicPlayer player;
	private JPanel sumario;
	//Crea un objeto de la clase fileReaderWriter
	private fileReaderWriter logger;

	//CEl constructor donde se crea la ventana principal donde aparecerá el panel de inicio.
	//Aquí se inicializan los atributos player y logger, de las clases
	//MusicPlayer y fileReaderWriter respectivamente.
	public VentanaPrincipal() {
		crearLista();
		crearAnimales();
		player = new MusicPlayer();
		logger = new fileReaderWriter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 604);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout());
		setContentPane(panelPrincipal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panelPrincipal.add(panel, BorderLayout.NORTH);
		
		JLabel title = new JLabel("EL ZOO DE CECILIA");
		title.setForeground(new Color(67, 221, 141));
		title.setFont(new Font("Monospaced", Font.BOLD, 33));
		panel.add(title);
		
		JPanel menu = new JPanel();
		panelPrincipal.add(menu, BorderLayout.CENTER);
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		
		JLabel introducirNombre = new JLabel("Introduzca su nombre:");
		introducirNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		introducirNombre.setFont(new Font("Monospaced", Font.BOLD, 17));
		introducirNombre.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(introducirNombre);
		
		name = new JTextField();
		name.setMaximumSize(new Dimension(200, 25));
		name.setFont(new Font("Monospaced", Font.PLAIN, 12));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(name);
		name.setColumns(10);
		
		JButton start = new JButton("Entrar");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.add(start);

		//Crea la acción de pulsar el botón para entrar al zoo y
		//hace que aparezca una ventana con un mensaje de error si el campo
		//del nombre se deja vacío o contiene alguna palabra no amigable (Palabras dentro
		//del ArrayList lista).
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().length() < 3) {
					JOptionPane.showMessageDialog(new JFrame(), "El nombre no puede ser ese. Debe de tener al menos 3 caracteres");
				}
				else {
					try {
			            validateName(name.getText());
			            //Invoca al método de la misma clase para que se cree otra ventana una vez validado el nombre
			            createZooScreen();
			        } catch (InvalidNameException e1) {
			        	JOptionPane.showMessageDialog(new JFrame(), e1);
			        }
				}
				
			}
		});
	}
	
	//Crea los animales de las distintas clases que hay haciendo uso
	//de los atributos ya declarados anteriormente (antes del constructor).
	//No recibe parámetros de entrada ni devuelve nada.
	private void crearAnimales() {
		pinguino = new Aves("Kowalski", 6, "Pigüino Papúa", 2, 2, false);
		pinguino.setDato("El " + pinguino.getRaza() + " también es llamado el Pingüino juanito. Su tamañno adulto está entre los 75 y 90 centímetros.");
		buho = new Aves("Antonio", 4, "Buho Real", 2, 2, true);
		buho.setDato("El " + buho.getRaza() + " es uno de los más grandes repartidos a lo largo de toda Eurasia.");
		coyote = new Caninos("Wile", 7, "Coyote", 4, "marrón grisáceo");
		coyote.setDato("El sentido auditivo de los coyotes está altamente desarrollado.");
		hiena = new Caninos("Ed", 2, "Hiena manchada", 4, "marrón rojizo con manchas irregulares");
		hiena.setDato("La " + hiena.getRaza() + "no es solo carroñera, también es una cazadora nata y astuta.");
		cocodrilo = new Reptiles("Tic Tac", 30, "Cocodrilo del Nilo", 3, true);
		cocodrilo.setDato("Los cocodrilos pueden llegar a pelear entre ellos ocasinandoles graves heridas, a " + cocodrilo.getNombre() + " le falta una pata por una pelea.");
		gecko = new Reptiles("Gustavo", 2, "Gecko tokaya", 4, false);
		gecko.setDato("El " + gecko.getRaza() +" es una de las pocas especies de lagarto que hasta el momento ha demostrado tener la capacidad de comunicarse con otros mediante los sonidos.");
		serpiente = new Reptiles("Mordisquitos", 10, "Serpiente de cascabel", 0, true);
		serpiente.setDato("La " + serpiente.getRaza() + " tiene ese 'cacabel' al final de la cola para advertir de que es peligrosa");
		leon = new Felinos("Wiscas", 12, "León", 4, "marrón");
		leon.setDato("Los leones machos pueden llegar a pesar 250 kilos y medir entre 170 a 250 cm de largo.");
		tigre = new Felinos("Thai", 3, "Tigre de tailandia", 4, "naranja con franjas negras");
		tigre.setDato("Las estimaciones sobre su población varían entre 700 y 1300 ejemplares en estado salvaje.");
	}

	//Crea la ventana del zoo, aquella que aparecerá una vez pulsado el botón
	//de entrar al zoo en el constructor.
	public void createZooScreen() {
		panelPrincipal.setVisible(false);
		panelMenu = new JPanel();
		panelMenu.setLayout(new BorderLayout());
		
		panelZoo = new JPanel();
		panelZoo.setLayout(new GridLayout(3, 3));
		
		textoBoton = new JPanel();
		textoBoton.setLayout(new BoxLayout(textoBoton, BoxLayout.Y_AXIS));
		
		datosAnimal = new JTextArea(10, 20);
		datosAnimal.setEditable(false);
		datosAnimal.setFont(new Font("Monospaced", Font.PLAIN, 15));
		datosAnimal.setAlignmentX(Component.CENTER_ALIGNMENT);
		datosAnimal.setLineWrap(true);
		
		JButton resumen = new JButton("Resumen visita");
		resumen.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel datos = new JLabel("Esperemos que la visita sea de su agrado, " + name.getText(), SwingConstants.CENTER);
		datos.setFont(new Font("Monospaced", Font.BOLD, 20));
		setContentPane(panelMenu);
		panelMenu.add(datos, BorderLayout.NORTH);
		panelMenu.add(panelZoo, BorderLayout.CENTER);
		
		//Creación de botones para poder obtener información y sonidos de los distintos animales.
		JButton animal1 = new JButton("León");
		JButton animal2 = new JButton("Tigre");
		JButton animal3 = new JButton("Pingüino");
		JButton animal4 = new JButton("Buho");
		JButton animal5 = new JButton("Coyote");
		JButton animal6 = new JButton("Hiena");
		JButton animal7 = new JButton("Cocodrilo");
		JButton animal8 = new JButton("Serpiente cascabel");
		JButton animal9 = new JButton("Gecko");
		panelZoo.add(animal1);
		panelZoo.add(animal2);
		panelZoo.add(animal3);
		panelZoo.add(animal4);
		panelZoo.add(animal5);
		panelZoo.add(animal6);
		panelZoo.add(animal7);
		panelZoo.add(animal8);
		panelZoo.add(animal9);
		panelMenu.add(textoBoton,  BorderLayout.SOUTH);
		textoBoton.add(datosAnimal);
		textoBoton.add(resumen);
		
		//Diversos métodos para obtener el sonido y el dato del animal seleccionado, 
		//así como diferentes reacciones del visitante al verlos.
		animal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(leon.getDato());
				//Para el sonido si se estaba reproduciendo
				player.stop();
				//Hace uso del atributo de la clase MusicPlayer para reproducir el sonido del animal.
				player.startPlaying("sounds\\leon.mp3");
				//Escribe en el log la hora de la visita junto con la reacción del visitante y animal.
				logger.writeFile(name.getText() + " visitó a los leones, ¡menudo susto le dio " + leon.getNombre() + "!");
				
			}
		});
		
		animal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(tigre.getDato());
				player.stop();
				player.startPlaying("sounds\\tigre.mp3");
				logger.writeFile(name.getText() + " decició ir a ver a los tigres, que bonito era " + tigre.getNombre() + ".");
				
			}
		});
		
		animal3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(pinguino.getDato());
				player.stop();
				player.startPlaying("sounds\\pinguino.mp3");
				logger.writeFile(name.getText() + " fue a ver a los pingüinos, vio como " + pinguino.getNombre() + " saludaba.");
				
			}
		});
		
		animal4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(buho.getDato());
				player.stop();
				player.startPlaying("sounds\\buho.mp3");
				logger.writeFile(name.getText() + " fue a ver a los buhos, en realidad no vio nada, solo escuchó a " + buho.getNombre() + ".");
				
			}
		});
		
		animal5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(coyote.getDato());
				player.stop();
				player.startPlaying("sounds\\coyote.mp3");
				logger.writeFile(name.getText() + " pasaba por el habittat de los coyotes, vió a " + coyote.getNombre() + " y le recordó a una serie de dibujos.");
				
			}
		});
		
		animal6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(hiena.getDato());
				player.stop();
				player.startPlaying("sounds\\hiena.mp3");
				logger.writeFile("Al ver a las hienas " + name.getText() + " vio a " + hiena.getNombre() + ", le recordó a una pelicula que vio hace años.");
				
			}
		});
		
		animal7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(cocodrilo.getDato());
				player.stop();
				player.startPlaying("sounds\\cocodrilo.mp3");
				logger.writeFile(name.getText() + " al ver a los cocodrilos vio uno que destacaba en especial, era " + cocodrilo.getNombre() + ", hacia cosas raras.");
				
			}
		});
		
		animal8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(serpiente.getDato());
				player.stop();
				player.startPlaying("sounds\\serpiente.mp3");
				logger.writeFile(name.getText() + " no vio nada en el terrario, pero escuchó a " + serpiente.getNombre() + ", que repelús.");
				
			}
		});
		
		animal9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosAnimal.setText("");
				datosAnimal.setText(gecko.getDato());
				player.stop();
				player.startPlaying("sounds\\gecko.mp3");
				logger.writeFile(name.getText() + " no sabe porqué le hizo tanta gracia el sonido que hacia " + gecko.getNombre());
				
			}
		});
		
		//Crea una acción cuando pulsas el botón de Resumen de la visita, llama al método
		//resumenVisita de esta misma clase para que aaparezca otra ventana
		//con todas las acciones que se han ido guardando en el logger.
		resumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resumenVisita();
				
			}
		});
	}
	
	//Crea la lista con las palabras no amigables para poder verificar si el nombre es o no apto.
	public void crearLista() {
		lista = new ArrayList<String>();
		lista.add("puto");
		lista.add("puta");
	    lista.add("cabrón");
	    lista.add("cabrona");
	    lista.add("tonto");
	    lista.add("tonta");
	};
	
	//Creación de la ventana resumenVisita.
	public void resumenVisita() {
		panelMenu.setVisible(false);
		sumario = new JPanel();
		sumario.setLayout(new BorderLayout());
		setContentPane(sumario);
		JTextArea resumenVi = new JTextArea(10, 20);
		resumenVi.setEditable(false);
		resumenVi.setFont(new Font("Monospaced", Font.PLAIN, 15));
		resumenVi.setAlignmentX(Component.CENTER_ALIGNMENT);
		resumenVi.setLineWrap(true);
		sumario.add(resumenVi, BorderLayout.CENTER);
		resumenVi.setText(logger.readFile());
		
	}
	
	//Método que valida el nombre introducido por el usuario.
	//Si no es apto invocará el método de la clase InvalidNameException.
	public void validateName(String name) throws InvalidNameException {
        if (lista.contains(name.toLowerCase())) {
            throw new InvalidNameException("nombre no valido, ofensivo");
        }
    }
}

