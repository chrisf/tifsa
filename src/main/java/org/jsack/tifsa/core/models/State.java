package org.jsack.tifsa.core.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/2/17.
 */
public class State {
    private static String p_select_state_by_abbreviation = "SELECT * FROM State WHERE StateAbbreviation = ?";

    public static int getStateIdByAbbreviation(Connection conn, String abbreviation) throws SQLException{
        PreparedStatement pstmt = conn.prepareStatement(p_select_state_by_abbreviation);
        pstmt.setString(1, abbreviation);
        ResultSet rs = pstmt.executeQuery();
        if (rs != null && rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }
}
