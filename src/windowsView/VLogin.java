package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin extends JFrame {
	
	public VLogin() {
		this.setTitle("����ȭ��");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel LabelId = new JLabel("ID : ");
		JLabel LabelPassword = new JLabel("Password : ");
		JTextField TxtId = new JTextField(8);
		JPasswordField TxtPassword = new JPasswordField(10);
		JButton BLogin = new JButton("�α���");
		JButton BHwewonDeungrok = new JButton("ȸ������");
		
		panel.add(LabelId);
		panel.add(TxtId);
		panel.add(LabelPassword);
		panel.add(TxtPassword);
		panel.add(BLogin);
		panel.add(BHwewonDeungrok);
		
		BLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			String id = TxtId.getText();
			String password = TxtPassword.getText();
					
			OLogin oLogin = new OLogin();
					
			oLogin.setId(id);
			oLogin.setPassword(password);
					
			CLogin cLogin = new CLogin();
			OHwewon oHwewon = cLogin.validate(oLogin);
					
			if(oHwewon != null) {
				JOptionPane.showMessageDialog(null, oHwewon.getName()+"�� �ȳ��ϼ���.");
			} else {
				JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
			}
			}
		});
		add(panel);
		
		BHwewonDeungrok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				VHwewonDeungrok vHwewondeungrok = new VHwewonDeungrok();
			}
		});;

		}
	public static void main(String[] args) {
		VLogin vLogin = new VLogin();
		vLogin.setVisible(true);
	}

}
