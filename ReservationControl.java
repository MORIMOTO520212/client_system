package client_system;

import java.sql.*;
import java.awt.*;

public class ReservationControl {
	//MySQL�ɐڑ����邽�߂̃f�[�^
	Connection sqlCon;
	Statement sqlStmt;
	String sqlUserID   = "puser"; // ���[�U�[��
	String sqlPassword = "1234";  // �p�X���[�h

	// �\��V�X�e���̃��[�UID�y��Login���
	String reservationUserID;
	private boolean flagLogin;


	//// ReservationControl �N���X�̃R���X�g���N�^
	ReservationControl() {
		flagLogin = false;
	}

	//// MySQL�ɐڑ����邽�߂̃��\�b�h
	private void connectDB () {
		try {
			Class.forName("org.git.mm.mysql.Driver"); // MySQL�̃h���C�o��Load����
			// MySQL�ɐڑ�
			String url = "jdbc.mysql://localhost?useUnicode=true&characterEncoding=SJIS";
			sqlCon = DriverManager.getConnection (url, sqlUserID, sqlPassword);
			sqlStmt = sqlCon.createStatement();
		// ��O������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// MySQL����ؒf���邽�߂̃��\�b�h
	private void closeDB() {
		try {
			sqlStmt.close();
			sqlCon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public	String loginLogout(MainFrame frame) {
		String res = "";
		if(flagLogin) {
			flagLogin = false;
			frame.buttonLogin.setLabel("���O�C��");
			frame.tfLoginID.setText("�����O�C��");
		}else {

			LoginDialog ld = new LoginDialog(frame);
			ld.setBounds(100,100,350,150);
			ld.setResizable(false);
			ld.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);


			if(ld.canceled) {
				return "";
			}
			reservationUserID = ld.tfUserID.getText();
			String password = ld.tfPassword.getText();

			connectDB();

			try {

				String sql = "SELECT * FROM db_reservation.user_id ='" + reservationUserID + "';";

				ResultSet rs = sqlStmt.executeQuery(sql);

				if(rs.next()) {
					String password_from_db = rs.getString(password);
					if (password_from_db.equals(password)) {
						flagLogin = true;
						frame.buttonLogin.setLabel("���O�A�E�g");
						frame.tfLoginID.setText(reservationUserID);
						res = "";
					}else {
						res = "ID�܂��̓p�X���[�h���Ⴂ�܂�";
					}
				}else {
					res = "ID���Ⴂ�܂�";
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			closeDB();
		}
		return res;
	}

	// �����T�v�{�^���������̏������s�����\�b�h
	public String getFacilityExplanation(String facility_id) {
		String res = "";
		connectDB();
		try {
			String sql = "SELECT * from db_reservation.facility WHERE facility_id = '" + facility_id + "';";
			ResultSet rs = sqlStmt.executeQuery(sql);
			if(rs.next()) {
				res = rs.getString("explanation");
			 }else {
				 res = "�����ԍ����Ⴂ�܂��B";
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 closeDB();
		 return res;
	 }
}