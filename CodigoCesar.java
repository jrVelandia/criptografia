package Aplicacion_Cifrado_Codigo;

import javax.swing.JOptionPane;

public class CodigoCesar {

    public static void main(String[] args) {

        String textoentrada;
        int codigo, opcion;

        do {
            textoentrada = JOptionPane.showInputDialog("Introduce el Mensaje");
        } while (textoentrada.isEmpty());

        do {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce # posicion de cifrado: "));
        } while (codigo < 1);

        do {
            opcion = JOptionPane.showInputDialog("Deseas \n¿(C) cifrar?\n¿(D) descifrar? ").charAt(0);
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');

        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println(cifradoCesar(textoentrada, codigo));
            JOptionPane.showMessageDialog(null, "Texto cifrado: " + cifradoCesar(textoentrada, codigo));
        } else {
            System.out.println(descifradoCesar(textoentrada, codigo));
            JOptionPane.showMessageDialog(null, "Texto descifrado: " + descifradoCesar(textoentrada, codigo));
        }
        
        //------------------------------------------------------------------------------------------------------------------------  
        
        do {
            textoentrada = JOptionPane.showInputDialog("Introduce el Mensaje");
        } while (textoentrada.isEmpty());

        do {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce # posicion de cifrado: "));
        } while (codigo < 1);

        do {
            opcion = JOptionPane.showInputDialog("Deseas \n¿(C) cifrar?\n¿(D) descifrar? ").charAt(0);
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');

        if (Character.toUpperCase(opcion) == 'C') {
            JOptionPane.showMessageDialog(null, "Texto cifrado: " + cifradoCesar(textoentrada, codigo));
        } else {
            JOptionPane.showMessageDialog(null, "Texto descifrado: " + descifradoCesar(textoentrada, codigo));
        }

    }

//método para cifrar el texto
    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    //método para descifrar el texto
    public static String descifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }
}
