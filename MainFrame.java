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
	Button	buttonLogin;
	Button  buttonExplanation;
	// 選択ボックスのインスタンス生成
	ChoiceFacility choiceFacility;
	// テキストフィールドのインスタンス生成
	TextField	tfLoginID;
	// テキストエリアのインスタンス生成
	TextArea	textMessage;


	public MainFrame(ReservationControl rc) {
		reservationControl = rc;

		/* ------------- 画面描画 --------------- */
		buttonLogin = new Button("ログイン");
		buttonExplanation = new Button("教室概要");

		// 教室選択用ボックスの生成
		choiceFacility = new ChoiceFacility();

		tfLoginID = new TextField("未ログイン");
		tfLoginID.setEditable(false);


		setLayout(new BorderLayout());

		// 上部パネルの上パネルに予約システムというラベルと【ログイン】ボタンを追加
		panelNorthSub1 = new Panel();
		panelNorthSub1.add(new Label("教室予約システム"));
		panelNorthSub1.add(buttonLogin);
		panelNorthSub1.add(new Label("		ログインID"));
		panelNorthSub1.add(tfLoginID);

		// 上部パネルの中央パネルに教室チョイス及び教室概要ボタンを追加
		panelNorthSub2 = new Panel();
		panelNorthSub2.add(new Label("教室　"));
		panelNorthSub2.add(choiceFacility);
		panelNorthSub2.add(new Label("　"));
		panelNorthSub2.add(buttonExplanation);

		// 上部パネルに2つのパネルを追加
		panelNorth = new Panel(new BorderLayout());
		panelNorth.add(panelNorthSub1, BorderLayout.NORTH);
		panelNorth.add(panelNorthSub2, BorderLayout.CENTER);

		add(panelNorth,BorderLayout.NORTH);

		panelCenter = new Panel();
		textMessage = new TextArea(20,80);
		textMessage.setEditable(false);
		panelCenter.add(textMessage);

		add(panelCenter, BorderLayout.CENTER);

		buttonLogin.addActionListener(this);
		buttonExplanation.addActionListener(this);
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
		// ログインボタン
		if(e.getSource() == buttonLogin) {
			result = reservationControl.loginLogout(this);
		// 教室概要ボタン
		} else if(e.getSource() == buttonExplanation) {
			result = reservationControl.getFacilityExplanation(choiceFacility.getSelectedItem());
		}
		textMessage.setText(result);
	}
}