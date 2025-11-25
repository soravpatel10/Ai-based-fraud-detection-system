package dao;

import db.Database;
import model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public List<Transaction> getAllTransactions() throws Exception {
        List<Transaction> list = new ArrayList<>();
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM transactions");

        while(rs.next()){
            list.add(new Transaction(
                rs.getInt("id"),
                rs.getInt("userId"),
                rs.getDouble("amount")
            ));
        }

        return list;
    }

    public void updateFlag(int id, boolean isFraud) throws Exception {
        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE transactions SET flagged=? WHERE id=?");
        ps.setBoolean(1, isFraud);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}
