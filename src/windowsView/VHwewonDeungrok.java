package windowsView;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

import control.CHwewonDeungrok;
import valueObject.OHwewon;
 
public class VHwewonDeungrok extends JFrame implements ActionListener{
    
    public VHwewonDeungrok(){
        this.setTitle("ȸ������");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
		JLabel LabelId = new JLabel("ID : ");
		JLabel LabelPassword = new JLabel("Password : ");
		JLabel LabelName = new JLabel("�̸� : ");
		JLabel LabelAddress = new JLabel("�ּ� : ");
		JLabel LabelHwakgwa = new JLabel("�а� : ");
		
		JTextField TxtId = new JTextField(8);
		JPasswordField TxtPassword = new JPasswordField(10);
		JTextField TxtName = new JTextField(8);
		JTextField TxtAddress = new JTextField(8);
		JTextField TxtHwakgwa = new JTextField(8);
		JButton BHwewonDeungrok = new JButton("ȸ������");
        
        panel.add(LabelId);
        panel.add(TxtId);
        panel.add(LabelPassword);
        panel.add(TxtPassword);
        panel.add(LabelName);
        panel.add(TxtName);
        panel.add(LabelAddress);
        panel.add(TxtAddress);
        panel.add(LabelHwakgwa);
        panel.add(TxtHwakgwa);
        panel.add(BHwewonDeungrok);

        
        BHwewonDeungrok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String id = TxtId.getText();
        		String password = TxtPassword.getText();
        		String name = TxtName.getText();
        		String address = TxtAddress.getText();
        		String hwakgwa = TxtHwakgwa.getText();
        		
        		OHwewon oHwewon = new OHwewon();
        		CHwewonDeungrok cHwewonDeungrok = new CHwewonDeungrok();
        		
        		oHwewon.setId(id);
        		oHwewon.setPassword(password);
        		oHwewon.setName(name);
        		oHwewon.setAddress(address);
        		oHwewon.setHwakgwa(hwakgwa);
        		
        		cHwewonDeungrok.saveHwewon(oHwewon);
        		JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�.");
        		
        	}
        });
        
        add(panel);
        
        setVisible(true);
    }
        
    public static void main(String[] args) {
        new VHwewonDeungrok();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
