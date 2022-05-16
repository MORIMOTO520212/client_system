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

		// �e�L�X�g�t�B�[���h����
		tfUserID = new TextField("", 10);
		tfPassword = new TextField("", 10);
		tfPassword.setEchoChar('*');

		// �{�^���̐���
		buttonOK = new Button("OK");
		buttonCancel = new Button("�L�����Z��");

		// �p�l���̐���
		panelNorth = new Panel();
		panelCenter = new Panel();
		panelSouth = new Panel();

		// �㕔�p�l���Ƀ��[�U�[ID�e�L�X�g�t�B�[���h��ǉ�
		panelNorth.add(new Label("���[�UID"));
		panelNorth.add(tfUserID);

		// �����p�l���Ƀp�X���[�h�e�L�X�g�t�B�[���h��ǉ�
		panelCenter.add(new Label("�p�X���[�h"));
		panelCenter.add(tfPassword);


		// �����p�l����2�̃{�^����ǉ�
		panelSouth.add(buttonCancel);
		panelSouth.add(buttonOK);

		// LoginDialog��BorLayout�ɐݒ肵�A3�̃p�l����ǉ�
		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		// Window Listener��ǉ�
		addWindowListener(this);

		// �{�^����Action Listener��ǉ�
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	@Override
	public void windowOpened (WindowEvent e) { // TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	public void windowClosing (WindowEvent e) {
		setVisible(false);
		canceled = true;
		dispose();
	}

	@Override
	public void windowClosed (WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	public void windowIconified (WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

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