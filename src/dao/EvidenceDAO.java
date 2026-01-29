package dao;

import dto.EvidenceDTO;
import java.util.List;

public interface EvidenceDAO {

    void addEvidence(EvidenceDTO evidence);

    List<EvidenceDTO> getAllEvidence();
}
