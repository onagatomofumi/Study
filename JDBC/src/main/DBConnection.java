package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    //接続用の情報をフィールドに定数として定義
    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/jdbc_db";
    /** ・ユーザー名 */
    private static final String USER = "postgres";
    /** ・パスワード */
    private static final String PASS = "postgres";

    public static void main(String[] args) {

        try{
            Class.forName(POSTGRES_DRIVER);
            Connection connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

            //接続成功メッセージとコネクション情報の表示
            System.out.println("JDBCデータベース接続成功");
            System.out.println("connection = " + connection);
            connection.close();
            System.out.println("無事処理が終了");

        }catch(Exception e){
            System.out.println("JDBCデータベース接続エラー:" + e);
        }
    }
}
