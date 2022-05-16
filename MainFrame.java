package client_system;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame implements ActionListener, WindowListener{
	ReservationControl reservationControl;

	Panel	panelNorth;
	Panel   panelNorthSub1;
	Panel   panelNorthSub2;
	Panel	panelCenter;
	// ボタンインスタンスの生成
	Button	buttonLog;

	TextField	tfLoginID;

	TextArea	textMessage;


	public MainFrame(ReservationControl rc) {
		reservationControl = rc;

		buttonLog = new Button("ログイン");


		tfLoginID = new TextField("未ログイン");
		tfLoginID.setEditable(false);


		setLayout(new BorderLayout());

		panelNorth = new Panel();
		panelNorth.add(new Label("教室予約システム"));
		panelNorth.add(buttonLog);
		panelNorth.add(new Label("		ログインID"));
		panelNorth.add(tfLoginID);


		add(panelNorth,BorderLayout.NORTH);

		panelCenter = new Panel();
		textMessage = new TextArea(20,80);
		textMessage.setEditable(false);
		panelCenter.add(textMessage);

		add(panelCenter, BorderLayout.CENTER);

		buttonLog.addActionListener(this);
		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		//TODO	自動生成されたメソッド・スタンプ

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String result = new String();
		if(e.getSource() == buttonLog) {
			result = reservationControl.loginLogout(this);
		}
		textMessage.setText(result);
	}
}