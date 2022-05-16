package client_system;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends Dialog implements ActionListener, WindowListener {
	boolean canceled;
	TextField tfUserID;
	TextField tfPassword;

	Button buttonOK;
	Button buttonCancel;

	Panel panelNorth;
	Panel panelCenter;
	Panel panelSouth;

	public LoginDialog(Frame arg0){
		super(arg0, "Login", true);
		canceled = true;

		// テキストフィールド生成
		tfUserID = new TextField("", 10);
		tfPassword = new TextField("", 10);
		tfPassword.setEchoChar('*');

		// ボタンの生成
		buttonOK = new Button("OK");
		buttonCancel = new Button("キャンセル");

		// パネルの生成
		panelNorth = new Panel();
		panelCenter = new Panel();
		panelSouth = new Panel();

		// 上部パネルにユーザーIDテキストフィールドを追加
		panelNorth.add(new Label("ユーザID"));
		panelNorth.add(tfUserID);

		// 中央パネルにパスワードテキストフィールドを追加
		panelCenter.add(new Label("パスワード"));
		panelCenter.add(tfPassword);


		// 下部パネルに2つのボタンを追加
		panelSouth.add(buttonCancel);
		panelSouth.add(buttonOK);

		// LoginDialogをBorLayoutに設定し、3つのパネルを追加
		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		// Window Listenerを追加
		addWindowListener(this);

		// ボタンにAction Listenerを追加
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	@Override
	public void windowOpened (WindowEvent e) { // TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowClosing (WindowEvent e) {
		setVisible(false);
		canceled = true;
		dispose();
	}

	@Override
	public void windowClosed (WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowIconified (WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowDeiconified (WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonCancel) {
			canceled = true;
		} else if(e.getSource() == buttonOK) {
			canceled = false;
		}
		setVisible(false);
		dispose();
	}
}