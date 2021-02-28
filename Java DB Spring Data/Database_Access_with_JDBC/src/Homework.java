import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Homework {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String MINONS_DB = "minions_db";

    Connection connection;

    public void initialise(String user, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        connection = DriverManager.getConnection(CONNECTION_URL + MINONS_DB, props);
    }

    public void getVillainsNames() throws SQLException {
        String query = "SELECT v.name,COUNT(mv.minion_id) AS cnt FROM villains AS v " +
                "JOIN minions_villains AS mv  ON v.id=villain_id GROUP BY v.name HAVING  cnt>15 " +
                "ORDER BY cnt DESC";
        PreparedStatement stmt = connection.prepareStatement(query);
        //   stmt.setDouble(1, Double.parseDouble());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %s%n", rs.getString("name"), rs.getString("cnt"));
        }
    }


    public void getMinionNames(int villain_id) throws SQLException {

        String villainName = getEntityName(villain_id, "villains");

        if (villainName != null) {
            System.out.printf("Villain: %s%n", villainName);
            String query = "SELECT m.name AS minion ,m.age AS age FROM minions_villains AS mv " +
                    "JOIN minions AS m ON m.id=minion_id " +
                    "WHERE villain_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, villain_id);
            ResultSet rs = stmt.executeQuery();
            int i = 1;
            while (rs.next()) {
                System.out.printf("%d. %s %d %n", i++, rs.getString("minion"), rs.getInt("age"));
            }
        } else {
            System.out.println("No villain with ID 10 exists in the database.");
        }

    }

    private String getEntityName(int id, String tableName) throws SQLException {
        String query = String.format("SELECT name  FROM %s  WHERE id = ?", tableName);
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getString("name") : null;
    }

    public void addMinion() throws IOException, SQLException {
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter minion info(name,age and town name): ");
        String minionData = reader.readLine();
        System.out.print("Please enter villain name: ");
        String villainData = reader.readLine();
        String[] tokensMinion = minionData.split("\\s+");
        String[] tokensVillain = minionData.split("\\s+");
        int townId = getEntityId(tokensMinion[2], "towns");
        if (townId == -1) {
            String query = String.format("INSERT INTO %s (name) VALUE(?) ", "towns");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tokensMinion[2]);
            stmt.executeUpdate();
            townId = getEntityId(tokensMinion[2], "towns");
        }
        int vilianId = getEntityId(tokensVillain[1], "villains");
        if (vilianId == -1) {
            String query = String.format("INSERT INTO %s (name,evilness_factor) VALUE(?,?) ", "villains");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tokensVillain[1]);
            stmt.setString(2, "evil");
            stmt.executeUpdate();
            vilianId = getEntityId(tokensVillain[1], "villains");
            System.out.printf("Villain %s was added to the database.%n", tokensVillain[0]);
        }
        String queryMinon = String.format("INSERT INTO %s (name,age,town_id) VALUE(?,?,?) ", "minions");
        PreparedStatement stmt = connection.prepareStatement(queryMinon);
        stmt.setString(1, tokensMinion[0]);
        stmt.setInt(2, Integer.parseInt(tokensMinion[1]));
        stmt.setInt(3, townId);
        stmt.executeUpdate();
        int minionId = getEntityId(tokensMinion[0], "minions");
        String queryRelation = String.format("INSERT INTO %s (minion_id,villain_id) VALUE(?,?) ", "minions_villains");
        PreparedStatement stmtRelation = connection.prepareStatement(queryRelation);
        stmtRelation.setInt(1, minionId);
        stmtRelation.setInt(2, vilianId);
        stmtRelation.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", tokensMinion[0], tokensVillain[0]);
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id  FROM %s  WHERE name = ? ", tableName);
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getInt("id") : -1;
    }

    public void changeTownName() throws IOException, SQLException {
        System.out.println();
        System.out.printf("Please enter country name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();
        System.out.println();
        String query = "UPDATE name=UPDATE(name) FROM towns  WHERE country = ? ";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, country);
        int cnt = stmt.executeUpdate();
        if (cnt == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.%n", cnt);
            String queryTonws = "SELECT name FROM towns  WHERE country = ? ";
            PreparedStatement stmtTowns = connection.prepareStatement(queryTonws);
            stmtTowns.setString(1, country);
            ResultSet rs = stmtTowns.executeQuery();
            List<String> affectedTowns = new ArrayList<>();
            while (rs.next()) {
                affectedTowns.add(rs.getString("name"));
            }
            System.out.printf("[%s]", String.join(", ", affectedTowns));
        }

    }

    public void removeillain() throws IOException, SQLException {
        System.out.println();
        System.out.printf("Please enter villain Id: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());
        String villainName = getEntityName(villainId, "villains");
        String query = "DELETE FROM minions_villains  WHERE villain_id = ? ";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, villainId);
        int cnt = stmt.executeUpdate();
        String queryVillain = "DELETE FROM villains  WHERE id = ? ";
        PreparedStatement stmtVillain = connection.prepareStatement(queryVillain);
        stmtVillain.setInt(1, villainId);
        stmtVillain.executeUpdate();
        System.out.printf("%s was deleted%n", villainName);
        System.out.printf("%d minions released", cnt);
    }

    public void printAllMinionsNames() throws SQLException {
        String query = "SELECT name FROM minions";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayDeque<String> minionsNames = new ArrayDeque<>();
        while (rs.next()) {
            minionsNames.add(rs.getString("name"));
        }
        while (!minionsNames.isEmpty()) {
            System.out.println(minionsNames.pop());
            if (!minionsNames.isEmpty()) {
                System.out.println(minionsNames.poll());
            }
            ;
        }
    }

    public void increaseMinionsAge() throws IOException, SQLException {
        System.out.println();
        System.out.printf("Please enter minions Id's(separated by coma): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String minionsId = reader.readLine();
        String query = "UPDATE name=LOWER(name),age=age+1 FROM minions  WHERE id IN (?) ";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, minionsId);
        int cnt = stmt.executeUpdate();
        String queryMinions = "SELECT name,age FROM minions  WHERE id IN (?)  ";
        PreparedStatement stmtMinions = connection.prepareStatement(queryMinions);
        stmtMinions.setString(1, minionsId);
        ResultSet rs = stmtMinions.executeQuery();
        List<String> affectedTowns = new ArrayList<>();
        while (rs.next()) {
            affectedTowns.add(rs.getString("name") + " " + rs.getInt("age"));
        }

    }

    public void increaseAgeProcedure() throws IOException, SQLException {
        /*
        DELIMITER $$
        CREATE PROCEDURE `usp_get_older` (id INT)
        BEGIN
        UPDATE minions AS m
        SET m.age=m.age+1
        WHERE m.id=id;
        END $$
        DELIMITER ;
        */
        System.out.println();
        System.out.printf("Please enter minion Id: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minionsId = Integer.parseInt(reader.readLine());
        String query = "CALL usp_get_older(?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, minionsId);
        stmt.executeQuery();
        String queryMinions = "SELECT name,age FROM minions  WHERE id = ? ";
        PreparedStatement stmtMinions = connection.prepareStatement(queryMinions);
        stmtMinions.setInt(1, minionsId);
        ResultSet rs = stmtMinions.executeQuery();
        rs.next();
        System.out.printf("%s %d",rs.getString("name"),rs.getInt("age"));
    }
}
