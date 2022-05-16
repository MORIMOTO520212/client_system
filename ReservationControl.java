package client_system;

import java.sql.*;
import java.awt.*;

public class ReservationControl {
	//MySQLに接続するためのデータ
	Connection sqlCon;
	Statement sqlStmt;
	String sqlUserID   = "puser"; // ユーザー名
	String sqlPassword = "1234";  // パスワード

	// 予約システムのユーザID及びLogin状態
	String reservationUserID;
	private boolean flagLogin;


	//// ReservationControl クラスのコンストラクタ
	ReservationControl() {
		flagLogin = false;
	}

	//// MySQLに接続するためのメソッド
	private void connectDB () {
		try {
			Class.forName("org.git.mm.mysql.Driver"); // MySQLのドライバをLoadする
			// MySQLに接続
			String url = "jdbc.mysql://localhost?useUnicode=true&characterEncoding=SJIS";
			sqlCon = DriverManager.getConnection (url, sqlUserID, sqlPassword);
			sqlStmt = sqlCon.createStatement();
		// 例外発生時
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// MySQLから切断するためのメソッド
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
			frame.buttonLogin.setLabel("ログイン");
			frame.tfLoginID.setText("未ログイン");
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
						frame.buttonLogin.setLabel("ログアウト");
						frame.tfLoginID.setText(reservationUserID);
						res = "";
					}else {
						res = "IDまたはパスワードが違います";
					}
				}else {
					res = "IDが違います";
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			closeDB();
		}
		return res;
	}

	// 教室概要ボタン押下時の処理を行うメソッド
	public String getFacilityExplanation(String facility_id) {
		String res = "";
		connectDB();
		try {
			String sql = "SELECT * from db_reservation.facility WHERE facility_id = '" + facility_id + "';";
			ResultSet rs = sqlStmt.executeQuery(sql);
			if(rs.next()) {
				res = rs.getString("explanation");
			 }else {
				 res = "教室番号が違います。";
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 closeDB();
		 return res;
	 }
}