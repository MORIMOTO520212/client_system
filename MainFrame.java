package client_system;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame implements ActionListener, WindowListener{
	ReservationControl reservationControl;

	Panel	panelNorth;
	Panel   panelNorthSub1;
	Panel   panelNorthSub2;
	Panel	panelCenter;
	// �{�^���C���X�^���X�̐���
	Button	buttonLogin;
	Button  buttonExplanation;
	// �I���{�b�N�X�̃C���X�^���X����
	ChoiceFacility choiceFacility;
	// �e�L�X�g�t�B�[���h�̃C���X�^���X����
	TextField	tfLoginID;
	// �e�L�X�g�G���A�̃C���X�^���X����
	TextArea	textMessage;


	public MainFrame(ReservationControl rc) {
		reservationControl = rc;

		/* ------------- ��ʕ`�� --------------- */
		buttonLogin = new Button("���O�C��");
		buttonExplanation = new Button("�����T�v");

		// �����I��p�{�b�N�X�̐���
		choiceFacility = new ChoiceFacility();

		tfLoginID = new TextField("�����O�C��");
		tfLoginID.setEditable(false);


		setLayout(new BorderLayout());

		// �㕔�p�l���̏�p�l���ɗ\��V�X�e���Ƃ������x���Ɓy���O�C���z�{�^����ǉ�
		panelNorthSub1 = new Panel();
		panelNorthSub1.add(new Label("�����\��V�X�e��"));
		panelNorthSub1.add(buttonLogin);
		panelNorthSub1.add(new Label("		���O�C��ID"));
		panelNorthSub1.add(tfLoginID);

		// �㕔�p�l���̒����p�l���ɋ����`���C�X�y�ы����T�v�{�^����ǉ�
		panelNorthSub2 = new Panel();
		panelNorthSub2.add(new Label("�����@"));
		panelNorthSub2.add(choiceFacility);
		panelNorthSub2.add(new Label("�@"));
		panelNorthSub2.add(buttonExplanation);

		// �㕔�p�l����2�̃p�l����ǉ�
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
		//TODO	�����������ꂽ���\�b�h�E�X�^���v

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
		// ���O�C���{�^��
		if(e.getSource() == buttonLogin) {
			result = reservationControl.loginLogout(this);
		// �����T�v�{�^��
		} else if(e.getSource() == buttonExplanation) {
			result = reservationControl.getFacilityExplanation(choiceFacility.getSelectedItem());
		}
		textMessage.setText(result);
	}
}