
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author intel
 */
public class siswaDAO {
  private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public siswaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }  
   public boolean insertsiswa(Siswa siswa) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nim, nama, ipk) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setDouble(1, siswa.getNim());
        statement.setString(2, siswa.getNama());
        statement.setDouble(3, siswa.getIpk());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    public List<Siswa> listAllsiswa() throws SQLException {
        List<Siswa> listsiswa = new ArrayList<>();
         
        String sql = "SELECT * FROM mahasiswa";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            Double nim = resultSet.getDouble("nim");
            String nama = resultSet.getString("nama");
            Double  ipk = resultSet.getDouble("ipk");
            
            Siswa siswa1 = new Siswa (nim,nama,ipk);
            listsiswa.add(siswa1);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listsiswa;
    }
  public boolean deletesiswa(Siswa siswa) throws SQLException {
        String sql = "DELETE FROM mahasiswa where nim = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setDouble(1, siswa.getNim());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
  public boolean updatesiswa(Siswa siswa) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, ipk = ?";
        sql += " WHERE nim = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setDouble(1, siswa.getNim());
        statement.setString(2, siswa.getNama());
        statement.setDouble(3, siswa.getIpk());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
   public Siswa getsiswa(Double nim) throws SQLException {
        Siswa siswa = null;
        String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setDouble(1, nim);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nama = resultSet.getString("nama");
            Double ipk = resultSet.getDouble("ipk ");
           
             
            siswa = new Siswa(nim, nama,ipk);
        }
         
        resultSet.close();
        statement.close();
         
        return siswa;
    }
        
}
