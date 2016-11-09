package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import logic.Processor;

public class MainWindows extends JFrame {

	static MainWindows instancia = null;
	private static final long serialVersionUID = 1L;

	Processor processor = new Processor();

	private JLabel alu, d, ri, uc, pc, registro, ram, busDirecciones, busDatos, teclado, raton, monitor, impresora,
			parlantes;
	private JTextArea log;
	private JButton process1, process2, process3, process4, process5, process6, process7, process8, process9, process0;
	private JPanel panelAnimation, panelLog, panelProcess;

	public MainWindows() {
		setSize(1350, 730);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setTitle("CPU");
		setIconImage(new ImageIcon("").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public static MainWindows getInstancia() {
		if (instancia == null)
			instancia = new MainWindows();
		return instancia;
	};

	public void drawComponents(String nameComponent) {
		for (Component component : panelAnimation.getComponents()) {
			if (component instanceof JLabel) {
				JLabel label = (JLabel) component;
				label.setBackground(Color.BLUE);
				if (label.getText().equals(nameComponent)) {
					label.setBackground(Color.GREEN);
				}
				repaint();
			}
		}
	}

	public void drawInstructions(String line) {
		log.append(getTime() + line);
		repaint();
	}

	private String getTime() {
		return "\n [ " + Calendar.getInstance().getTime() + " ] ";
	}

	private void initComponents() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// Panel 1 - animacion
		panelAnimation = new JPanel();
		panelAnimation.setBounds(10, 10, 800, 400);
		panelAnimation.setLayout(null);
		panelAnimation.setBorder(border);
		add(panelAnimation);

		alu = new JLabel("ALU", SwingConstants.CENTER);
		alu.setBounds(20, 120, 100, 100);
		alu.setBorder(border);
		alu.setOpaque(true);
		alu.setForeground(Color.WHITE);
		alu.setBackground(Color.BLUE);
		panelAnimation.add(alu);

		d = new JLabel("D", SwingConstants.CENTER);
		d.setBounds(220, 145, 80, 80);
		d.setBorder(border);
		d.setOpaque(true);
		d.setForeground(Color.WHITE);
		d.setBackground(Color.BLUE);
		panelAnimation.add(d);

		ri = new JLabel("RI", SwingConstants.CENTER);
		ri.setBounds(230, 65, 60, 60);
		ri.setBorder(border);
		ri.setOpaque(true);
		ri.setForeground(Color.WHITE);
		ri.setBackground(Color.BLUE);
		panelAnimation.add(ri);

		uc = new JLabel("UC", SwingConstants.CENTER);
		uc.setBounds(220, 255, 80, 80);
		uc.setBorder(border);
		uc.setOpaque(true);
		uc.setForeground(Color.WHITE);
		uc.setBackground(Color.BLUE);
		panelAnimation.add(uc);

		pc = new JLabel("PC", SwingConstants.CENTER);
		pc.setBounds(90, 270, 50, 50);
		pc.setBorder(border);
		pc.setOpaque(true);
		pc.setForeground(Color.WHITE);
		pc.setBackground(Color.BLUE);
		panelAnimation.add(pc);

		registro = new JLabel("REGISTRO", SwingConstants.CENTER);
		registro.setBounds(370, 100, 100, 150);
		registro.setBorder(border);
		registro.setOpaque(true);
		registro.setForeground(Color.WHITE);
		registro.setBackground(Color.BLUE);
		panelAnimation.add(registro);

		ram = new JLabel("RAM", SwingConstants.CENTER);
		ram.setBounds(520, 100, 100, 200);
		ram.setBorder(border);
		ram.setOpaque(true);
		ram.setForeground(Color.WHITE);
		ram.setBackground(Color.BLUE);
		panelAnimation.add(ram);

		busDirecciones = new JLabel("BUS DE DIRECCIONES", SwingConstants.CENTER);
		busDirecciones.setBounds(20, 350, 600, 40);
		busDirecciones.setBorder(border);
		busDirecciones.setOpaque(true);
		busDirecciones.setForeground(Color.WHITE);
		busDirecciones.setBackground(Color.BLUE);
		panelAnimation.add(busDirecciones);

		busDatos = new JLabel("BUS DE DATOS", SwingConstants.CENTER);
		busDatos.setBounds(20, 10, 600, 40);
		busDatos.setBorder(border);
		busDatos.setOpaque(true);
		busDatos.setForeground(Color.WHITE);
		busDatos.setBackground(Color.BLUE);
		panelAnimation.add(busDatos);

		teclado = new JLabel("TECLADO", SwingConstants.CENTER);
		teclado.setBounds(670, 30, 100, 50);
		teclado.setBorder(border);
		teclado.setOpaque(true);
		teclado.setForeground(Color.WHITE);
		teclado.setBackground(Color.BLUE);
		panelAnimation.add(teclado);

		raton = new JLabel("RATON", SwingConstants.CENTER);
		raton.setBounds(670, 90, 100, 50);
		raton.setBorder(border);
		raton.setOpaque(true);
		raton.setForeground(Color.WHITE);
		raton.setBackground(Color.BLUE);
		panelAnimation.add(raton);

		monitor = new JLabel("MONITOR", SwingConstants.CENTER);
		monitor.setBounds(670, 150, 100, 50);
		monitor.setBorder(border);
		monitor.setOpaque(true);
		monitor.setForeground(Color.WHITE);
		monitor.setBackground(Color.BLUE);
		panelAnimation.add(monitor);

		impresora = new JLabel("IMPRESORA", SwingConstants.CENTER);
		impresora.setBounds(670, 210, 100, 50);
		impresora.setBorder(border);
		impresora.setOpaque(true);
		impresora.setForeground(Color.WHITE);
		impresora.setBackground(Color.BLUE);
		panelAnimation.add(impresora);

		parlantes = new JLabel("PARLANTES", SwingConstants.CENTER);
		parlantes.setBounds(670, 270, 100, 50);
		parlantes.setBorder(border);
		parlantes.setOpaque(true);
		parlantes.setForeground(Color.WHITE);
		parlantes.setBackground(Color.BLUE);
		panelAnimation.add(parlantes);

		// Panel 2 - Log
		panelLog = new JPanel();
		panelLog.setBounds(820, 10, 520, 400);
		panelLog.setLayout(null);
		panelLog.setBorder(border);
		add(panelLog);

		log = new JTextArea(getTime().replaceAll("\n", "") + "REGISTRO DE EVENTOS DEL SISTEMA");
		log.setEditable(false);
		log.setBackground(Color.BLACK);
		log.setForeground(Color.GREEN);

		JScrollPane scroll = new JScrollPane(log);
		scroll.setBounds(10, 10, 500, 340);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelLog.add(scroll);

		JButton clean = new JButton("Limpiar");
		clean.setBounds(10, 350, 500, 40);
		clean.setFocusable(false);
		clean.setForeground(Color.GREEN);
		clean.setBackground(Color.BLACK);
		clean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log.setText(getTime().replaceAll("\n", "") + "REGISTRO DE EVENTOS DEL SISTEMA");

			}
		});
		panelLog.add(clean);

		// Panel 3 - Seleccion de procesos
		panelProcess = new JPanel();
		panelProcess.setBounds(10, 420, 1330, 270);
		panelProcess.setLayout(new GridLayout(2, 0));
		add(panelProcess);

		process0 = new JButton("Proceso 0");
		process0.setBackground(Color.WHITE);
		process0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process0.getText().toLowerCase());

			}
		});
		process1 = new JButton("Proceso 1");
		process1.setBackground(Color.WHITE);
		process1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process1.getText().toLowerCase());

			}
		});
		process2 = new JButton("Proceso 2");
		process2.setBackground(Color.WHITE);
		process2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process2.getText().toLowerCase());

			}
		});
		process3 = new JButton("Proceso 3");
		process3.setBackground(Color.WHITE);
		process3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process3.getText().toLowerCase());

			}
		});
		process4 = new JButton("Proceso 4");
		process4.setBackground(Color.WHITE);
		process4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process4.getText().toLowerCase());

			}
		});
		process5 = new JButton("Proceso 5");
		process5.setBackground(Color.WHITE);
		process5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process5.getText().toLowerCase());

			}
		});
		process6 = new JButton("Proceso 6");
		process6.setBackground(Color.WHITE);
		process6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process6.getText().toLowerCase());

			}
		});
		process7 = new JButton("Proceso 7");
		process7.setBackground(Color.WHITE);
		process7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process7.getText().toLowerCase());

			}
		});
		process8 = new JButton("Proceso 8");
		process8.setBackground(Color.WHITE);
		process8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process8.getText().toLowerCase());

			}
		});
		process9 = new JButton("Proceso 9");
		process9.setBackground(Color.WHITE);
		process9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				processor.loadProcess(process9.getText().toLowerCase());

			}
		});

		panelProcess.add(process0);
		panelProcess.add(process1);
		panelProcess.add(process2);
		panelProcess.add(process3);
		panelProcess.add(process4);
		panelProcess.add(process5);
		panelProcess.add(process6);
		panelProcess.add(process7);
		panelProcess.add(process8);
		panelProcess.add(process9);
	}

	public static void main(String[] args) {
		MainWindows.getInstancia();
	}
}
