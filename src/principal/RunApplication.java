package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class RunApplication {

	public static void main(String []args) {
		List<Item> items = new ArrayList<Item>();
		String option = "";
		Item objetoItem;
		while (!option.equals("*")) {
			System.out.println("*** Facturación de tienda ***");
			System.out.println("1) Añadir producto.");
			System.out.println("2) Remover producto.");
			System.out.println("3) Listar.");
			System.out.println("4) Facturar.");
			System.out.println("Ingrese * para salir");
			System.out.print("Opción: ");
			option = new Scanner(System.in).nextLine();
			switch (option) {
			case "1":
				objetoItem = new Item();
				System.out.println();
				System.out.print("Ingrese el nombre del producto: ");
				objetoItem.nombre = new Scanner(System.in).nextLine();
				System.out.println();
				System.out.print("Ingrese la cantidad del producto: ");
				objetoItem.cantidad = new Scanner(System.in).nextInt();
				System.out.println();
				System.out.print("Ingrese el precio del producto: ");
				objetoItem.precio = new Scanner(System.in).nextDouble();
				System.out.println();
				System.out.print("Ingrese el IVA del producto: ");
				objetoItem.IVA = new Scanner(System.in).nextDouble();
				System.out.println();
				items.add(objetoItem);
				System.out.println("Producto cargado Exitosamente!");
				System.out.println();
				break;
			case "3":
				for (Item i : items) {
					System.out.println(String.format("\tNombre: %s", i.getNombre()));
					System.out.println(String.format("\tCantidad: %s", i.getCantidad()));
					System.out.println(String.format("\tPrecio: %.2f", i.getPrecio()));
					System.out.println(String.format("\tIVA: %.2f", i.getIVA()));
				}
				break;
			case "4":
				System.out.println("Generando factura");
				for(int i = 0; i<3; i++) {
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				System.out.println();
				mostrarFactura(items);
				System.out.println();
				System.out.println();
				break;
			default:
				break;
			}
		}
	}

	static void mostrarFactura(List<Item> items) {
		JasperPrint jasperPrint = null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		JasperReport report;
		try {
			report = (JasperReport) 
			        JRLoader.loadObject(RunApplication.class.getClass().getResource("/factura.jasper"));
			jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(items));
		} catch (JRException e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame("Report");
		frame.getContentPane().add(new JRViewer(jasperPrint));
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.toFront();
	}

}
