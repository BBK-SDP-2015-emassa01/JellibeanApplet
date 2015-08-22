package jbeanApplet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class JBeanApplet extends Applet implements ActionListener {

	Button okButton;
	TextField nameField;

	public void init() {
		
		setLayout(new FlowLayout());
		okButton = new Button("Search!");
		nameField = new TextField("", 35);

		add(nameField);
		add(okButton);

		okButton.addActionListener(this);
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString(nameField.getText(), 50, 100);
	}

	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == okButton) {
			repaint();
		}
		
		FakeClazz fc = new FakeClazz();
		fc.writeSomething(nameField.getText());
	}

}
