package view;

import javax.swing.JOptionPane;

import controller.ProcessController;

public class Principal {

	public static void main(String[] args) {
		Main();

	}

	public static void Main() {
		ProcessController control = new ProcessController();
		Os sistema = new Os();
		String os = sistema.getOsName();
		JOptionPane pane = new JOptionPane();
		int option = 0;
		do {
			option = Integer.parseInt(pane.showInputDialog(" 1 - Listar processos ativos \n 2 - Matar processo \n 9 - Sair"));
			switch (option) {
			case 1:
				control.listProcess(os);
				break;
			case 2:
				control.killProcess(pane.showInputDialog("Digite o nome ou o PID do processo que deseja encerrar "), os);
				break;
			}
		}while (option != 9);
		
	}
	
}
