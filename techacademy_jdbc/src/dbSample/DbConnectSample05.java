package dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class DbConnectSample05 {

    public static void main(String[] args) {
        
        Connection con =null;
        PreparedStatement pstmt=null;
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
            String sql="INSERT INTO city(Name,CountryzCode,District,Population) VALUES ('Rafah',?,'Rafah',?)";
   
             // 3.DBとやり取りする窓口（Statementオブジェクト）の作成
            pstmt=con.prepareStatement(sql);
            
             //4,5.Select分の実行と結果を格納/代入
            System.out.print("CountrCodeを入力してください>");
            String str1 = keyIn();
            
            System.out.print("Populationを数字で入力してください>");
            int num1 =Integer.parseInt(keyIn());
            
            pstmt.setString(1, str1);
            pstmt.setInt(2, num1);
            
            int count =pstmt.executeUpdate();
            System.out.println(count);
            
            
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
            
            if(rs !=null) {
                try {
                    rs.close();
                }catch(SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                    }
            }
                }
            if(pstmt!=null) {
                try {
                    pstmt.close();
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
    /*
     * キーボードから入力された値をStringで返す　引数：なし　戻り値：入力された文字列
     */
    private static String keyIn() {
        String line =null;
        try {
            BufferedReader key =new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();
        }catch(IOException e) {
        }
        return line;
         
    }
        
    }

