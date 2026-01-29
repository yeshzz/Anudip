package service;

import dao.EvidenceDAO;
import daoimpl.EvidenceDAOImpl;
import dto.EvidenceDTO;

import java.util.List;

public class EvidenceService {

    private EvidenceDAO evidenceDAO;

    public EvidenceService() {
        evidenceDAO = new EvidenceDAOImpl();
    }

    public void registerEvidence(String caseId, String description, int uploadedBy) {

        EvidenceDTO dto = new EvidenceDTO();
        dto.setCaseId(caseId);
        dto.setDescription(description);
        dto.setHashValue(String.valueOf(description.hashCode()));
        dto.setUploadedBy(uploadedBy);

        evidenceDAO.addEvidence(dto);
    }

    public void viewAllEvidence() {

        List<EvidenceDTO> list = evidenceDAO.getAllEvidence();

        if (list.isEmpty()) {
            System.out.println("No evidence found.");
            return;
        }

        System.out.println("\n------ Evidence List ------");
        for (EvidenceDTO e : list) {
            System.out.println("Evidence ID : " + e.getEvidenceId());
            System.out.println("Case ID     : " + e.getCaseId());
            System.out.println("Description : " + e.getDescription());
            System.out.println("Hash Value  : " + e.getHashValue());
            System.out.println("Uploaded By: " + e.getUploadedBy());
            System.out.println("----------------------------");
        }
    }
}
