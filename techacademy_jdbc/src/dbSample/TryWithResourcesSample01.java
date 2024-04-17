package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class TryWithResourcesSample01 {

    public static void main(String[] args) {
        
     
        
        try {
            //1.ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "SELECT*FROM country LIMIT 50";
            
            
             try(//2.DBと接続する
            Connection con =DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Xfhy_27967");
                    
           
                    //DBとやり取りする窓口(Statementオブジェクト)の作成
                     Statement stmtStatement = con.createStatement();
                    //SQLを発行
                     ResultSet rs =stmtStatement.executeQuery(sql);){
   
             // 3.DBとやり取りする窓口（Statementオブジェクト）の作成
         
             //4,5.Select分の実行と結果を格納/代入

            
             // 6.結果を表示する
            while( rs.next() ) {
                String name = rs.getString("Name");
                
                System.out.println(name);
                
                }
                     }
             // 7.接続を閉じる
                     } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("JDBCドライバーのロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        }
    }            
        
                
}
        
         
        
        
    


