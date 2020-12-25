package me.uwu.colapte.database;

import java.sql.*;

public class MessageDB {

    public static MessageDB db = new MessageDB();

    public MessageDB(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public String getChannelFromId(String id){
        String sql = "SELECT message_id, channel_id FROM messages";
        String cId = "";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                if(rs.getString("message_id").equals(id)){
                    cId = rs.getString("channel_id");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cId;
    }

    public String getUserFromId(String id){
        String sql = "SELECT message_id, user_id FROM messages";
        String uId = "";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                if(rs.getString("message_id").equals(id)){
                    uId = rs.getString("user_id");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return uId;
    }

    public String getMessageFromId(String id){
        String sql = "SELECT message_id, message FROM messages";
        String message = "Error :/";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                if(rs.getString("message_id").equals(id)){
                    message = rs.getString("message");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return message;
    }

    public void insert(String message_id, String channel_id, String message, String user_id) {
        String sql = "INSERT INTO messages(message_id,channel_id,message,user_id) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, message_id);
            pstmt.setString(2, channel_id);
            pstmt.setString(3, message);
            pstmt.setString(4,user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listAll(){
        String sql = "SELECT message_id, channel_id, message FROM messages";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            System.out.println("id\tchannelId\tmessage");
            while (rs.next()) {
                System.out.println(rs.getDouble("id") +  "\t" +
                        rs.getDouble("channel") + "\t" +
                        rs.getString("message"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
