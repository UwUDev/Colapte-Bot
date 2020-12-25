package me.uwu.colapte.database;

import java.sql.*;

public class StatsDB {

    public static StatsDB db = new StatsDB();

    public StatsDB(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String id){
        double d =getXpFromId(id);
        return d != -999;
    }

    public int getXpFromId(String id){
        String sql = "SELECT id, xp FROM stats";
        int xp = -999;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                if(rs.getString("id").contains(id)){
                    xp = rs.getInt("xp");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return xp;
    }

    public int getLevelFromId(String id){
        String sql = "SELECT id, level FROM stats";
        int lvl = -999;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                if(rs.getString("id").contains(id)){
                    lvl = rs.getInt("level");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lvl;
    }

    public void setLevel(String id, int level) {
        String sql = "UPDATE stats SET level=? WHERE id=?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, level);
            pstmt.setString(2, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setXp(String id, int xp) {
        String sql = "UPDATE stats SET xp=? WHERE id=?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, xp);
            pstmt.setString(2, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        String url = "jdbc:sqlite:F:/dev/Colapte/db/test.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void insert(String id, int xp, int money, int level, int rep, double voctime, String bio) {
        String sql = "INSERT INTO stats(id,xp,money,level,rep,voctime,bio) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setInt(2, xp);
            pstmt.setInt(3, money);
            pstmt.setInt(4, level);
            pstmt.setInt(5, rep);
            pstmt.setDouble(6, voctime);
            pstmt.setString(7, bio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listAll(){
        String sql = "SELECT id, xp, money, level, rep, voctime, bio FROM stats";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getDouble("id") +  "\t" +
                        rs.getInt("xp") + "\t" +
                        rs.getInt("money") + "\t" +
                        rs.getInt("level") + "\t" +
                        rs.getInt("rep") + "\t" +
                        rs.getDouble("voctime") + "\t" +
                        rs.getString("bio"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void newUser(String id){
        insert(id, 1, 1200, 1,0, 0, "Pas de bio.");
    }

}
