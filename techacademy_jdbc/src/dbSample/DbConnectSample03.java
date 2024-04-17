package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnectSample03 {

    public static void main(String[] args) {
        
        Connection con =null;
        Statement stmt=null;
        ResultSet rs =null;
        
        try {
            //1.ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             //2.DBと接続する
            con =DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Xfhy_27967"
                    );
           
   
             // 3.DBとやり取りする窓口（Statementオブジェクト）の作成
            stmt=con.createStatement();
             //4,5.Select分の実行と結果を格納/代入
            String sql="SELECT*FROM country LIMIT 50";
            rs =stmt.executeQuery(sql);
            
             // 6.結果を表示する
            while( rs.next() ) {
                String name = rs.getString("Name");
                int population =rs.getInt("Population");
                System.out.println(name);
                System.out.println(population);
                }
            sql="update country set Population = 105000 where Code ='ABW'";
            int count =stmt.executeUpdate(sql);
            System.out.println(count);
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
            
            if(rs !=null) {
                try {
                    rs.close();
                }catch(SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                    }
                
                }
            if(stmt!=null) {
                try {
                    stmt.close();
                }catch(SQLException e){
                    System.err.println("Statementを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
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