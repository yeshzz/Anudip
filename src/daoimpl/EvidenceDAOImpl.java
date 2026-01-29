package daoimpl;

import dao.EvidenceDAO;
import dto.EvidenceDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class EvidenceDAOImpl implements EvidenceDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/evidence_db",
                "root",
                "root"
        );
    }

    @Override
    public void addEvidence(EvidenceDTO evidence) {

        String sql = "INSERT INTO evidence(case_id, description, hash_value, uploaded_by) VALUES(?,?,?,?)";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, evidence.getCaseId());
            ps.setString(2, evidence.getDescription());
            ps.setString(3, evidence.getHashValue());
            ps.setInt(4, evidence.getUploadedBy());

            ps.executeUpdate();
            con.close();

            System.out.println("Evidence added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EvidenceDTO> getAllEvidence() {

        List<EvidenceDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM evidence";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EvidenceDTO dto = new EvidenceDTO();
                dto.setEvidenceId(rs.getInt("evidence_id"));
                dto.setCaseId(rs.getString("case_id"));
                dto.setDescription(rs.getString("description"));
                dto.setHashValue(rs.getString("hash_value"));
                dto.setUploadedBy(rs.getInt("uploaded_by"));

                list.add(dto);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
