package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectSample01 {

    public static void main(String[] args) {
        
        Connection con =null;
        
        try {
            //1.ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driber");
            
             //2.DBと接続する
            con =DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Xfhy_27967"
                    );
             // 3.DBとやり取りする窓口（Statementオブジェクト）の作成
             //4,5.Select分の実行と結果を格納/代入
             // 6.結果を表示する
   
             // 7.接続を閉じる
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("JDBCドライバーのロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        }finally {
            
            if(con !=null) {
                try {
                    con.close();
                }catch(SQLException e) {
                    System.err.println("データベース切断時にエラーが発生しました。");
                    e.printStackTrace();
                }
            }
        }
         
        
        
    }


}