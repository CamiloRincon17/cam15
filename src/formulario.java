import javax.swing.*;
public class formulario extends JFrame {
  int num_uno = 0;
 private JLabel label1;
 public formulario(){
  setLayout(null);
  label1 =new JLabel("camilo the fuckin king");
  label1.setBounds(10,20,200,300);
  add(label1);
}

public static void main(String[] args) {
  formulario formulario1 = new formulario();
  formulario1.setBounds(0, 0, 400, 300);
  formulario1.setVisible(true);
  formulario1.setLocationRelativeTo(null);


 }
}
